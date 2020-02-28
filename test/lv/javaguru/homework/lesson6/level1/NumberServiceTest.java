package lv.javaguru.homework.lesson6.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberServiceTest {

    private NumberService numberService;

    @BeforeEach
    void setUp() {
        numberService = new NumberService();
    }

    @Test
    void shouldReturnSumInRange() {

        int from = 10;
        int to = 15;
        int expectedResult = 75;

        assertEquals(expectedResult, numberService.sumInRange(from, to));
    }

    @Test
    void shouldReturnSumInReverseRange() {

        int from = 15;
        int to = 10;
        int expectedResult = 75;

        assertEquals(expectedResult, numberService.sumInRange(from, to));
    }

    @Test
    void shouldGetEvenNumberCountInRange() {

        int from = 9;
        int to = 19;
        int expectedResult = 5;

        assertEquals(expectedResult, numberService.getEvenNumberCount(from, to));
    }

    @Test
    void shouldGetEvenNumberCountInReversedRange() {

        int from = 19;
        int to = 9;
        int expectedResult = 5;

        assertEquals(expectedResult, numberService.getEvenNumberCount(from, to));
    }
}