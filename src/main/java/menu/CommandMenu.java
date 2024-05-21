package menu;

import commands.Command;
import commanders.CommandExercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CommandMenu {
    private final Map<String, Command> commandMap = new HashMap<>();
    private final Scanner scanner;
    static final String BACK = "back";

    public CommandMenu(Scanner scanner, CommandExercises commandExercises) {
        this.scanner = scanner;
        initCommands(commandExercises);
    }

    private void initCommands(CommandExercises commandExercises) {
        commandMap.put("exercises", new ExercisesMenuCommand(commandExercises));
    }

    public final void start() {
        Command cmd = null;
        while (true) {
            if (cmd == null) {
                System.out.println("Enter an engine: ");
                String command = scanner.nextLine();
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

    private void showMenu() {
        System.out.println("Commands: ");
        System.out.println("exercises - Exercise commands");
        System.out.println("food - Food commands");
        System.out.println("water - Water commands");
        System.out.println("help - Show all commands");
        System.out.println("exit - Exit the program");
    }
}
