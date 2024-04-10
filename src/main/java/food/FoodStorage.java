package food;

import java.util.List;

public class FoodStorage {
    private List<Food> foods;

    public FoodStorage(List<Food> foods) {
        this.foods = foods;
    }

    public final List<Food> getFoods() {
        return foods;
    }

    public final void addFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Food cannot be null");
        }
        foods.add(food);
    }

    public final void removeFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Food cannot be null");
        }
        foods.remove(food);
    }

    public final Food getFoodByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(" name cannot be null");
        }
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }
}
