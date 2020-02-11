package lv.javaguru.homework.lesson2.level1;

public class MathOperations {
    public static void main(String[] args) {

        int firstNumber = 10;
        int secondNumber = 5;
        int sum = firstNumber + secondNumber;
        int substraction = firstNumber - secondNumber;
        int multiply = firstNumber * secondNumber;
        int division = firstNumber / secondNumber;
        //Labāk tomēr izmantot mainīgos ar atbilstošiem nosaukumiem. Tā bus vieglak saprast
        //Izvadi atstāt uz beigām
        System.out.println(firstNumber + " + " + secondNumber + " = " + sum);
        System.out.println(firstNumber + " - " + secondNumber + " = " + substraction);
        System.out.println(firstNumber + " * " + secondNumber + " = " + multiply);
        System.out.println(firstNumber + " / " + secondNumber + " = " + division);
    }
}
