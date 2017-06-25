package entities;

import java.time.LocalDate;

/**
 * Created by Nikolay Shuvaev on 25.06.2017.
 */
public class Note {
    private LocalDate createdDate;
    private String tag;
    private String text;

    public Note(LocalDate createdDate, String tag, String text) {
        this.createdDate = createdDate;
        this.tag = tag;
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public String getTag() {
        return tag;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "createdDate=" + createdDate +
                ", tag='" + tag + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
