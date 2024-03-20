package water;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaterGoalTest {
    private static WaterGoal waterGoal;

    @BeforeAll
    static void init() {
        waterGoal = new WaterGoal(0);
    }

    @BeforeEach
    void reset() {
        waterGoal.setGoal(0);
        waterGoal.setCurrent(0);
    }

    @Test
    void testWaterGoalConstructorNegativeArgument() {
        assertThrows(IllegalArgumentException.class, () -> new WaterGoal(-2),
            "Trying to instantiate WaterGoal with negative argument should throw IllegalArgumentException");
    }

    @Test
    void testAddWaterConsumptionValidArgument() {
        waterGoal.addWaterConsumption(300);
        assertEquals(300, waterGoal.getCurrent(),
            "WaterGoal.current should be increased by the given amount");

    }
    @Test
    void testAddWaterConsumptionNegativeArgument() {
        assertThrows(IllegalArgumentException.class, () -> waterGoal.addWaterConsumption(-30),
            "Trying to call addWaterConsumption with negative argument should throw IllegalArgumentException");
    }
    @Test
    void testGoalIsReachedFalse() {
        waterGoal.setGoal(100);
        assertFalse(waterGoal.goalIsReached(), "goalIsReached should return false when the goal is not reached");
    }
    @Test
    void testGoalIsReachedTrue() {
        waterGoal.setGoal(100);
        waterGoal.setCurrent(100);
        assertTrue(waterGoal.goalIsReached(), "goalIsReached should return true when the goal is reached");
    }
}
