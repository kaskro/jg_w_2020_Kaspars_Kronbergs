package lv.javaguru.homework.lesson8.level1;

public class Bus extends Vehicle {

    protected boolean isDoorsOpened;

    Bus(String brand, String color, int seats, int wheels, boolean isDoorOpened) {
        super(brand, color, seats, wheels);
        this.isDoorsOpened = isDoorOpened;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return isDoorsOpened == bus.isDoorsOpened;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "isDoorsOpened=" + isDoorsOpened +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", seats=" + seats +
                ", wheels=" + wheels +
                '}';
    }
}
