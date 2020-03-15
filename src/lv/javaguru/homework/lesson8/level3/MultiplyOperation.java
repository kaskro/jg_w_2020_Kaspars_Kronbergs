package lv.javaguru.homework.lesson8.level3;

public class MultiplyOperation implements MathOperation {

    @Override
    public double execute(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}
