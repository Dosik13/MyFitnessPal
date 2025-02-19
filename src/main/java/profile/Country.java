package profile;

public enum Country {
    RUSSIA("Russia"),
    UKRAINE("Ukraine"),
    FRANCE("France"),
    SPAIN("Spain"),
    SWEDEN("Sweden"),
    NORWAY("Norway"),
    GERMANY("Germany"),
    FINLAND("Finland"),
    POLAND("Poland"),
    ITALY("Italy"),
    UNITED_KINGDOM("United_Kingdom"),
    ROMANIA("Romania"),
    BELARUS("Belarus"),
    KAZAKHSTAN("Kazakhstan"),
    GREECE("Greece"),
    BULGARIA("Bulgaria"),
    ICELAND("Iceland"),
    HUNGARY("Hungary"),
    PORTUGAL("Portugal"),
    AUSTRIA("Austria");

    private String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return countryName;
    }

    public static Country getFromString(String countryName) {
        for (Country country : Country.values()) {
            if (country.countryName.equalsIgnoreCase(countryName)) {
                return country;
            }
        }

        throw new IllegalArgumentException("No enum constant with countryName: " + countryName);
    }
}
