package food;

public final class Food {
    private String name;
    private String description;
    private String servingSize;
    private int servingsPerContainer;
    private int calories;
    private int totalFat;
    private int saturatedFat;
    private int polyunsaturatedFat;
    private int monounsaturatedFat;
    private int transFat;
    private int protein;
    private int cholesterol;
    private int carbohydrates;
    private int dietaryFiber;
    private int sugars;

    private Food(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.servingSize = builder.servingSize;
        this.servingsPerContainer = builder.servingsPerContainer;
        this.calories = builder.calories;
        this.totalFat = builder.totalFat;
        this.saturatedFat = builder.saturatedFat;
        this.polyunsaturatedFat = builder.polyunsaturatedFat;
        this.monounsaturatedFat = builder.monounsaturatedFat;
        this.transFat = builder.transFat;
        this.protein = builder.protein;
        this.cholesterol = builder.cholesterol;
        this.carbohydrates = builder.carbohydrates;
        this.dietaryFiber = builder.dietaryFiber;
        this.sugars = builder.sugars;
    }

    public static class Builder {
        private String name;
        private String description;
        private String servingSize;
        private int servingsPerContainer;
        private int calories;
        private int totalFat;
        private int saturatedFat;
        private int polyunsaturatedFat;
        private int monounsaturatedFat;
        private int transFat;
        private int protein;
        private int cholesterol;
        private int carbohydrates;
        private int dietaryFiber;
        private int sugars;

        public final Builder setName(String name) {
            this.name = name;
            return this;
        }

        public final Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public final Builder setServingSize(String servingSize) {
            this.servingSize = servingSize;
            return this;
        }

        public final Builder setServingsPerContainer(int servingsPerContainer) {
            this.servingsPerContainer = servingsPerContainer;
            return this;
        }

        public final Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public final Builder setTotalFat(int totalFat) {
            this.totalFat = totalFat;
            return this;
        }

        public final Builder setSaturatedFat(int saturatedFat) {
            this.saturatedFat = saturatedFat;
            return this;
        }

        public final Builder setPolyunsaturatedFat(int polyunsaturatedFat) {
            this.polyunsaturatedFat = polyunsaturatedFat;
            return this;
        }

        public final Builder setMonounsaturatedFat(int monounsaturatedFat) {
            this.monounsaturatedFat = monounsaturatedFat;
            return this;
        }

        public final Builder setTransFat(int transFat) {
            this.transFat = transFat;
            return this;
        }

        public final Builder setProtein(int protein) {
            this.protein = protein;
            return this;
        }

        public final Builder setCholesterol(int cholesterol) {
            this.cholesterol = cholesterol;
            return this;
        }

        public final Builder setCarbohydrates(int carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;
        }

        public final Builder setDietaryFiber(int dietaryFiber) {
            this.dietaryFiber = dietaryFiber;
            return this;
        }

        public final Builder setSugars(int sugars) {
            this.sugars = sugars;
            return this;
        }

        public final Food build() {
            return new Food(this);
        }

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getServingSize() {
        return servingSize;
    }

    public int getServingsPerContainer() {
        return servingsPerContainer;
    }

    public int getCalories() {
        return calories;
    }

    public int getTotalFat() {
        return totalFat;
    }

    public int getSaturatedFat() {
        return saturatedFat;
    }

    public int getPolyunsaturatedFat() {
        return polyunsaturatedFat;
    }

    public int getMonounsaturatedFat() {
        return monounsaturatedFat;
    }

    public int getTransFat() {
        return transFat;
    }

    public int getProtein() {
        return protein;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getDietaryFiber() {
        return dietaryFiber;
    }

    public int getSugars() {
        return sugars;
    }
}
