package food;

public class Food {
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

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setServingSize(String servingSize) {
            this.servingSize = servingSize;
            return this;
        }

        public Builder setServingsPerContainer(int servingsPerContainer) {
            this.servingsPerContainer = servingsPerContainer;
            return this;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder setTotalFat(int totalFat) {
            this.totalFat = totalFat;
            return this;
        }

        public Builder setSaturatedFat(int saturatedFat) {
            this.saturatedFat = saturatedFat;
            return this;
        }

        public Builder setPolyunsaturatedFat(int polyunsaturatedFat) {
            this.polyunsaturatedFat = polyunsaturatedFat;
            return this;
        }

        public Builder setMonounsaturatedFat(int monounsaturatedFat) {
            this.monounsaturatedFat = monounsaturatedFat;
            return this;
        }

        public Builder setTransFat(int transFat) {
            this.transFat = transFat;
            return this;
        }

        public Food build() {
            return new Food(this);
        }

        public Builder setProtein(int protein) {
            this.protein = protein;
            return this;
        }

        public Builder setCholesterol(int cholesterol) {
            this.cholesterol = cholesterol;
            return this;
        }

        public Builder setCarbohydrates(int carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;
        }

        public Builder setDietaryFiber(int dietaryFiber) {
            this.dietaryFiber = dietaryFiber;
            return this;
        }

        public Builder setSugars(int sugars) {
            this.sugars = sugars;
            return this;
        }
    }

    public final String getName() {
        return name;
    }

    public final String getDescription() {
        return description;
    }

    public final String getServingSize() {
        return servingSize;
    }

    public final int getServingsPerContainer() {
        return servingsPerContainer;
    }

    public final int getCalories() {
        return calories;
    }

    public final int getTotalFat() {
        return totalFat;
    }

    public final int getSaturatedFat() {
        return saturatedFat;
    }

    public final int getPolyunsaturatedFat() {
        return polyunsaturatedFat;
    }

    public final int getMonounsaturatedFat() {
        return monounsaturatedFat;
    }

    public final int getTransFat() {
        return transFat;
    }

    public final int getProtein() {
        return protein;
    }

    public final int getCholesterol() {
        return cholesterol;
    }

    public final int getCarbohydrates() {
        return carbohydrates;
    }

    public final int getDietaryFiber() {
        return dietaryFiber;
    }

    public final int getSugars() {
        return sugars;
    }
}