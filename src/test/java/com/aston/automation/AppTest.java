package com.aston.automation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @ParameterizedTest
    @CsvSource({"10, 3628800", "0, 1", "1,1", "-1,0"})
    public void factorialTests(int input, int expected) {
        assertEquals(expected, App.getFactorial(input));
    }
}