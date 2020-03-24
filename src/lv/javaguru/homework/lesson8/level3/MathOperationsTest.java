package lv.javaguru.homework.lesson8.level3;

//Ok
public class MathOperationsTest {
    public static void main(String[] args) {
        MathOperation[] operationList = new MathOperation[4];
        operationList[0] = new AdditionOperation();
        operationList[1] = new SubtractOperation();
        operationList[2] = new MultiplyOperation();
        operationList[3] = new DivideOperation();

        MathOperations mathOperations = new MathOperations();
        mathOperations.executeAll(operationList, 10, 5);
    }
}
