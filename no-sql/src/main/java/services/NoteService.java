package services;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import entities.Note;
import org.bson.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.text;

/**
 * Created by Nikolay Shuvaev on 25.06.2017.
 */
public class NoteService {
    private static final String COLLECTION = "notes";
    private static final String CREATED_DATE = "createdDate";
    private static final String TAG = "tag";
    private static final String TEXT = "text";

    private MongoCollection<Document> notes;

    public NoteService() {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("local");
        notes = database.getCollection(COLLECTION);
        notes.createIndex(new Document()
                                .append(TAG, "text")
                                .append(TEXT, "text"));


    }

    public void save(Note note) {
        notes.insertOne(getDocumentFromNote(note));
    }

    public List<Note> findAll() {
        MongoCursor<Document> iterator = notes.find().iterator();
        return toList(iterator);
    }

    public List<Note> findByTag(String tag) {
        MongoCursor<Document> iterator = notes.find(eq(TAG, tag)).iterator();
        return toList(iterator);
    }

    public List<Note> findByTextSearch(String search) {
        MongoCursor<Document> iterator = notes.find(text(search)).iterator();
        return toList(iterator);
    }

    private static Note getNoteFromDate(Document doc) {
        return new Note(
                LocalDate.parse(doc.getString(CREATED_DATE)),
                doc.getString(TAG),
                doc.getString(TEXT)
            );
    }

    private static Document getDocumentFromNote(Note note) {
        return new Document()
                .append(CREATED_DATE, note.getCreatedDate().toString())
                .append(TAG, note.getTag())
                .append(TEXT, note.getText());
    }

    private static List<Note> toList(MongoCursor<Document> iterator) {
        List<Note> notes = new ArrayList<>();
        while (iterator.hasNext()) {
            Document doc = iterator.next();
            notes.add(getNoteFromDate(doc));
        }
        return notes;
    }
}
