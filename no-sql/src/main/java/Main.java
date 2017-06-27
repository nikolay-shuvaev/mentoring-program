import menu.AddNoteCommand;
import menu.FindByTagCommand;
import menu.FullTextSearchCommand;
import menu.Menu;
import services.NoteService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NoteService service = new NoteService();

        new Menu(Arrays.asList(
                new AddNoteCommand(service),
                new FindByTagCommand(service),
                new FullTextSearchCommand(service)
            ))
            .process();
    }

}