package lv.javaguru.homework.lesson6.level3;

public class PowerCalculator {
    public int pow(int number, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }
}
