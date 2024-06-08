package commands.water;

import commands.Command;

import java.util.List;

public class HelpWaterCommand implements Command {
    @Override
    public final void execute(List<String> args) {
        System.out.println("Available commands:");
        System.out.println("print <date> - prints the drunk amount for the given date");
        System.out.println("print-all - prints the drunk amount for all dates");
        System.out.println("log <small | medium | large | custom> <custom amount> <dd-MM-yyyy> "
            + "- log standard amount or custom amount for the given date");
        System.out.println("goal - get the current daily water goal");
        System.out.println("change <new goal> - change the daily water goal");
        System.out.println("help - Display this message");
        System.out.println("back - Return to main menu");
    }
}
