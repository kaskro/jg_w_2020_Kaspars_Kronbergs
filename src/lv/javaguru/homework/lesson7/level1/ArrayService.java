package lv.javaguru.homework.lesson7.level1;

import java.util.Random;

public class ArrayService {

    public static int[] create(int size) {
        int[] array = new int[size]; //šeit ureiz vari atdot masīvu jauno, neveidojot papildus mainīgo
        return array;
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
        //if nav vajadzīgs, jo cikla nosacījums neizpildās
        //aizkomentējot šo rindu visi testi ir zaļi ;)
//        if (array.length > 0) {
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
//        }
    }

    public static void swap(int[] array) {
        //if nav vajadzīgs, jo cikla nosacījums neizpildās
        //aizkomentējot šo rindu visi testi ir zaļi ;)
//        if (array.length > 0) {
            int temp;
            for (int i = 0; i < (array.length / 2); i++) {
                temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
//        }
    }

}
