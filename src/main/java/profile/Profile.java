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

    public Profile(String username, String fullName, int age, Anthropometry anthropometry, List<Goal> goals,
                   Gender gender, Country country) {
        this.username = username;
        this.fullName = fullName;
        this.age = age;
        this.anthropometry = anthropometry;
        this.goals = goals;
        this.gender = gender;
        this.country = country;

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

        setAnthropometry(anthropometry.height(), weight);
    }

    @Override
    public void changeHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("The height cannot be zero or less");
        }

        setAnthropometry(height, anthropometry.weight());
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

    private void setAnthropometry(int height, int weight) {
        anthropometry = new Anthropometry(height, weight);
        calorieIntakeGoal = findCalorieIntake();
    }

    @Override
    public String toString() {
        return "Username: " + username + "\n"
            + "Full Name: " + fullName + "\n"
            + "Age: " + age + "\n"
            + "Anthropometry: " + anthropometry + "\n"
            + "Goals: " + goals + "\n"
            + "Gender: " + gender + "\n"
            + "Country: " + country + "\n"
            + "Calorie Intake Goal: " + calorieIntakeGoal + "\n";
    }
}
