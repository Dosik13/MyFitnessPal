package water;

public class WaterGoal {
    private int goal;
    private int current;

    private static final int SMALL_SIZE_CUP = 100;
    private static final int MEDIUM_SIZE_CUP = 250;
    private static final int LARGE_SIZE_CUP = 500;

    public WaterGoal(int goal) {
        if (goal < 0) {
            throw new IllegalArgumentException("goal cannot be negative");
        }
        this.goal = goal;
        this.current = 0;
    }

    public boolean goalIsReached() {
        return current >= goal;
    }

    public void addWaterConsumption(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount cannot be negative");
        }
        current += amount;
    }

    public void addWaterConsumptionSmallCup() {
        current += SMALL_SIZE_CUP;
    }

    public void addWaterConsumptionMediumCup() {
        current += MEDIUM_SIZE_CUP;
    }

    public void addWaterConsumptionLargeCup() {
        current += LARGE_SIZE_CUP;
    }

    public int getCurrent() {
        return current;
    }

    public int getGoal() {
        return goal;
    }

    public void setCurrent(int newValue) {
        current = newValue;
    }

    public void setGoal(int newValue) {
        goal = newValue;
    }
}
