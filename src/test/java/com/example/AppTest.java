package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, FactorialService.calculateFactorial(0));
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialService.calculateFactorial(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialService.calculateFactorial(-1);
    }
}
