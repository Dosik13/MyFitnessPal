package profile;

public enum Gender {

    MALE("male"),
    FEMALE("female");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }

    public static Gender getByGender(String genderName) {
        genderName = genderName.toLowerCase();
        for (Gender gender : Gender.values()) {
            if (gender.gender.equals(genderName)) {
                return gender;
            }
        }

        throw new IllegalArgumentException("No enum constant with genderName: " + genderName);
    }
}
