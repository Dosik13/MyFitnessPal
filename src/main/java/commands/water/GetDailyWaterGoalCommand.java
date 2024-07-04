package commands.water;

import commands.Command;
import water.WaterStorage;

import java.util.List;

public final class GetDailyWaterGoalCommand implements Command {
    private final WaterStorage waterStorage;

    public GetDailyWaterGoalCommand(WaterStorage waterStorage) {
        this.waterStorage = waterStorage;
    }

    @Override
    public void execute(List<String> args) {
        System.out.println("The daily goal for drunk water is set to " + waterStorage.getGoalMl());
    }
}
