package water;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class WaterStorageTest {
    private static WaterStorage waterStorage;

    @BeforeEach
    void prepare() {
        waterStorage = new WaterStorage(1000);
    }

    @Test
    void testLogWaterSingleLog() {
        int amount = 50;
        LocalDate localDate = LocalDate.of(1999, 10, 10);
        waterStorage.logWater(amount, localDate);
        assertEquals((int) waterStorage.getWaterLogStorage().get(localDate), amount,
            "Method should add the given amount to the given date");
    }

    @Test
    void testLogWaterMultipleLogs() {
        int amount = 50;
        LocalDate localDate = LocalDate.of(1999, 10, 10);
        waterStorage.logWater(amount, localDate);
        waterStorage.logWater(amount, localDate);
        waterStorage.logWater(amount, localDate);

        assertEquals((int) waterStorage.getWaterLogStorage().get(localDate), 3 * amount,
            "Method should add the given amount to the given date");
    }

    @Test
    void testLogWaterNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> waterStorage.logWater(-1, LocalDate.of(2000, 10, 10)),
            "Should throw IllegalArgumentException if amount is negative");
    }

    @Test
    void testIsWaterGoalReachedForDayFalse() {
        int amount = 200;
        LocalDate localDate = LocalDate.of(2010, 10, 15);
        waterStorage.logWater(amount, localDate);
        assertFalse(waterStorage.isWaterGoalReachedForDay(localDate),
            "Should return false if water goal is not reached");
    }

    @Test
    void testIsWaterGoalReachedForDayTrue() {
        LocalDate localDate = LocalDate.of(2010, 10, 15);
        waterStorage.logWater(1000, localDate);
        assertFalse(waterStorage.isWaterGoalReachedForDay(localDate), "Should return true if water goal is reached");
    }

    @Test
    void testGetWaterDrunkForDayNoLogsForDay() {
        assertEquals(-1, waterStorage.getWaterDrunkForDay(LocalDate.of(1999, 11, 19)),
            "Should return -1 if the day has not been logged yet");
    }

    @Test
    void testGetWaterDrunkForDayValidDay() {
        int amount = 300;
        LocalDate localDate = LocalDate.of(2000, 10, 20);
        waterStorage.logWater(amount, localDate);
        assertEquals(amount, waterStorage.getWaterDrunkForDay(localDate),
            "Should return the logged amount for the given day");
    }
}
