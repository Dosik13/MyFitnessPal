package profile;

import water.WaterGoal;

import java.util.List;

public class Profile implements ProfileAPI {

    //Profile information
    private String username;
    private String fullName;
    private int age;
    private Anthropometry anthropometry;
    private List<Goal> goals;
    private Gender gender;
    private Country country;

    //TODO add Program (List from exercies)
    //TODO add lists with food that are stored in my profile

    //Variables
    private int calorieIntake;
    private WaterGoal waterGoal;

    public Profile(String username, String fullName, int age, Anthropometry anthropometry, List<Goal> goals,
                   Gender gender, Country country) {
        this.username = username;
        this.fullName = fullName;
        this.age = age;
        this.anthropometry = anthropometry;
        this.goals = goals;
        this.gender = gender;
        this.country = country;

        this.calorieIntake = findCalorieIntake();
        this.waterGoal = new WaterGoal(2);
    }

    @Override
    public final String getUsername() {
        return username;
    }

    @Override
    public final String getFullName() {
        return fullName;
    }

    @Override
    public final int getAge() {
        return age;
    }

    @Override
    public final Anthropometry getAnthropometry() {
        return anthropometry;
    }

    @Override
    public final List<Goal> getGoals() {
        return goals;
    }

    @Override
    public final Gender getGender() {
        return gender;
    }

    @Override
    public final Country getCountry() {
        return country;
    }

    @Override
    public final int getCalorieIntake() {
        return calorieIntake;
    }

    @Override
    public final int getWaterGoal() {
        return waterGoal.getGoal();
    }

    @Override
    public final int changeWaterGoal(int newGoal) {
        waterGoal.setGoal(newGoal);

        return waterGoal.getGoal();
    }

    @Override
    public final boolean changeGoals(List<Goal> newGoals) {
        if (newGoals == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }

        if (newGoals.isEmpty()) {
            return false;
        }

        goals = newGoals;
        calorieIntake = findCalorieIntake();
        return true;

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
}
