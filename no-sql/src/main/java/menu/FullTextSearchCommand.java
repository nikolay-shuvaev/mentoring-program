package menu;

import entities.Note;
import services.NoteService;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Nikolay Shuvaev on 27.06.2017.
 */
public class FullTextSearchCommand implements Command {
    private NoteService service;

    public FullTextSearchCommand(NoteService service) {
        this.service = service;
    }

    @Override
    public String getCommand() {
        return "3";
    }

    @Override
    public void process(Scanner scanner) {
        System.out.print("Search: ");
        String search = scanner.nextLine();

        List<Note> result = service.findByTextSearch(search);
        printResult(result);
    }

    private void printResult(List<Note> tags) {
        System.out.println("Result:");
        tags.forEach(System.out::println);
    }

    @Override
    public String getCommandPrompt() {
        return getCommand() + " - Full text search";
    }
}
