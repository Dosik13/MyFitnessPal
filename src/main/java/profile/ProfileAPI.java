package profile;

import java.util.List;

public interface ProfileAPI {

    /**
     * Retrieves the username of the profile.
     *
     * @return The username of the profile.
     */
    String getUsername();

    /**
     * Retrieves the full name of the profile.
     *
     * @return The full name of the profile.
     */
    String getFullName();

    /**
     * Retrieves the age of the profile.
     *
     * @return The age of the profile.
     */
    int getAge();

    /**
     * Retrieves the anthropometry information of the profile.
     *
     * @return The anthropometry information of the profile.
     */
    Anthropometry getAnthropometry();

    /**
     * Retrieves the list of goals associated with the profile.
     *
     * @return The list of goals associated with the profile.
     */
    List<Goal> getGoals();

    /**
     * Retrieves the gender of the profile.
     *
     * @return The gender of the profile.
     */
    Gender getGender();

    /**
     * Retrieves the country associated with the profile.
     *
     * @return The country associated with the profile.
     */
    Country getCountry();

    /**
     * Retrieves the calorie intake associated with the profile.
     *
     * @return The calorie intake associated with the profile.
     */
    int getCalorieIntake();

    /**
     * Changes the goals of the profile
     *
     * @param newGoals the new goals associated with the profile
     * @throws IllegalArgumentException if newGoals is null
     */
    void changeGoals(List<Goal> newGoals);

    /**
     * Changes the weight in the anthropometry
     *
     * @param weight the new height associated with the profile
     * @throws IllegalArgumentException if weight is zero or less
     */
    void changeWeight(int weight);

    /**
     * Changes the height in the anthropometry
     *
     * @param height the new height associated with the profile
     * @throws IllegalArgumentException if height is zero or less
     */
    void changeHeight(int height);
}
