package profile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnthropometryTest {

    @Test
    void testValidAnthropometry() {
        Anthropometry anthropometry = new Anthropometry(180, 75);
        assertEquals(180, anthropometry.height());
        assertEquals(75, anthropometry.weight());
    }

    @Test
    void testNegativeHeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Anthropometry(-1, 75),
            "IllegalArgumentException was expected to bre thrown");
    }

    @Test
    void testNegativeWeightThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Anthropometry(190, -1),
            "IllegalArgumentException was expected to bre thrown");
    }
}

