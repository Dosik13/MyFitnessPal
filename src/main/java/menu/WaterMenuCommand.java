package menu;

import commanders.CommandWater;
import commands.Command;

import java.util.List;

public class WaterMenuCommand implements Command {
    private final CommandWater commandWater;

    public WaterMenuCommand(CommandWater commandWater) {
        this.commandWater = commandWater;
    }

    @Override
    public final void execute(List<String> args) {
        commandWater.executeCommand(args);
    }
}
