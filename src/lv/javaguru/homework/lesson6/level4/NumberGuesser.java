package lv.javaguru.homework.lesson6.level4;

import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {

        int rangeFrom = 1;
        int rangeTo = 100;
        int guessedNumber = 0;
        String action;
        boolean isNumberFound = false;
        boolean isError = true;

        Scanner scanner = new Scanner(System.in);

        while (isError) {
            try {
                System.out.println("Please enter number in range from " + rangeFrom + " to " + rangeTo + ":");
                guessedNumber = Integer.parseInt(scanner.nextLine());
                isError = false;
            } catch (Exception e) {
                isError = true;
            }
        }
        while (!isNumberFound) {

            System.out.println("Is this number " + guessedNumber + " '>', '<' or '=' to imagined number");
            action = scanner.nextLine();
            switch (action) {
                case ">":
                    if (isMaxRangeReached(rangeTo, guessedNumber)) {
                        guessedNumber = rangeTo;
                    } else {
                        rangeFrom = guessedNumber;
                        guessedNumber = calculateGuessedNumber(rangeFrom, rangeTo);
                    }
                    break;
                case "<":
                    rangeTo = guessedNumber;
                    guessedNumber = calculateGuessedNumber(rangeFrom, rangeTo);
                    break;
                case "=":
                    rangeTo = guessedNumber;
                    break;
            }
            if (isNumberSameAsRangeLimit(rangeFrom, rangeTo, guessedNumber)) {
                System.out.println("You imagined number " + guessedNumber);
                isNumberFound = true;
            }

        }


    }

    private static boolean isNumberSameAsRangeLimit(int rangeFrom, int rangeTo, int guessedNumber) {
        return rangeFrom == guessedNumber || rangeTo == guessedNumber;
    }

    private static boolean isMaxRangeReached(int rangeTo, int guessedNumber) {
        return guessedNumber == rangeTo - 1;
    }

    private static int calculateGuessedNumber(int rangeFrom, int rangeTo) {
        return rangeFrom + (rangeTo - rangeFrom) / 2;
    }
}
