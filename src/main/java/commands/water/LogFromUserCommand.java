package commands.water;

import commands.Command;
import water.WaterStorage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public final class LogFromUserCommand implements Command {
    private final WaterStorage waterStorage;

    public LogFromUserCommand(WaterStorage waterStorage) {
        this.waterStorage = waterStorage;
    }

    @Override
    public void execute(List<String> args) {
        if (args.size() != 2 && (args.size() != 3 || !args.get(0).equals("custom"))) {
            System.out.println("Not enough arguments" + System.lineSeparator()
                + "If you chose custom value - please provide the exact amount");
            return;
        }
        int amount;
        try {
            amount = getAmountFromUser(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        LocalDate localDate;
        try {
            localDate = getDateFromUser(args);
        } catch (DateTimeParseException e) {
            System.out.println("The date was not in the correct format");
            return;
        }
        waterStorage.logWater(amount, localDate);
        System.out.println("Successfully logged " + amount + " " + CupVolume.getUnit() + " on " + localDate);
    }

    private int getAmountFromUser(List<String> args) {

        int amount = switch (args.get(0)) {
            case "small" -> CupVolume.SMALL.getSize();
            case "medium" -> CupVolume.MEDIUM.getSize();
            case "large" -> CupVolume.LARGE.getSize();
            case "custom" -> -1;
            default -> throw new IllegalArgumentException("Unexpected value");
        };

        if (amount == -1) {
            if (args.size() < 3) {
                throw new IllegalArgumentException("Custom amount should come with a custom value");
            }
            amount = Integer.parseInt(args.get(1));
        }
        if (amount < 0) {
            throw new IllegalArgumentException("amount was negative");
        }
        return amount;
    }

    private LocalDate getDateFromUser(List<String> args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd-MM-yyyy][d-M-yyyy]");
        return LocalDate.parse(args.get(args.size() - 1), formatter);
    }
}
