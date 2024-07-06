package profile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProfileTest {

    private static Profile profile;

    @BeforeEach
    final void init() {
        profile =
            new Profile("Pe7atN", "Petar Nedyalkov", 20, new Anthropometry(190, 75), List.of(Goal.WEIGHT_GAIN),
                Gender.MALE, Country.BULGARIA);
    }

    @Test
    void testCalculateCalorieIntake() {

        assertEquals(2960, profile.getCalorieIntake());
        profile.changeGoals(List.of(Goal.WEIGHT_LOSS));
        assertEquals(2160, profile.getCalorieIntake());
        profile.changeGoals(List.of(Goal.MUSCLE_GAIN));
        assertEquals(2816, profile.getCalorieIntake());
    }

    @Test
    void testChangeWeight() {

        assertEquals(75, profile.getAnthropometry().weight(),
            "It was expected the weight to be 75");
        profile.changeWeight(80);
        assertEquals(80, profile.getAnthropometry().weight(),
            "It was expected the weight to be 80");
    }

    @Test
    void testChangeWeightWhenZeroOrLess() {
        assertThrows(IllegalArgumentException.class, () -> profile.changeWeight(0),
            "It was expected IllegalArgumentException to be thrown");
    }

    @Test
    void testChangeHeight() {

        assertEquals(190, profile.getAnthropometry().height(),
            "It was expected the weight to be 75");
        profile.changeHeight(180);
        assertEquals(180, profile.getAnthropometry().height(),
            "It was expected the weight to be 80");
    }

    @Test
    void testChangeHeightWhenZeroOrLess() {
        assertThrows(IllegalArgumentException.class, () -> profile.changeHeight(-10),
            "It was expected IllegalArgumentException to be thrown");
    }

    @Test
    void testCountryPrint() {
        assertEquals("Bulgaria", profile.getCountry().toString(),
            "It was expected to write the country");
    }

    @Test
    void testGenderPrint() {
        assertEquals("Male", profile.getGender().toString(),
            "It was expected to write the right gender");
    }

    @Test
    void testGoalsPrint() {
        assertEquals(Goal.getFromString("weight_gain").toString(), profile.getGoals().get(0).toString(),
            "It was expected to write the right goal");
    }
}
