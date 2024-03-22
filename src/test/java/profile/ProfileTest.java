package profile;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTest {

    private static Profile profile;

    @BeforeAll
    static void init() {
        profile = new Profile("Pe7atN", "Petar Nedyalkov", 20, new Anthropometry(180, 70), List.of(Goal.WEIGHT_GAIN),
            Gender.MALE, Country.BULGARIA);
    }

    @Test
    void testChangeWaterGoal() {

        assertEquals(2, profile.getWaterGoal());
        assertEquals(3, profile.changeWaterGoal(3));
        assertEquals(3, profile.getWaterGoal());
    }

    @Test
    void testCalculateCalorieIntake() {

        assertEquals(2840, profile.getCalorieIntake());
        assertTrue(profile.changeGoals(List.of(Goal.WEIGHT_LOSS)));
        assertEquals(2040, profile.getCalorieIntake());
        assertTrue(profile.changeGoals(List.of(Goal.MUSCLE_GAIN)));
        assertEquals(2684, profile.getCalorieIntake());
    }
}
