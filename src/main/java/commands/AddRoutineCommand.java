package commands;

import exercises.RoutineEngine;

import java.util.List;

public class AddRoutineCommand implements Command {
    private final RoutineEngine routineEngine;

    public AddRoutineCommand(RoutineEngine routineEngine) {
        this.routineEngine = routineEngine;
    }

    @Override
    public final void execute(List<String> args) {
        if (args.size() < 2) {
            System.out.println("Not enough arguments for adding a routine.");
            return;
        }
        String name = args.get(0);
        String instructions = args.get(1);
        List<String> exerciseArgs = args.subList(2, args.size());
        routineEngine.createRoutine(name, instructions, exerciseArgs);
    }
}
