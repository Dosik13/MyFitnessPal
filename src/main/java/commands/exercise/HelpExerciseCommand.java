package commands.exercise;

import commands.Command;

import java.util.List;

public class HelpExerciseCommand implements Command {
    @Override
    public final void execute(List<String> args) {
        System.out.println("Available commands:");
        System.out.println("add-routine - Add a new routine\n"
                + "add <routine name> <instructions> <exercise1 name> <sets> <reps> <kg>,...");
        System.out.println("remove-routine - Remove routine\n"
                + "remove <routine name>");
        System.out.println("print-routine - Print all routines\nprint");
        System.out.println("log-routine - Log a routine\n"
        + "log <yyyy-MM-dd> <routine name>");
        System.out.println("print-logs - Print all dates logged for a routine\n"
                + "print-logs <routine name>");
        System.out.println("help - Display this message");
        System.out.println("back - Return to main menu");
    }
}
