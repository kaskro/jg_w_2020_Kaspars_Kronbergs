package lv.javaguru.homework.lesson6.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//OK
class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void shouldSetAndGetModel() {

        String model = "Audi"; //nav nepieciešams iznest atsevišķā mainīgajā

        car.setModel(model);

        assertEquals(model, car.getModel());
    }

    @Test
    void shouldSetAndGetColor() {

        String color = "Red";

        car.setColor(color);

        assertEquals(color, car.getColor());
    }

    @Test
    void shouldSetAndGetMaxSpeed() {

        int maxSpeed = 100;

        car.setMaxSpeed(maxSpeed);

        assertEquals(maxSpeed, car.getMaxSpeed());
    }

    @Test
    void shouldSetAndGetCurrentSpeed() {

        int currentSpeed = 10;

        car.setCurrentSpeed(currentSpeed);

        assertEquals(currentSpeed, car.getCurrentSpeed());
    }

    @Test
    void shouldAccelerateByOne() {

        int currentSpeed = 0;
        int maxSpeed = 100;

        car.setMaxSpeed(maxSpeed);
        car.setCurrentSpeed(currentSpeed);
        car.accelerate();

        assertEquals(1, car.getCurrentSpeed());
    }

    @Test
    void shouldNotAccelerateByOneWhenSpeedIsAtMax() {

        int maxSpeed = 100;

        car.setMaxSpeed(maxSpeed);
        car.setCurrentSpeed(maxSpeed);
        car.accelerate();

        assertEquals(100, car.getCurrentSpeed());
    }

    @Test
    void shouldSlowDownByOne() {

        int currentSpeed = 10;
        int maxSpeed = 100;

        car.setCurrentSpeed(currentSpeed);
        car.setMaxSpeed(maxSpeed);
        car.slowDown();

        assertEquals(9, car.getCurrentSpeed());
    }

    @Test
    void shouldNotSlowDownByOneWhenSpeedIsZero() {

        int currentSpeed = 0;
        int maxSpeed = 100;

        car.setCurrentSpeed(currentSpeed);
        car.setMaxSpeed(maxSpeed);
        car.slowDown();

        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void shouldBeFalseWhenIsDrivingNotSet() {

        assertFalse(car.isDriving());
    }

    @Test
    void shouldBeFalseWhenSpeedIsMax() {

        int maxSpeed = 200;

        car.setCurrentSpeed(maxSpeed);
        car.setMaxSpeed(maxSpeed);

        assertFalse(car.canAccelerate());
    }

    @Test
    void shouldBeTrueWhenSpeedIsBelowMax() {

        int maxSpeed = 200;
        int currentSpeed = 10;

        car.setCurrentSpeed(currentSpeed);
        car.setMaxSpeed(maxSpeed);

        assertTrue(car.canAccelerate());
    }

    @Test
    void shouldSpeedUpWhenSpeedIsBelowMaxSpeed() {

        int maxSpeed = 400;
        int currentSpeed = 0;

        car.setCurrentSpeed(currentSpeed);
        car.setMaxSpeed(maxSpeed);
        car.speedUp();

        assertEquals(maxSpeed, car.getCurrentSpeed());
    }

    @Test
    void shouldBeEqualsCards() {

        String model = "Audi";
        String color = "Gray";
        int maxSpeed = 300;
        int currentSpeed = 0;

        Car firstCar = createCar(model, color, maxSpeed, currentSpeed);

        Car secondCar = createCar(model, color, maxSpeed, currentSpeed);

        assertTrue(firstCar.equals(secondCar));
    }

    private Car createCar(String model, String color, int maxSpeed, int currentSpeed) {
        car = new Car();
        car.setModel(model);
        car.setColor(color);
        car.setMaxSpeed(maxSpeed);
        car.setCurrentSpeed(currentSpeed);
        return car;
    }

    @Test
    void shouldNotBeEqualsCars() {

        String model = "Audi";
        String color = "Gray";
        int maxSpeed = 300;
        int currentSpeed = 0;

        Car firstCar = createCar(model, color, maxSpeed, currentSpeed);

        Car secondCar = createCar("BMW", "Black", maxSpeed, currentSpeed);

        assertFalse(firstCar.equals(secondCar));
    }

    @Test
    void shouldReturnTrueWhenStringHasCorrectFormat() {

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

        car.setModel(model);
        car.setColor(color);
        car.setMaxSpeed(maxSpeed);
        car.setCurrentSpeed(currentSpeed);

        assertEquals(correctFormat, car.toString());
    }
}