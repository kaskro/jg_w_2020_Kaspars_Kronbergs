package lv.javaguru.homework.lesson4.level2;

public class StockTest {

    public void mainTest(){
        double firstTestValue = 150;
        double maxTestValue = 150.37;
        double minTestValue = 149.82;
        double lastTestValue = 150.12;

        Stock test = new Stock("test", firstTestValue);

        test.updatePrice(maxTestValue);
        test.updatePrice(minTestValue);
        test.updatePrice(lastTestValue);

        check(test.getMax(), maxTestValue, "testForMax");
        check(test.getMin(), minTestValue, "testForMin");
        check(test.getCurrentValue(), lastTestValue, "testForCurrentValue");
    }

    public void check(double actualResult, double expectedResult, String testName) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public static void main(String[] args) {
        StockTest testRunner = new StockTest();
        testRunner.mainTest();
    }

}
