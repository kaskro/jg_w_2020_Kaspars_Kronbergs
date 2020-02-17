package lv.javaguru.homework.lesson6.level2;

public class CarTest {

    Car car = new Car();

    public void testForSettingModel(){
        String model = "Audi";
        String testName = "testForSettingModel";

        car.setModel(model);
        check(testName, car.getModel(), model);
    }

    public void testForSettingColor(){
        String color = "Red";
        String testName = "testForSettingColor";

        car.setModel(color);
        check(testName, car.getColor(), color);
    }

    public void testForSettingMaxSpeed(){
        int maxSpeed = 100;
        String testName = "testForSettingMaxSpeed";

        car.setMaxSpeed(maxSpeed);
        check(testName, car.getMaxSpeed(), maxSpeed);
    }

    public void testForSettingCurrentSpeed(){
        int currentSpeed = 20;
        String testName = "testForSettingCurrentSpeed";

        car.setMaxSpeed(currentSpeed);
        check(testName, car.getCurrentSpeed(), currentSpeed);
    }

    public void check(String testName, int actualResult, int expectedResult) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public void check(String testName, String actualResult, String expectedResult) {
        if (actualResult.equals(expectedResult)) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public void check(String testName, boolean actualResult, boolean expectedResult) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public static void main(String[] args) {

    }
}
