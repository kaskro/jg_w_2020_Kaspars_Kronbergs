package lv.javaguru.homework.lesson8.level3;

public class MathOperations {

    public void executeAll(MathOperation[] mathOperationList, double firstNumber, double secondNumber) {
        for (MathOperation operation : mathOperationList) {
            System.out.println(operation.execute(firstNumber, secondNumber));
        }
    }
}
