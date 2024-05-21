package commands;

import exercises.RoutineEngine;

import java.util.List;

public class PrintRoutinesCommand implements Command {
    private final RoutineEngine routineEngine;

    public PrintRoutinesCommand(RoutineEngine routineEngine) {
        this.routineEngine = routineEngine;
    }

    @Override
    public final void execute(List<String> args) {
        routineEngine.printRoutineList();
    }
}
