package profile;

public enum Goal {

    WEIGHT_LOSS("Weight_Loss"),
    WEIGHT_GAIN("Weight_Gain"),
    FAT_LOSS("Fat_Loss"),
    MUSCLE_GAIN("Muscle_Gain");

    private String weighGoal;

    Goal(String weighGoal) {
        this.weighGoal = weighGoal;
    }

    public static Goal getFromString(String goalName) {
        for (Goal goal : Goal.values()) {
            if (goal.weighGoal.equalsIgnoreCase(goalName)) {
                return goal;
            }
        }

        throw new IllegalArgumentException("No enum constant with genderName: " + goalName);
    }

    @Override
    public String toString() {
        return weighGoal;
    }
}
