package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdderTest {
    private final Adder adder = new Adder();

    @Test
    void whenAddingNumbersExpectCorrectResult() {
        assertEquals(5, adder.add(2, 3));
    }
}
