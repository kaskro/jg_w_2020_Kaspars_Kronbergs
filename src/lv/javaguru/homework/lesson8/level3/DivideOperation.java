package lv.javaguru.homework.lesson8.level3;

public class DivideOperation implements MathOperation {
    @Override
    public double execute(double firstNumber, double secondNumber) {
        return secondNumber > 0 ? firstNumber / secondNumber : 0;
    }
}
