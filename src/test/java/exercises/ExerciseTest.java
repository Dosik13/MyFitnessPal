package exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
class ExerciseTest {
    @Test
    void setNameValidNameSetsName() {
        Exercise exercise = new Exercise("Push-ups", "Push-ups description",
                List.of(Muscle.CHEST, Muscle.TRICEPS), List.of("None"), Difficulty.EASY);
        exercise.setName("Pull-ups");
        assertEquals("Pull-ups", exercise.getName());
    }
}
