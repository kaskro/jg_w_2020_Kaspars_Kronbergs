package lv.javaguru.homework.lesson6.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerCalculatorTest {

    @Test
    void shouldCalculatePow() {

        int number = 2;
        int power = 5;
        int expectedResult = 32;

        PowerCalculator powerCalculator = new PowerCalculator();

        assertEquals(expectedResult, powerCalculator.pow(number, power));
    }
}