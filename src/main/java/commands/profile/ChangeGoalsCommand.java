package commands.profile;

import commands.Command;
import profile.Goal;
import profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class ChangeGoalsCommand implements Command {
    private final Profile profile;

    public ChangeGoalsCommand(Profile profile) {
        this.profile = profile;
    }

    @Override
    public final void execute(List<String> args) {
        if (args.isEmpty()) {
            System.out.println("Not enough arguments for changing goals.");
            return;
        }

        List<Goal> goals = new ArrayList<>();
        for (String goal : args) {
            goals.add(Goal.getFromString(goal));
        }

        profile.changeGoals(goals);
    }
}

