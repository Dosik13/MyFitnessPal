package water;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class WaterStorage {
    private int goalMl;
    private final Map<LocalDate, Integer> waterLogStorage;

    public WaterStorage(int goalMl) {
        if (goalMl < 0) {
            throw new IllegalArgumentException("goal cannot be negative");
        }
        this.goalMl = goalMl;
        waterLogStorage = new TreeMap<>();
    }

    public final int getGoalMl() {
        return goalMl;
    }

    public final Map<LocalDate, Integer> getWaterLogStorage() {
        return Map.copyOf(waterLogStorage);
    }

    public final void setGoalMl(int newValue) {
        goalMl = newValue;
    }

    public final int getWaterDrunkForDay(LocalDate localDate) {
        if (!waterLogStorage.containsKey(localDate)) {
            return -1;
        }
        return waterLogStorage.get(localDate);
    }

    public final boolean isWaterGoalReachedForDay(LocalDate localDate) {
        return waterLogStorage.containsKey(localDate) && waterLogStorage.get(localDate) > goalMl;
    }

    public final void logWater(int amount, LocalDate localDate) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount was negative");
        }
        waterLogStorage.compute(localDate, (key, oldValue) -> oldValue == null ? amount : oldValue + amount);
    }
}
