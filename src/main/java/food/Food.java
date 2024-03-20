package food;

public class Food {
    private String brandName;
    private String description;
    private String servingSize;
    private int servingsPerContainer;

    private int calories;
    private int totalFat;
    private int saturatedFat;

    public Food(String brandName, String description, String servingSize, int servingsPerContainer, int calories,
                int totalFat, int saturatedFat) {
        this.brandName = brandName;
        this.description = description;
        this.servingSize = servingSize;
        this.servingsPerContainer = servingsPerContainer;
        this.calories = calories;
        this.totalFat = totalFat;
        this.saturatedFat = saturatedFat;
    }

    public final String getBrandName() {
        return brandName;
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

    public final void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public final void setServingsPerContainer(int servingsPerContainer) {
        this.servingsPerContainer = servingsPerContainer;
    }

    public final void setCalories(int calories) {
        this.calories = calories;
    }

    public final void setTotalFat(int totalFat) {
        this.totalFat = totalFat;
    }

    public final void setSaturatedFat(int saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

}
