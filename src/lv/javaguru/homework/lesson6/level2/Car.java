package lv.javaguru.homework.lesson6.level2;

import java.util.Objects;

public class Car {
    private String model;
    private String color;
    private int maxSpeed;
    private int currentSpeed;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return maxSpeed == car.maxSpeed &&
                currentSpeed == car.currentSpeed &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", currentSpeed=" + currentSpeed +
                '}';
    }

    public void accelerate() {
        increaseSpeed();
    }

    private void increaseSpeed() {
        //var vienkāršāk
//        if (canAccelerate()) {
//            currentSpeed++;
//        }
        currentSpeed += canAccelerate() ? 1 : 0;

    }

    public void slowDown() {
        decreaseSpeed();
    }

    //šī papildus metode nav nepieciešama, šo loģiku varēji rakstīt slowDown metodē
    private void decreaseSpeed() {
        //tas pats, kas ar increaseSpeed
        currentSpeed -= isDriving() ? 1 : 0;
    }

    public boolean isDriving() {
        return currentSpeed > 0;
    }

    public boolean canAccelerate() {
        return currentSpeed < maxSpeed;
    }

    public void speedUp() {
        while (canAccelerate()) {
            accelerate();
        }
    }

}
