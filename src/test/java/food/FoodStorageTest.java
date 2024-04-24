package food;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FoodStorageTest {
    private FoodStorage foodStorage;
    private Food apple;
    private Food banana;

    @BeforeEach
    public void setup() {
        apple = new Food.Builder().setName("Apple").setDescription("Apple description")
            .setServingSize("1 medium apple").setServingsPerContainer(1).setCalories(95)
            .setTotalFat(0).setSaturatedFat(0).setPolyunsaturatedFat(0).setMonounsaturatedFat(0)
            .setTransFat(0).setCarbohydrates(25).setDietaryFiber(4).setSugars(19).setProtein(1).setCholesterol(0)
            .build();
        banana =
            new Food.Builder().setName("Banana").setDescription("Banana description").setServingSize("1 medium banana")
                .setServingsPerContainer(1).setCalories(105).setTotalFat(0).setSaturatedFat(0).setPolyunsaturatedFat(0)
                .setMonounsaturatedFat(0).setTransFat(0).setCarbohydrates(27).setDietaryFiber(3).setSugars(14)
                .setProtein(1)
                .setCholesterol(0).build();
        List<Food> foods = new ArrayList<>();
        foods.add(apple);
        foods.add(banana);
        foodStorage = new FoodStorage(foods);
    }

    @Test
    public void addFoodShouldAddFoodToList() {
        foodStorage.addFood(banana);
        assertTrue(foodStorage.getFoods().contains(banana));
    }

    @Test
    public void addFoodShouldThrowExceptionWhenNull() {
        assertThrows(IllegalArgumentException.class, () -> foodStorage.addFood(null));
    }

    @Test
    public void removeFoodShouldRemoveFoodFromList() {
        foodStorage.removeFood(apple);
        assertFalse(foodStorage.getFoods().contains(apple));
    }

    @Test
    public void removeFoodShouldThrowExceptionWhenNull() {
        assertThrows(IllegalArgumentException.class, () -> foodStorage.removeFood(null));
    }

    @Test
    public void getFoodByNameShouldReturnCorrectFood() {
        assertEquals(apple, foodStorage.getFoodByName("Apple"));
    }

    @Test
    public void getFoodByNameShouldReturnNullWhenNotFound() {
        assertNull(foodStorage.getFoodByName("NonExistent"));
    }

    @Test
    public void getFoodByNameShouldThrowExceptionWhenNull() {
        assertThrows(IllegalArgumentException.class, () -> foodStorage.getFoodByName(null));
    }

    @Test
    public void getFoodsShouldReturnCorrectFoods() {
        List<Food> foods = foodStorage.getFoods();
        assertEquals(2, foods.size());
        assertTrue(foods.contains(apple));
        assertTrue(foods.contains(banana));
    }
}
