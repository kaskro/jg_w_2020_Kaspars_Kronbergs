package lv.javaguru.homework.lesson6.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Ok
//vēl varēji patestēt kā tas darbojas ar negatīviem skaitļiem
class NumberServiceTest {

    private NumberService numberService;

    @BeforeEach
    void setUp() {
        numberService = new NumberService();
    }

    @Test
    void shouldReturnSumInRange() {
        //šos mainīoos vari neiznest
        //nodarbībās to es daru, lai visiem būtu uzskatamāk un saprotamāk
        assertEquals(75, numberService.sumInRange(10, 15));
    }

    @Test
    void shouldReturnSumInReverseRange() {
        assertEquals(75, numberService.sumInRange(15, 10));
    }

    @Test
    void shouldReturnSumInNegativeRange() {
        assertEquals(-75, numberService.sumInRange(-10,-15));
    }

    @Test
    void shouldGetEvenNumberCountInNegativeRange() {
        assertEquals(5, numberService.getEvenNumberCount(-9, -19));
    }


    @Test
    void shouldGetEvenNumberCountInRange() {
        assertEquals(5, numberService.getEvenNumberCount(9, 19));
    }

    @Test
    void shouldGetEvenNumberCountInReversedRange() {
        assertEquals(5, numberService.getEvenNumberCount(19, 9));
    }
}