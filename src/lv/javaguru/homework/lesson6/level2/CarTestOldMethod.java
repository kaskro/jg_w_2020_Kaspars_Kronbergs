package lv.javaguru.homework.lesson6.level2;

public class CarTestOldMethod {

    Car car = new Car();

    public void testForSettingModel() {
        String model = "Audi";
        String testName = "testForSettingModel";

        car.setModel(model);
        check(testName, car.getModel(), model);
    }

    public void testForSettingColor() {
        String color = "Red";
        String testName = "testForSettingColor";

        car.setColor(color);
        check(testName, car.getColor(), color);
    }

    public void testForSettingMaxSpeed() {
        int maxSpeed = 100;
        String testName = "testForSettingMaxSpeed";

        car.setMaxSpeed(maxSpeed);
        check(testName, car.getMaxSpeed(), maxSpeed);
    }

    public void testForSettingCurrentSpeed() {
        int currentSpeed = 20;
        String testName = "testForSettingCurrentSpeed";

        car.setCurrentSpeed(currentSpeed);
        check(testName, car.getCurrentSpeed(), currentSpeed);
    }

    public void testForCarIsDriving() {
        int currentSpeed = 20;
        String testName = "testForCarDriving";

        car.setCurrentSpeed(currentSpeed);
        check(testName, car.isDriving(), true);
    }

    public void testForCarIsNotDriving() {
        int currentSpeed = 0;
        String testName = "testForCarIsNotDriving";

        car.setCurrentSpeed(currentSpeed);
        check(testName, car.isDriving(), false);
    }

    public void testForAcceleration() {
        int currentSpeed = 20;
        int speedAfterAcceleration = 21;
        String testName = "testForAcceleration";

        car.setCurrentSpeed(currentSpeed);
        car.accelerate();
        check(testName, car.getCurrentSpeed(), speedAfterAcceleration);
    }

    public void testForAccelerationAtMaxSpeed() {
        int maxSpeed = 100;
        String testName = "testForAccelerationAtMaxSpeed";

        car.setMaxSpeed(maxSpeed);
        car.setCurrentSpeed(maxSpeed);
        car.accelerate();
        check(testName, car.getCurrentSpeed(), maxSpeed);
    }

    public void testForSlowingDown() {
        int currentSpeed = 20;
        int speedAfterSlowingDown = 19;
        String testName = "testForSlowingDown";

        car.setCurrentSpeed(currentSpeed);
        car.slowDown();
        check(testName, car.getCurrentSpeed(), speedAfterSlowingDown);
    }

    public void testForSlowingDownWhenCarSpeedIsZero() {
        int currentSpeed = 0;
        String testName = "testForSlowingDownWhenCarSpeedIsZero";

        car.setCurrentSpeed(currentSpeed);
        car.slowDown();
        check(testName, car.getCurrentSpeed(), currentSpeed);
    }

    public void testForSpeedUp() {
        int currentSpeed = 0;
        int maxSpeed = 100;
        String testName = "testForSpeedUp";

        car.setMaxSpeed(maxSpeed);
        car.setCurrentSpeed(currentSpeed);
        car.speedUp();
        check(testName, car.getCurrentSpeed(), maxSpeed);
    }

    public void testCanAccelerate() {
        int currentSpeed = 99;
        int maxSpeed = 100;
        String testName = "testCanAccelerate";

        car.setMaxSpeed(maxSpeed);
        car.setCurrentSpeed(currentSpeed);
        check(testName, car.canAccelerate(), true);
    }

    public void testCanNotAccelerate() {
        int currentSpeed = 100;
        int maxSpeed = 100;
        String testName = "testCanNotAccelerate";

        car.setMaxSpeed(maxSpeed);
        car.setCurrentSpeed(currentSpeed);
        check(testName, car.canAccelerate(), false);
    }

    public void testForToStringFormat() {

        String testName = "testForToStringFormat";
        String model = "Audi";
        String color = "Gray";
        int maxSpeed = 300;
        int currentSpeed = 0;
        String correctFormat = "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", currentSpeed=" + currentSpeed +
                '}';

        Car car = new Car();
        car.setModel(model);
        car.setColor(color);
        car.setMaxSpeed(maxSpeed);
        car.setCurrentSpeed(currentSpeed);

        check(testName, correctFormat, car.toString());
    }

    public void mainTest() {
        testForSettingModel();
        testForSettingColor();
        testForSettingCurrentSpeed();
        testForCarIsNotDriving();
        testForCarIsDriving();
        testCanAccelerate();
        testCanNotAccelerate();
        testForSettingMaxSpeed();
        testForAcceleration();
        testForAccelerationAtMaxSpeed();
        testForSlowingDown();
        testForSlowingDownWhenCarSpeedIsZero();
        testForSpeedUp();
        testForToStringFormat();
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
        CarTestOldMethod testRunner = new CarTestOldMethod();
        testRunner.mainTest();
    }
}
