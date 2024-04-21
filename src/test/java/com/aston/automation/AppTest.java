package com.aston.automation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void factorialIsGreaterThanOneTest() {
        assertEquals(3628800, App.getFactorial(10));
    }

    @Test
    public void factorialOfZeroTest() {
        assertEquals(1, App.getFactorial(0));
    }

    @Test
    public void factorialOfOneTest() {
        assertEquals(1, App.getFactorial(1));
    }

    @Test
    public void factorialIsLessThanZeroTest() {
        assertEquals(0, App.getFactorial(-1));
    }
}