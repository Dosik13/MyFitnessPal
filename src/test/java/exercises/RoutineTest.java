package exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class RoutineTest {
    private Routine routine;
    private Exercise exercise;
    private RoutineElement routineElement;

    @BeforeEach
    void setUp() {
        routine = new Routine("Morning Routine", "Do this every morning");
        exercise = new Exercise("Push-ups", "Push-ups description",
                List.of(Muscle.CHEST, Muscle.TRICEPS), List.of("None"), Difficulty.EASY);
        routineElement = new RoutineElement(exercise, 10, 3);
    }

    @Test
    void addElementShouldAddElementToRoutine() {
        routine.addElement(routineElement);
        assertTrue(routine.getElements().contains(routineElement));
    }

    @Test
    void addElementShouldThrowExceptionWhenNull() {
        assertThrows(IllegalArgumentException.class, () -> routine.addElement(null));
    }

    @Test
    void removeElementShouldRemoveElementFromRoutine() {
        routine.addElement(routineElement);
        routine.removeElement(routineElement);
        assertFalse(routine.getElements().contains(routineElement));
    }

    @Test
    void removeElementShouldThrowExceptionWhenNull() {
        assertThrows(IllegalArgumentException.class, () -> routine.removeElement(null));
    }

    @Test
    void getElementByName() {
        routine.addElement(routineElement);
        RoutineElement retrievedElement = routine.getElementByName("Push-ups");
        assertEquals(routineElement, retrievedElement);
    }

    @Test
    void getElementByNameWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> routine.getElementByName(null),
                "It is expected IllegalArgumentException to be thrown when name is null");
    }
}
