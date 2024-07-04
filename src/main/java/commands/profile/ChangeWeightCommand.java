package commands.profile;

import commands.Command;
import profile.Profile;

import java.util.List;

public class ChangeWeightCommand implements Command {
    private final Profile profile;

    public ChangeWeightCommand(Profile profile) {
        this.profile = profile;
    }

    @Override
    public final void execute(List<String> args) {
        if (args.size() != 1) {
            System.out.println("Not enough arguments for changing weight.");
            return;
        }
        profile.changeWeight(Integer.parseInt(args.get(0)));
    }
}


