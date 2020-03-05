package lv.javaguru.homework.lesson7.level1;

import java.util.Random;

public class ArrayService {

    private int[] array;

    public int[] getArray() {
        return array;
    }

    public void create(int size) {
        array = new int[size];
    }

    public void fillArrayWithRandomNumbers() {
        Random random = new Random();
        int randomNumber;
        for (int i = 0; i < array.length; i++) {
            randomNumber = random.nextInt(101);
            array[i] = randomNumber;
        }
    }

    public void printArrayToConsole() {
        for (int number : array) {
            System.out.print(number + " ");
        }
    }

    public int sumInArray() {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

}
