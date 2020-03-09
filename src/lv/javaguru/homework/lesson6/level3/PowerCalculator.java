package lv.javaguru.homework.lesson6.level3;

//OK
public class PowerCalculator {
    public int pow(int number, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return number < 0 ? result * -1 : result;
    }
}
