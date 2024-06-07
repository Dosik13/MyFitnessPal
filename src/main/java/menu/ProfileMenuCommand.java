package menu;

import commanders.CommandProfile;
import commands.Command;

import java.util.List;

public class ProfileMenuCommand implements Command {
    private final CommandProfile commandProfile;

    public ProfileMenuCommand(CommandProfile commandProfile) {
        this.commandProfile = commandProfile;
    }

    @Override
    public final void execute(List<String> args) {
        commandProfile.executeCommand(args);
    }
}
