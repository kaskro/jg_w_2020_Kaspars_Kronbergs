package lv.javaguru.homework.lesson6.level1;

//OK!!
public class NumberService {
    public int sumInRange(int from, int to) {
        int sum = 0;
        for (int i = getLowest(from, to); i <= getHighest(from, to); i++) {
            sum += i;
        }
        return sum;
    }

    public int getEvenNumberCount(int from, int to) {
        int count = 0;
        for (int i = getLowest(from, to); i <= getHighest(from, to); i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private int getHighest(int a, int b) {
        return a > b ? a : b;
    }

    private int getLowest(int a, int b) {
        return a > b ? b : a;
    }
}
