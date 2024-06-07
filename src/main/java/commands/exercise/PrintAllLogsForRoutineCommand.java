package commands.exercise;

import commands.Command;
import exercises.RoutineEngine;

import java.util.List;

public class PrintAllLogsForRoutineCommand implements Command {
    private RoutineEngine routineEngine;

    public PrintAllLogsForRoutineCommand(RoutineEngine routineEngine) {
        this.routineEngine = routineEngine;
    }

    @Override
    public final void execute(List<String> args) {
        if (args.isEmpty()) {
            System.out.println("Please provide the routine name.");
            return;
        }

        String routineName = args.get(0);
        routineEngine.printRoutineLogs(routineName);
    }
}
