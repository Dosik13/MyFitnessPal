package commanders;

import java.util.List;

import commands.exercise.AddRoutineCommand;
import commands.Command;
import commands.exercise.HelpExerciseCommand;
import commands.exercise.LogRoutineCommand;
import commands.exercise.PrintAllLogsForRoutineCommand;
import commands.exercise.PrintRoutinesCommand;
import commands.exercise.RemoveRoutineCommand;
import exercises.RoutineEngine;

public class CommandExercises extends CommandMap {
    static final String ADD_ROUTINE = "add-routine";
    static final String REMOVE_ROUTINE = "remove-routine";
    static final String PRINT_ROUTINE = "print-routine";
    static final String HELP = "help";
    static final String LOG_ROUTINE = "log-routine";
    static final String PRINT_LOGS = "print-logs";

    private final RoutineEngine engine;

    public CommandExercises(RoutineEngine engine) {
        this.engine = engine;
        addToMap();
    }

    private void addToMap() {
        addToMap(ADD_ROUTINE, new AddRoutineCommand(engine));
        addToMap(REMOVE_ROUTINE, new RemoveRoutineCommand(engine));
        addToMap(PRINT_ROUTINE, new PrintRoutinesCommand(engine));
        addToMap(HELP, new HelpExerciseCommand());
        addToMap(LOG_ROUTINE, new LogRoutineCommand(engine));
        addToMap(PRINT_LOGS, new PrintAllLogsForRoutineCommand(engine));
    }

    public final void executeCommand(List<String> args) {
        if (args.isEmpty()) {
            System.out.println("Please provide a command.");
            return;
        }
        Command command = getCommand(args.get(0));
        if (command == null) {
            System.out.println("Command not found.");
            return;
        }

        command.execute(args.subList(1, args.size()));
    }
}
