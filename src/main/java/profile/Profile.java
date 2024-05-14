package profile;

import java.util.List;

public final class Profile implements ProfileAPI {

    //Profile information
    private String username;
    private String fullName;
    private int age;
    private Anthropometry anthropometry;
    private List<Goal> goals;
    private Gender gender;
    private Country country;

    //Variables
    private int calorieIntakeGoal;

    public static ProfileBuilder builder(String username) {
        return new ProfileBuilder(username);
    }

    private Profile(ProfileBuilder builder) {
        this.username = builder.username;
        this.fullName = builder.fullName;
        this.age = builder.age;
        this.anthropometry = builder.anthropometry;
        this.goals = builder.goals;
        this.gender = builder.gender;
        this.country = builder.country;

        this.calorieIntakeGoal = findCalorieIntake();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Anthropometry getAnthropometry() {
        return anthropometry;
    }

    @Override
    public List<Goal> getGoals() {
        return goals;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public Country getCountry() {
        return country;
    }

    @Override
    public int getCalorieIntake() {
        return calorieIntakeGoal;
    }

    @Override
    public void changeGoals(List<Goal> newGoals) {
        if (newGoals == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }

        goals = newGoals;
        calorieIntakeGoal = findCalorieIntake();
    }

    @Override
    public void changeWeight(int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("The weight cannot be zero or less");
        }

        int height = anthropometry.height();
        anthropometry = new Anthropometry(height, weight);
        calorieIntakeGoal = findCalorieIntake(); // it depends on anthropometry
    }

    @Override
    public void changeHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("The height cannot be zero or less");
        }

        int weight = anthropometry.weight();
        anthropometry = new Anthropometry(height, weight);
        calorieIntakeGoal = findCalorieIntake(); // it depends on anthropometry
    }

    private int findCalorieIntake() {
        int currentCalorieIntake = 0;
        if (gender.equals(Gender.MALE)) {
            currentCalorieIntake = 660 + (14 * anthropometry.weight()) + (5 * anthropometry.height()) - (5 * age);
        } else {
            currentCalorieIntake = 655 + (10 * anthropometry.weight()) + (2 * anthropometry.height()) - (7 * age);
        }

        if (goals.contains(Goal.WEIGHT_LOSS)) {
            currentCalorieIntake -= 400;
        } else if (goals.contains(Goal.WEIGHT_GAIN)) {
            currentCalorieIntake += 400;
        } else if (goals.contains(Goal.FAT_LOSS)) {
            currentCalorieIntake -= 600;
        } else {
            currentCalorieIntake += (int) (currentCalorieIntake * 0.1);
        }

        return currentCalorieIntake;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ").append(username).append("\n");
        sb.append("Full Name: ").append(fullName).append("\n");
        sb.append("Age: ").append(age).append("\n");
        sb.append("Anthropometry: ").append(anthropometry).append("\n");
        sb.append("Goals: ").append(goals).append("\n");
        sb.append("Gender: ").append(gender).append("\n");
        sb.append("Country: ").append(country).append("\n");
        sb.append("Calorie Intake Goal: ").append(calorieIntakeGoal).append("\n");
        return sb.toString();
    }

    //BuilderClass
    public static final class ProfileBuilder {

        //required parameters
        private String username;

        //optional parameters
        private String fullName;
        private int age;
        private Anthropometry anthropometry;
        private List<Goal> goals;
        private Gender gender;
        private Country country;

        private ProfileBuilder(String username) {
            this.username = username;
        }

        public ProfileBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public ProfileBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public ProfileBuilder setAnthropometry(Anthropometry anthropometry) {
            this.anthropometry = anthropometry;
            return this;
        }

        public ProfileBuilder setGoals(List<Goal> goals) {
            this.goals = goals;
            return this;
        }

        public ProfileBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public ProfileBuilder setCountry(Country country) {
            this.country = country;
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }
    }
}
