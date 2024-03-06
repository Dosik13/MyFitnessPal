package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExerciseStorageTest {
    @Test
    void getExerciseByNameExistingNameReturnsExercise() {
        Exercise exercise1 = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        Exercise exercise2 = new Exercise("Pull-ups", "Pull-ups description",
                new String[]{"Back", "Biceps"},
                new String[]{"None"}, "Medium");
        ExerciseStorage storage = new ExerciseStorage(new Exercise[]{exercise1, exercise2});
        assertEquals(exercise1, storage.getExerciseByName("Push-ups"));
    }
    @Test
    void getExerciseByNameNonExistingNameReturnsNull() {
        Exercise exercise1 = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        Exercise exercise2 = new Exercise("Pull-ups", "Pull-ups description",
                new String[]{"Back", "Biceps"}, new String[]{"None"}, "Medium");
        ExerciseStorage storage = new ExerciseStorage(new Exercise[]{exercise1, exercise2});
        assertNull(storage.getExerciseByName("Squats"));
    }
    @Test
    void getExerciseByNameNullNameThrowsException() {
        Exercise exercise1 = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        Exercise exercise2 = new Exercise("Pull-ups", "Pull-ups description",
                new String[]{"Back", "Biceps"}, new String[]{"None"}, "Medium");
        ExerciseStorage storage = new ExerciseStorage(new Exercise[]{exercise1, exercise2});
        assertThrows(NullPointerException.class, () -> storage.getExerciseByName(null));
    }
    @Test
    void removeExerciseExistingExerciseRemovesExercise() {
        Exercise exercise1 = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        Exercise exercise2 = new Exercise("Pull-ups", "Pull-ups description",
                new String[]{"Back", "Biceps"}, new String[]{"None"}, "Medium");
        ExerciseStorage storage = new ExerciseStorage(new Exercise[]{exercise1, exercise2});
        storage.removeExercise(exercise1);
        assertNull(storage.getExerciseByName("Push-ups"));
    }
    @Test
    void removeExerciseNonExistingExerciseKeepsOriginalExercises() {
        Exercise exercise1 = new Exercise("Push-ups", "Push-ups description",
                new String[]{"Chest", "Triceps"}, new String[]{"None"}, "Easy");
        Exercise exercise2 = new Exercise("Pull-ups", "Pull-ups description",
                new String[]{"Back", "Biceps"}, new String[]{"None"}, "Medium");
        Exercise exercise3 = new Exercise("Squats", "Squats description",
                new String[]{"Legs"}, new String[]{"None"}, "Hard");
        ExerciseStorage storage = new ExerciseStorage(new Exercise[]{exercise1, exercise2});
        storage.removeExercise(exercise3);
        assertEquals(2, storage.getExercises().length);
    }
}
