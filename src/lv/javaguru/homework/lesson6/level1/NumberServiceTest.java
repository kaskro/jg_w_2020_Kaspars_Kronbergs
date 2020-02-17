package lv.javaguru.homework.lesson6.level1;

public class NumberServiceTest {

    NumberService numberService = new NumberService();

    public void testForSum() {
        String testName = "testForSum";
        int from = 10;
        int to = 12;
        int expectedResult = 33;
        int actualResult = numberService.sumInRange(from, to);

        check(testName, actualResult, expectedResult);
    }

    public void testForSumRangeReversed() {
        String testName = "testForSumRangeReversed";
        int from = 12;
        int to = 10;
        int expectedResult = 33;
        int actualResult = numberService.sumInRange(from, to);

        check(testName, actualResult, expectedResult);
    }

    public void testForEvenNumberCount() {
        String testName = "testForEvenNumberCount";
        int from = 9;
        int to = 14;
        int expectedResult = 3;
        int actualResult = numberService.getEvenNumberCount(from, to);

        check(testName, actualResult, expectedResult);
    }

    public void testForEvenNumberCountRangeReversed() {
        String testName = "testForEvenNumberCountRangeReversed";
        int from = 14;
        int to = 9;
        int expectedResult = 3;
        int actualResult = numberService.getEvenNumberCount(from, to);

        check(testName, actualResult, expectedResult);
    }

    public void check(String testName, int actualResult, int expectedResult) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public void mainTest() {
        testForSum();
        testForSumRangeReversed();
        testForEvenNumberCount();
        testForEvenNumberCountRangeReversed();
    }

    public static void main(String[] args) {
        NumberServiceTest testRunner = new NumberServiceTest();
        testRunner.mainTest();
    }
}
