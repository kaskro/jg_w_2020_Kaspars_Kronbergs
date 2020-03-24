package lv.javaguru.homework.lesson7.level1;

import java.util.Random;

//Ok
public class ArrayService {

    public static int[] create(int size) {
        return new int[size];
    }

    public static void fillArrayWithRandomNumbers(int[] array) {
        Random random = new Random();
        int randomNumber;
        for (int i = 0; i < array.length; i++) {
            randomNumber = random.nextInt(101);
            array[i] = randomNumber;
        }
    }

    public static void printArrayToConsole(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
    }

    public static int sumInArray(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

    public static void sortArray(int[] array) {
        int temp;
        for (int number : array) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    public static void swap(int[] array) {
        int temp;
        for (int i = 0; i < (array.length / 2); i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

}
