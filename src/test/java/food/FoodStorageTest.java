package food;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FoodStorageTest {
    private FoodStorage foodStorage;
    private Food apple;
    private Food banana;

    @BeforeEach
    public void setup() {
        apple = new Food("Apple", "Brand1", "ServingSize1", 1, 100, 10, 2, 0);
        banana = new Food("Banana", "Brand2", "ServingSize2", 2, 200, 20, 4, 0);
        List<Food> foods = new ArrayList<>();
        foods.add(apple);
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
    public void getFoodByBrandNameShouldReturnCorrectFood() {
        assertEquals(apple, foodStorage.getFoodByBrandName("Apple"));
    }

    @Test
    public void getFoodByBrandNameShouldReturnNullWhenNotFound() {
        assertNull(foodStorage.getFoodByBrandName("NonExistentBrand"));
    }

    @Test
    public void getFoodByBrandNameShouldThrowExceptionWhenNull() {
        assertThrows(IllegalArgumentException.class, () -> foodStorage.getFoodByBrandName(null));
    }
}