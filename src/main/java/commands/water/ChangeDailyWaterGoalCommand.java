package commands.water;

import commands.Command;
import water.WaterStorage;

import java.util.List;

public final class ChangeDailyWaterGoalCommand implements Command {
    private final WaterStorage waterStorage;

    public ChangeDailyWaterGoalCommand(WaterStorage waterStorage) {
        this.waterStorage = waterStorage;
    }

    @Override
    public void execute(List<String> args) {
        if (args.isEmpty()) {
            System.out.println("Provide value for new daily water goal");
            return;
        }
        waterStorage.setGoalMl(Integer.parseInt(args.get(0)));
        System.out.println("Water goal changed to " + args.get(0) + " " + CupVolume.getUnit());
    }
}
