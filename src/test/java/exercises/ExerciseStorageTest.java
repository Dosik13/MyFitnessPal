package exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ExerciseStorageTest {
    private static final String ENTITY_CANNOT_BE_NULL = "T cannot be null";
    private static final String ENTITY_NAME_CANNOT_BE_NULL = "T name cannot be null";

    private Storage<Exercise> storage;
    private Exercise exercise1;
    private Exercise exercise2;
    @BeforeEach
    void setUp() {
        exercise1 = new Exercise("Push-ups", "Push-ups description",
                List.of(Muscle.CHEST, Muscle.TRICEPS), List.of("None"), Exercise.Difficulty.EASY);
        exercise2 = new Exercise("Pull-ups", "Pull-ups description",
                List.of(Muscle.LOWER_BACK, Muscle.BICEPS), List.of("None"), Exercise.Difficulty.MEDIUM);
        storage = new Storage<>(new ArrayList<>(Arrays.asList(exercise1, exercise2)));
    }

    @Test
    void addExercise() {
        storage.addEntity(exercise2);
        assertTrue(storage.getEntities().contains(exercise2));
    }

    @Test
    void addExerciseThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            storage.addEntity(null);
        });
        assertEquals(ENTITY_CANNOT_BE_NULL, exception.getMessage());
    }

    @Test
    void removeExercise() {
        storage.removeEntity(exercise1);
        assertFalse(storage.getEntities().contains(exercise1));
    }

    @Test
    void removeExerciseThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            storage.removeEntity(null);
        });
        assertEquals(ENTITY_CANNOT_BE_NULL, exception.getMessage());
    }

    @Test
    void getExerciseByName() {
        assertEquals(exercise1, storage.getEntityByName("Push-ups"));
    }

    @Test
    void getExerciseByNameWithNonExistingName() {
        assertNull(storage.getEntityByName("Non-existing name"));
    }

    @Test
    void getExerciseByNameThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            storage.getEntityByName(null);
        });
        assertEquals(ENTITY_NAME_CANNOT_BE_NULL, exception.getMessage());
    }
}
