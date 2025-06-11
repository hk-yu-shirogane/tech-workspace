package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.*;

public class CalculatorTest {

    private Calculator calculator;
    @Mock
    private Logger mockLogger;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        calculator = new Calculator(mockLogger);
    }

    @AfterEach
    public void tearDown() {
        calculator.reset();
    }

    @ParameterizedTest
    @CsvSource({
        "0, 5, 5",
        "5, 3, 8",
        "-5, -3, -8"
    })
    public void testAdd(int initial, int addValue, int expected) {
        calculator.add(initial);
        calculator.add(addValue);
        assertEquals(expected, calculator.getResult());
        verify(mockLogger, atLeastOnce()).log(anyString());
    }

    @ParameterizedTest
    @CsvSource({
        "10, 3, 7",
        "0, 5, -5",
        "-5, -5, 0"
    })
    public void testSubtract(int initial, int subValue, int expected) {
        calculator.add(initial);
        calculator.subtract(subValue);
        assertEquals(expected, calculator.getResult());
        verify(mockLogger, atLeastOnce()).log(anyString());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 3, 3",
        "0, 5, 0",
        "-2, 3, -6"
    })
    public void testMultiply(int initial, int mulValue, int expected) {
        calculator.add(initial);
        calculator.multiply(mulValue);
        assertEquals(expected, calculator.getResult());
        verify(mockLogger, atLeastOnce()).log(anyString());
    }

    @ParameterizedTest
    @CsvSource({
        "10, 2, 5",
        "9, 3, 3",
        "-6, -3, 2"
    })
    public void testDivide(int initial, int divValue, int expected) {
        calculator.add(initial);
        calculator.divide(divValue);
        assertEquals(expected, calculator.getResult());
        verify(mockLogger, atLeastOnce()).log(anyString());
    }

    @Test
    public void testDivideByZero() {
        calculator.add(10);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(0);
        });
        assertEquals("division error", exception.getMessage());
        verify(mockLogger).log("Divide(0): error = division by zero");
    }

    @Test
    public void testComplexCalculation() {
        calculator.add(2);
        calculator.multiply(3);
        calculator.subtract(1);
        calculator.divide(2);
        assertEquals(2, calculator.getResult());
        verify(mockLogger, atLeastOnce()).log(anyString());
    }
}