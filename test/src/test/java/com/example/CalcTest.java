package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalcTest {

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "-5, -3, -8",
        "7, -2, 5",
        "0, 5, 5",
        "3, 0, 3"
    })
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, Calc.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "5, 3, 2",
        "-3, -5, 2",
        "7, -2, 9",
        "5, 0, 5",
        "0, 3, -3"
    })
    public void testSubtract(int a, int b, int expected) {
        assertEquals(expected, Calc.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 6",
        "-2, -3, 6",
        "2, -3, -6",
        "5, 0, 0",
        "0, 3, 0"
    })
    public void testMultiply(int a, int b, int expected) {
        assertEquals(expected, Calc.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "6, 3, 2",
        "-6, -3, 2",
        "6, -3, -2"
    })
    public void testDivide(int a, int b, int expected) {
        assertEquals(expected, Calc.divide(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "5, 0",
        "0, 0"
    })
    public void testDivideByZero(int a, int b) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calc.divide(a, b);
        });
        assertEquals("0で除算された", exception.getMessage());
    }
}
