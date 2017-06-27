package menu;

import entities.Note;
import services.NoteService;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by Nikolay Shuvaev on 27.06.2017.
 */
public class AddNoteCommand implements Command {
    private NoteService service;

    public AddNoteCommand(NoteService service) {
        this.service = service;
    }

    @Override
    public String getCommand() {
        return "1";
    }

    @Override
    public void process(Scanner scanner) {
        System.out.print("Enter note date (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Enter note tag: ");
        String tag = scanner.nextLine();
        System.out.print("Enter note text: ");
        String text = scanner.nextLine();

        Note note = new Note(LocalDate.parse(date), tag, text);
        service.save(note);
    }

    @Override
    public String getCommandPrompt() {
        return getCommand() + " - Add new note";
    }

}
