package lv.javaguru.homework.lesson6.level3;

public class PowerCalculatorTest {

    public static void main(String[] args) {

        PowerCalculator powerCalculator = new PowerCalculator();

        int number = 2;
        int power = 10;

        System.out.println(number + "^" + power + " = " + powerCalculator.pow(number, power));
    }
}
