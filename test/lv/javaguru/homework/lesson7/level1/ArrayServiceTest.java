package lv.javaguru.homework.lesson7.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ArrayServiceTest {

    private ArrayService arrayService;

    @BeforeEach
    void setUp() {
        arrayService = new ArrayService();
    }

    @Test
    void shouldCreateArrayWithGivenSize() {
        final int SIZE = 10;
        arrayService.create(SIZE);

        assertEquals(SIZE, arrayService.getArray().length);
    }

    @Test
    void shouldFillArrayWithRandomNumbers() {
        final int SIZE = 10;
        int[] firstArray;
        int[] secondArray;

        arrayService.create(SIZE);
        arrayService.fillArrayWithRandomNumbers();
        firstArray = populateArray(SIZE, arrayService.getArray());
        arrayService.fillArrayWithRandomNumbers();
        secondArray = populateArray(SIZE, arrayService.getArray());

        assertNotEquals(Arrays.toString(firstArray), Arrays.toString(secondArray));
    }

    private int[] populateArray(int size, int[] array) {
        int[] newArray = new int[size];
        int i = 0;
        for (int element : array) {
            newArray[i] = element;
            i++;
        }
        return newArray;
    }

    @Test
    void sumInArray() {
        final int SIZE = 10;
        int[] firstArray;
        int testSum;
        arrayService.create(SIZE);
        arrayService.fillArrayWithRandomNumbers();
        firstArray = populateArray(SIZE, arrayService.getArray());
        testSum = calculateSum(firstArray);

        assertEquals(testSum, arrayService.sumInArray());
    }

    private int calculateSum(int[] firstArray) {
        int sum = 0;
        for (int number : firstArray) {
            sum += number;
        }
        return sum;
    }
}