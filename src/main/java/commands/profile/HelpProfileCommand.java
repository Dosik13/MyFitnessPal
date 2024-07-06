package commands.profile;

import commands.Command;

import java.util.List;

public class HelpProfileCommand implements Command {
    @Override
    public final void execute(List<String> args) {
        System.out.println("Available commands:");
        System.out.println("get-status - Get status");
        System.out.println("change-height - Change height\n"
            + "change-height <height>");
        System.out.println("change-weight - Change weight\n"
            + "change-weight <weight>");
        System.out.println("change-goals - Change goals\n"
            + "change-goals <new goal> <new goal> ...");
        System.out.println("help - Display this message");
        System.out.println("back - Return to main menu");
    }
}

