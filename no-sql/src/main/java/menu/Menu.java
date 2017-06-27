package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nikolay Shuvaev on 27.06.2017.
 */
public class Menu {
    private List<Command> commands = new ArrayList<>();

    public Menu(List<Command> commands) {
        this.commands.addAll(commands);
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String newCommand = getUserInput(scanner);
            if ("exit".equals(newCommand)) {
                break;
            }
            for (Command command : commands) {
                if (newCommand.equals(command.getCommand())) {
                    try {
                        command.process(scanner);
                    } catch (Exception e) {
                        System.out.println("Error during process command: " + e.getMessage());
                    }
                }
            }
        }
    }

    private String getUserInput(Scanner scanner) {
        System.out.print("Enter command: ");
        return scanner.nextLine();
    }

    private void printMenu() {
        System.out.println("\r\nMain Menu");
        commands.forEach(command -> System.out.println(command.getCommandPrompt()));
    }
}