package water;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

public class WaterGoal {

    private static final int SMALL_SIZE_CUP = 100;
    private static final int MEDIUM_SIZE_CUP = 250;
    private static final int LARGE_SIZE_CUP = 500;

    private static final String UNIT = " ml";
    private final WaterStorage waterStorage;
    private final InputStream inputStream;

    public WaterGoal(int goalMl) {
        this(goalMl, System.in);
    }

    public WaterGoal(int goalMl, InputStream inputStream) {
        waterStorage = new WaterStorage(goalMl);
        this.inputStream = inputStream;
    }

    public final void printAllLogs() {
        for (Map.Entry<LocalDate, Integer> entry : waterStorage.getWaterLogStorage().entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + UNIT);
        }
    }
    public final void logFromUser() {
        int amount;
        try {
            amount = getAmountFromUser();
        } catch (IOException e) {
            throw new UncheckedIOException("Unexpected exception while reading drink amount", e);
        } catch (IllegalArgumentException e) {
            System.out.println("Unexpected value");
            return;
        }

        LocalDate localDate;
        try {
            localDate = getDateFromUser();
        } catch (IOException e) {
            throw new UncheckedIOException("Unexpected exception while reading date", e);
        } catch (DateTimeParseException e) {
            System.out.println("The date was not in the correct format");
            return;
        }
        waterStorage.logWater(amount, localDate);
    }

    private int getAmountFromUser() throws IOException {
        System.out.println("Enter water drink amount to log:");
        System.out.println("1." + SMALL_SIZE_CUP + UNIT);
        System.out.println("2." + MEDIUM_SIZE_CUP + UNIT);
        System.out.println("3." + LARGE_SIZE_CUP + UNIT);
        System.out.println("4. Other");

        String request;
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(inputStream));
        request = reader.readLine();

        int amount = switch (request) {
            case "1" -> SMALL_SIZE_CUP;
            case "2" -> MEDIUM_SIZE_CUP;
            case "3" -> LARGE_SIZE_CUP;
            case "4" -> -1;
            default -> throw new IllegalArgumentException("Unexpected value");
        };

        if (amount == -1) {
            System.out.println("Enter drink amount");
            amount = Integer.parseInt(reader.readLine());
        }
        if (amount < 0) {
            throw new IllegalArgumentException("amount was negative");
        }
        return amount;
    }

    private LocalDate getDateFromUser() throws IOException {
        System.out.println("Enter DD-MM-YYYY to log");
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(inputStream));
        String request = reader.readLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd-MM-yyyy][d-M-yyyy]");
        return LocalDate.parse(request, formatter);
    }

    public final void printLogForDay(LocalDate localDate) {
        if (waterStorage.getWaterLogStorage().containsKey(localDate)) {
            System.out.println(
                "Water drunk on " + localDate + " - " + waterStorage.getWaterLogStorage().get(localDate) + UNIT);
        } else {
            System.out.println("No logs for the given day");
        }
    }

}
