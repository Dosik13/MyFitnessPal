package exercises;

import java.util.ArrayList;
import java.util.List;

public class Routine {
    private String name;
    private String instructions;
    private List<RoutineElement> elements;

    public Routine(String name, String instructions) {
        this.name = name;
        this.instructions = instructions;
        elements = new ArrayList<>();
    }

    public Routine(String name, String instructions, List<RoutineElement> elements) {
        this(name, instructions);
        this.elements = elements;
    }

    public final String getName() {
        return name;
    }

    public final String getInstructions() {
        return instructions;
    }

    public final List<RoutineElement> getElements() {
        return elements;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public final void setElements(List<RoutineElement> elements) {
        this.elements = elements;
    }

    public final void addElement(RoutineElement element) {
        if (element == null) {
            throw new IllegalArgumentException(Messages.ROUTINE_ELEMENT_CANNOT_BE_NULL);
        }
        elements.add(element);
    }

    public final void removeElement(RoutineElement element) {
        if (element == null) {
            throw new IllegalArgumentException(Messages.ROUTINE_ELEMENT_CANNOT_BE_NULL);
        }
        elements.remove(element);
    }

    public final RoutineElement getElementByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(Messages.ROUTINE_ELEMENT_NAME_CANNOT_BE_NULL);
        }

        for (RoutineElement element : elements) {
            if (element.getExercise().getName().equals(name)) {
                return element;
            }
        }

        return null;
    }
}
