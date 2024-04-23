package profile;

public enum Goal {

    WEIGHT_LOSS("weight loss"),
    WEIGHT_GAIN("weight gain"),
    FAT_LOSS("fat loss"),
    MUSCLE_GAIN("muscle gain");

    private String weighGoal;

    Goal(String weighGoal) {
        this.weighGoal = weighGoal;
    }

    @Override
    public String toString() {
        return weighGoal;
    }
}
