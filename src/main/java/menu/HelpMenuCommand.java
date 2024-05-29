package menu;

import commands.Command;

import java.util.List;

public class HelpMenuCommand implements Command {
    @Override
    public final void execute(List<String> args) {
        System.out.println("Commands: ");
        System.out.println("exercises - Exercise commands");
        System.out.println("food - Food commands");
        System.out.println("water - Water commands");
        System.out.println("help - Show all commands");
        System.out.println("exit - Exit the program");
    }
}
