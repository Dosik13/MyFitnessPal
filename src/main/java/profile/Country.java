package profile;

public enum Country {
    RUSSIA("russia"),
    UKRAINE("ukraine"),
    FRANCE("france"),
    SPAIN("spain"),
    SWEDEN("sweden"),
    NORWAY("norway"),
    GERMANY("germany"),
    FINLAND("finland"),
    POLAND("poland"),
    ITALY("italy"),
    UNITED_KINGDOM("united kingdom"),
    ROMANIA("romania"),
    BELARUS("belarus"),
    KAZAKHSTAN("kazakhstan"),
    GREECE("greece"),
    BULGARIA("bulgaria"),
    ICELAND("iceland"),
    HUNGARY("hungary"),
    PORTUGAL("portugal"),
    AUSTRIA("austria");

    private String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return countryName;
    }

    public static Country getByCountryName(String countryName) {
        countryName = countryName.toLowerCase();
        for (Country country : Country.values()) {
            if (country.countryName.equals(countryName)) {
                return country;
            }
        }

        throw new IllegalArgumentException("No enum constant with countryName: " + countryName);
    }
}
