package profile;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {

    private static Profile profile;

    @BeforeAll
    static void init() {
        profile = new Profile("Pe7atN", "Petar Nedyalkov", 20, new Anthropometry(180, 70), List.of(Goal.WEIGHT_GAIN),
            Gender.MALE, Country.BULGARIA);
    }

    @Test
    void testCalculateCalorieIntake() {

        assertEquals(2840, profile.getCalorieIntake());
        profile.changeGoals(List.of(Goal.WEIGHT_LOSS));
        assertEquals(2040, profile.getCalorieIntake());
        profile.changeGoals(List.of(Goal.MUSCLE_GAIN));
        assertEquals(2684, profile.getCalorieIntake());
    }
}
