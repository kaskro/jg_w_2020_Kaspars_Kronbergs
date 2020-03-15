package lv.javaguru.homework.lesson8.level3;

public class AdditionOperation implements MathOperation {
    @Override
    public double execute(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
