package menu;

import commands.Command;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CommandMenu {
    private final Map<String, Command> commandMap;
    private final Scanner scanner;
    static final String BACK = "back";
    static final String EXIT = "exit";

    public CommandMenu(Scanner scanner, Map<String, Command> commandMap) {
        this.commandMap = commandMap;
        this.scanner = scanner;
    }

    public final void start() {
        Command cmd = null;
        while (true) {
            if (cmd == null) {
                System.out.println("Enter an engine: ");
                String command = scanner.nextLine();
                if (command.equalsIgnoreCase(EXIT)) {
                    System.out.println("Exiting the program!");
                    break;
                }
                cmd = commandMap.get(command.toLowerCase());
                if (cmd == null) {
                    System.out.println("Invalid engine");
                }
            } else {
                System.out.println("Enter a command: ");
                String command = scanner.nextLine();
                if (command.equalsIgnoreCase(BACK)) {
                    cmd = null;
                    continue;
                }
                List<String> output = Arrays.asList(command.split(" "));
                cmd.execute(output);
            }
        }
    }
}
