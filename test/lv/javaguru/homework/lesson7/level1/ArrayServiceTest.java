package lv.javaguru.homework.lesson7.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceTest {

    private final int SIZE = 10;

    @Test
    void shouldCreateArrayWithGivenSize() {
        int[] array;
        array = ArrayService.create(SIZE);

        assertEquals(SIZE, array.length);
    }

    @Test
    void shouldFillArrayWithRandomNumbers() {
        int[] firstArray;
        int[] secondArray;

        firstArray = ArrayService.create(SIZE);
        ArrayService.fillArrayWithRandomNumbers(firstArray);

        secondArray = ArrayService.create(SIZE);
        ArrayService.fillArrayWithRandomNumbers(secondArray);

        assertNotEquals(Arrays.toString(firstArray), Arrays.toString(secondArray));
    }

    @Test
    void sumInArray() {
        int[] firstArray;
        int testSum;
        firstArray = ArrayService.create(SIZE);
        ArrayService.fillArrayWithRandomNumbers(firstArray);
        testSum = calculateSum(firstArray);

        assertEquals(testSum, ArrayService.sumInArray(firstArray));
    }

    @Test
    void shouldSortArray() {
        int[] firstArray;
        firstArray = ArrayService.create(SIZE);
        ArrayService.fillArrayWithRandomNumbers(firstArray);
        ArrayService.sortArray(firstArray);

        assertTrue(isSortedAsc(firstArray));
    }

    @Test
    void shouldSwapArray() {
        int[] firstArray;
        int[] firstArrayCopy;
        firstArray = ArrayService.create(SIZE);
        ArrayService.fillArrayWithRandomNumbers(firstArray);
        firstArrayCopy = Arrays.copyOf(firstArray, SIZE);
        ArrayService.swap(firstArray);

        assertTrue(isSwapped(firstArrayCopy, firstArray));
    }

    private int calculateSum(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

    private boolean isSortedAsc(int[] array) {
        if (array.length > 0) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSwapped(int[] firstArray, int[] secondArray) {
        if (firstArray.length == secondArray.length && firstArray.length > 0 && secondArray.length > 0) {
            for (int i = 0; i < firstArray.length; i++) {
                if (firstArray[i] != secondArray[secondArray.length - 1 - i]) {
                    return false;
                }
            }
        }
        return true;
    }

}