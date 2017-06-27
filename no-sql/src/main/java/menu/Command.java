package menu;

import java.util.Scanner;

/**
 * Created by Nikolay Shuvaev on 27.06.2017.
 */
public interface Command {
    String getCommand();

    void process(Scanner scanner);

    String getCommandPrompt();


}
