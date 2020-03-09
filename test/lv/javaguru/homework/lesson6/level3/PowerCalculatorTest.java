package lv.javaguru.homework.lesson6.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//trūkst tests ar negatīvu vērtību un 0
class PowerCalculatorTest {

    @Test
    void shouldCalculatePow() {

        int number = 2;
        int power = 5;
        int expectedResult = 32;

        PowerCalculator powerCalculator = new PowerCalculator();

        assertEquals(expectedResult, powerCalculator.pow(number, power));
    }

    @Test
    void shouldCalculatePowFromNegativeNumber() {

        int number = -2;
        int power = 4;
        int expectedResult = -16;

        PowerCalculator powerCalculator = new PowerCalculator();

        assertEquals(expectedResult, powerCalculator.pow(number, power));
    }

    @Test
    void shouldCalculatePowFromZero() {

        int number = 0;
        int power = 4;
        int expectedResult = 0;

        PowerCalculator powerCalculator = new PowerCalculator();

        assertEquals(expectedResult, powerCalculator.pow(number, power));
    }


}