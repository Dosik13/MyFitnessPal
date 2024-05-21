package commands;

import exercises.RoutineEngine;

import java.util.List;

public class RemoveRoutineCommand implements Command {
    private final RoutineEngine routineEngine;

    public RemoveRoutineCommand(RoutineEngine routineEngine) {
        this.routineEngine = routineEngine;
    }

    @Override
    public final void execute(List<String> args) {
        if (!args.isEmpty()) {
            String name = args.get(0);
            routineEngine.removeRoutineByName(name);
        } else {
            System.out.println("No routine name provided.");
        }
    }
}
