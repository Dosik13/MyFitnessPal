package menu;

import commands.Command;
import commanders.CommandExercises;

import java.util.List;

public class ExercisesMenuCommand implements Command {
    private final CommandExercises commandExercises;

    public ExercisesMenuCommand(CommandExercises commandExercises) {
        this.commandExercises = commandExercises;
    }

    @Override
    public final void execute(List<String> args) {
        commandExercises.executeCommand(args);
    }
}
