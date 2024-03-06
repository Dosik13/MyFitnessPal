package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
class ExerciseTest {
    @Test
    void setNameValidNameSetsName() {
        Exercise exercise = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        exercise.setName("Pull-ups");
        assertEquals("Pull-ups", exercise.getName());
    }
    @Test
    void setSetsValidSetsSetsSets() {
        Exercise exercise = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        exercise.setSets(5);
        assertEquals(5, exercise.getSets());
    }
    @Test
    void setSetsLessThanOneThrowsException() {
        Exercise exercise = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        assertThrows(IllegalArgumentException.class, () -> exercise.setSets(0));
    }
    @Test
    void setSetsMoreThanHundredThrowsException() {
        Exercise exercise = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        assertThrows(IllegalArgumentException.class, () -> exercise.setSets(101));
    }
    @Test
    void setRepsValidRepsSetsReps() {
        Exercise exercise = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        exercise.setReps(10);
        assertEquals(10, exercise.getReps());
    }
    @Test
    void setRepsLessThanOneThrowsException() {
        Exercise exercise = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        assertThrows(IllegalArgumentException.class, () -> exercise.setReps(0));
    }
    @Test
    void setRepsMoreThanThousandThrowsException() {
        Exercise exercise = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        assertThrows(IllegalArgumentException.class, () -> exercise.setReps(1001));
    }
}
