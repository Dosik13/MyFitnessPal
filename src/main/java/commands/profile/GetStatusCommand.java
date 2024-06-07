package commands.profile;

import commands.Command;
import profile.Profile;

import java.util.List;

public class GetStatusCommand implements Command {
    private final Profile profile;

    public GetStatusCommand(Profile profile) {
        this.profile = profile;
    }

    @Override
    public final void execute(List<String> args) {
        System.out.println(profile.toString());
    }
}
