package lv.javaguru.homework.lesson8.level1;

import java.util.Objects;

//Ok
public class Vehicle {

    protected String brand;
    protected String color;
    protected int seats;
    protected int wheels;

    Vehicle(String brand, String color, int seats, int wheels) {
        this.brand = brand;
        this.color = color;
        this.seats = seats;
        this.wheels = wheels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return seats == vehicle.seats &&
                wheels == vehicle.wheels &&
                Objects.equals(brand, vehicle.brand) &&
                Objects.equals(color, vehicle.color);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", seats=" + seats +
                ", wheels=" + wheels +
                '}';
    }
}
