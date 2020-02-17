package lv.javaguru.homework.lesson6.level1;

public class NumberService {
    public int sumInRange(int from, int to) {
        int sum = 0;
        for (int i = from > to ? to : from; i <= (from > to ? from : to); i++) {
            sum += i;
        }
        return sum;
    }

    public int getEvenNumberCount(int from, int to) {
        int count = 0;
        for (int i = from > to ? to : from; i <= (from > to ? from : to); i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
