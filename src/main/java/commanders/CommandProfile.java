package commanders;

import java.util.List;

import commands.Command;
import commands.exercise.HelpExerciseCommand;
import commands.profile.ChangeGoalsCommand;
import commands.profile.ChangeHeightCommand;
import commands.profile.ChangeWeightCommand;
import commands.profile.GetStatusCommand;
import profile.Profile;

public class CommandProfile extends CommandMap {
    static final String GET_STATUS = "get-status";
    static final String CHANGE_HEIGHT = "change-height";
    static final String CHANGE_WEIGHT = "change-weight";
    static final String CHANGE_GOALS = "change-goals";
    static final String HELP = "help";

    private final Profile profile;

    public CommandProfile(Profile profile) {
        this.profile = profile;
        addToMap();
    }

    private void addToMap() {
        addToMap(GET_STATUS, new GetStatusCommand(profile));
        addToMap(CHANGE_HEIGHT, new ChangeHeightCommand(profile));
        addToMap(CHANGE_WEIGHT, new ChangeWeightCommand(profile));
        addToMap(CHANGE_GOALS, new ChangeGoalsCommand(profile));
        addToMap(HELP, new HelpExerciseCommand());

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

