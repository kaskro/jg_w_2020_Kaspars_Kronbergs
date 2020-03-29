package lv.javaguru.homework.lesson7.level1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceTest {

    private final int SIZE = 10;

    @Test
    void shouldCreateArrayWithGivenSize() {
        int[] array = ArrayService.create(SIZE);

        assertEquals(SIZE, array.length);
    }

    @Test
    void shouldFillArrayWithRandomNumbers() {
        int[] firstArray = ArrayService.create(SIZE);
        int[] secondArray = ArrayService.create(SIZE);


        ArrayService.fillArrayWithRandomNumbers(firstArray);
        ArrayService.fillArrayWithRandomNumbers(secondArray);

        assertNotEquals(Arrays.toString(firstArray), Arrays.toString(secondArray));
    }

    @Test
    void sumInArray() {
        int[] testArray = {1,2,3,4,5};
        int testSum = 15;

        assertEquals(testSum, ArrayService.sumInArray(testArray));
    }

    @Test
    void shouldSortArray() {
        int[] firstArray = ArrayService.create(SIZE);

        ArrayService.fillArrayWithRandomNumbers(firstArray);
        ArrayService.sortArray(firstArray);

        assertTrue(isSortedAsc(firstArray));
    }

    @Test
    void shouldSwapArray() {
        int[] firstArray = ArrayService.create(SIZE);

        ArrayService.fillArrayWithRandomNumbers(firstArray);

        int[] firstArrayCopy = Arrays.copyOf(firstArray, SIZE);
        ArrayService.swap(firstArray);

        assertTrue(isSwapped(firstArrayCopy, firstArray));
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