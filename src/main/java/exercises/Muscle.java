package exercises;

public enum Muscle {
    BICEPS("Biceps"),
    TRICEPS("Triceps"),
    DELTOIDS("Deltoids"),
    CHEST("Chest"),
    LATS("Lats"),
    ABS("Abs"),
    OBLIQUES("Obliques"),
    QUADS("Quads"),
    HAMSTRINGS("Hamstrings"),
    CALVES("Calves"),
    GLUTES("Glutes"),
    TRAPS("Traps"),
    FOREARMS("Forearms"),
    SERRATUS("Serratus"),
    ADDUCTORS("Adductors"),
    SOLEUS("Soleus"),
    GASTROCNEMIUS("Gastrocnemius"),
    LOWER_BACK("Lower Back"),
    RHOMBOIDS("Rhomboids"),
    TERES_MAJOR("Teres Major"),
    UPPER_BACK("Upper Back");

    private final String muscleName;

    Muscle(String muscleName) {
        this.muscleName = muscleName;
    }

    @Override
    public String toString() {
        return muscleName;
    }
}

