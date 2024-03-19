
package exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ExerciseStorageTest {

    private ExerciseStorage storage;
    private Exercise exercise1;
    private Exercise exercise2;

    @BeforeEach
    void setUp() {
        exercise1 = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        exercise2 = new Exercise("Pull-ups", "Pull-ups description",
                new String[]{"Back", "Biceps"}, new String[]{"None"}, "Medium");
        storage = new ExerciseStorage(new ArrayList<>(Arrays.asList(exercise1, exercise2)));
    }

    @Test
    void addExercise() {
        storage.addExercise(exercise2);
        assertTrue(storage.getExercises().contains(exercise2));
    }

    @Test
    void addExerciseThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            storage.addExercise(null);
        });
        assertEquals("Exercise cannot be null", exception.getMessage());
    }

    @Test
    void removeExercise() {
        storage.removeExercise(exercise1);
        assertFalse(storage.getExercises().contains(exercise1));
    }

    @Test
    void removeExerciseThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            storage.removeExercise(null);
        });
        assertEquals("Exercise cannot be null", exception.getMessage());
    }

    @Test
    void getExerciseByName() {
        assertEquals(exercise1, storage.getExerciseByName("Push-ups"));
    }

    @Test
    void getExerciseByNameWithNonExistingName() {
        assertNull(storage.getExerciseByName("Non-existing name"));
    }

    @Test
    void getExerciseByNameThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            storage.getExerciseByName(null);
        });
        assertEquals("Name cannot be null", exception.getMessage());
    }
}
