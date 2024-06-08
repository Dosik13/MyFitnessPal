package commands.water;

import commands.Command;
import water.WaterStorage;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class PrintAllLogsCommand implements Command {
    private final WaterStorage engine;
    public PrintAllLogsCommand(WaterStorage engine) {
        this.engine = engine;
    }

    @Override
    public final void execute(List<String> args) {
        for (Map.Entry<LocalDate, Integer> entry : engine.getWaterLogStorage().entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + CupVolume.getUnit());
        }
    }
}
