package commanders;

import commands.Command;
import commands.water.ChangeDailyWaterGoalCommand;
import commands.water.GetDailyWaterGoalCommand;
import commands.water.HelpWaterCommand;
import commands.water.LogFromUserCommand;
import commands.water.PrintAllLogsCommand;
import commands.water.PrintLogForDayCommand;
import water.WaterStorage;

import java.util.List;

public class CommandWater extends CommandMap {
    private static final String PRINT_ALL = "print-all";
    private static final String PRINT = "print";
    private static final String LOG = "log";
    private static final String HELP = "help";
    private static final String CHANGE = "change";
    private static final String GOAL = "goal";


    private final WaterStorage waterStorage;

    public CommandWater(WaterStorage waterStorage) {
        this.waterStorage = waterStorage;
        addToMap();
    }

    private void addToMap() {
        addToMap(PRINT_ALL, new PrintAllLogsCommand(waterStorage));
        addToMap(PRINT, new PrintLogForDayCommand(waterStorage));
        addToMap(LOG, new LogFromUserCommand(waterStorage));
        addToMap(HELP, new HelpWaterCommand());
        addToMap(CHANGE, new ChangeDailyWaterGoalCommand(waterStorage));
        addToMap(GOAL, new GetDailyWaterGoalCommand(waterStorage));
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
