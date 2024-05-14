package profile;

public enum Goal {

    WEIGHT_LOSS("Weight Loss"),
    WEIGHT_GAIN("Weight Gain"),
    FAT_LOSS("Fat Loss"),
    MUSCLE_GAIN("Muscle Gain");

    private String weighGoal;

    Goal(String weighGoal) {
        this.weighGoal = weighGoal;
    }

    @Override
    public String toString() {
        return weighGoal;
    }
}
