package lv.javaguru.homework.lesson7.extra;

import java.util.Random;
import java.util.Scanner;

public class RangeCopy {

    public static void main(String[] args) {

        int[] numberArray = new int[10];
        int[] resultArray;
        int from;
        int to;
        int numberCountInRange;

        populateArrayWithRandomNumbers(numberArray);
        from = getValueFromInput("Please enter bottom range:");
        to = getValueFromInput("Please enter top range:");

        displayArrayToConsole(numberArray);
        System.out.println();

        numberCountInRange = getNumberCountInRange(numberArray, from, to);

        if (numberCountInRange > 0) {
            resultArray = createArrayCopyWithNumbersInRange(numberArray, numberCountInRange, from, to);
            displayArrayToConsole(resultArray);
        } else {
            System.out.println("There are no numbers in range from " + from + " to " + to + " in array.");
        }

    }

    private static int[] createArrayCopyWithNumbersInRange(int[] numberArray, int size, int from, int to) {
        int[] resultArray = new int[size];
        int count = 0;
        for (int number : numberArray) {
            if (isNumberInRange(from, to, number)) {
                resultArray[count] = number;
                count++;
            }
        }
        return resultArray;
    }

    private static int getNumberCountInRange(int[] numberArray, int from, int to) {
        int counter = 0;
        for (int number : numberArray) {
            if (isNumberInRange(from, to, number)) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean isNumberInRange(int from, int to, int number) {
        return number > from && number < to;
    }

    private static int getValueFromInput(String message) {
        boolean isError;
        int value = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(message);
                value = Integer.parseInt(scanner.nextLine());
                isError = false;
            } catch (Exception e) {
                isError = true;
            }
        }
        while (isError);
        return value;
    }

    private static void populateArrayWithRandomNumbers(int[] numberArray) {
        Random random = new Random();
        int randomNumber;
        for (int i = 0; i < numberArray.length; i++) {
            randomNumber = random.nextInt(100);
            numberArray[i] = randomNumber;
        }
    }

    private static void displayArrayToConsole(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
    }
}
