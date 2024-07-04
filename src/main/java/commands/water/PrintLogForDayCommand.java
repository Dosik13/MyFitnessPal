package commands.water;

import commands.Command;
import water.WaterStorage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public final class PrintLogForDayCommand implements Command {
    private final WaterStorage waterStorage;

    public PrintLogForDayCommand(WaterStorage waterStorage) {
        this.waterStorage = waterStorage;
    }

    @Override
    public void execute(List<String> args) {
        if (args.isEmpty()) {
            System.out.println("Provide a specific date");
            return;
        }
        LocalDate localDate;
        try {
            localDate = getDateFromUser(args.get(0));
        } catch (DateTimeParseException e) {
            System.out.println("The date was not in the correct format");
            return;
        }
        if (waterStorage.getWaterLogStorage().containsKey(localDate)) {
            System.out.println(
                "Water drunk on " + localDate + " - " + waterStorage.getWaterLogStorage().get(localDate)
                    + CupVolume.getUnit());
        } else {
            System.out.println("No logs for the given day");
        }

    }

    private LocalDate getDateFromUser(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd-MM-yyyy][d-M-yyyy]");
        return LocalDate.parse(date, formatter);
    }
}
