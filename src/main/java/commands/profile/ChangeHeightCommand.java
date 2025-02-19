package commands.profile;

import commands.Command;
import profile.Profile;

import java.util.List;

public class ChangeHeightCommand implements Command {
    private final Profile profile;

    public ChangeHeightCommand(Profile profile) {
        this.profile = profile;
    }

    @Override
    public final void execute(List<String> args) {
        if (args.size() != 1) {
            System.out.println("Not enough arguments for changing height.");
            return;
        }
        profile.changeHeight(Integer.parseInt(args.get(0)));
    }
}

