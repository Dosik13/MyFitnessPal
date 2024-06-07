package commands.exercise;

import commands.Command;
import exercises.RoutineEngine;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class LogRoutineCommand implements Command {
    private final RoutineEngine routineEngine;

    public LogRoutineCommand(RoutineEngine routineEngine) {
        this.routineEngine = routineEngine;
    }

    @Override
    public final void execute(List<String> args) {
        System.out.println(Arrays.toString(args.toArray()));
        if (args.size() < 2) {
            System.out.println("Not enough arguments for logging a routine.");
            return;
        }

        LocalDate date = LocalDate.parse(args.get(0));
        String routineName = args.get(1);
        routineEngine.logRoutine(date, routineName);
    }
}
