package lv.javaguru.homework.lesson8.level1;

//Ok
public class Car extends Vehicle {

    protected boolean isChildLockOn;

    Car(String brand, String color, int seats, int wheels, boolean isChildLockOn) {
        super(brand, color, seats, wheels);
        this.isChildLockOn = isChildLockOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return isChildLockOn == car.isChildLockOn;
    }

    @Override
    public String toString() {
        return "Car{" +
                "isChildLockOn=" + isChildLockOn +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", seats=" + seats +
                ", wheels=" + wheels +
                '}';
    }
}