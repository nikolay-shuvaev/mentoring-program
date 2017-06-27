package menu;

import entities.Note;
import services.NoteService;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Nikolay Shuvaev on 27.06.2017.
 */
public class FindByTagCommand implements Command {
    private NoteService service;

    public FindByTagCommand(NoteService service) {
        this.service = service;
    }

    @Override
    public String getCommand() {
        return "2";
    }

    @Override
    public void process(Scanner scanner) {
        System.out.print("Enter tag: ");
        String tag = scanner.nextLine();

        List<Note> tags = service.findByTag(tag);
        printResult(tags);
    }

    private void printResult(List<Note> tags) {
        System.out.println("Result:");
        tags.forEach(System.out::println);
    }

    @Override
    public String getCommandPrompt() {
        return getCommand() + " - Find record by tag";
    }
}
