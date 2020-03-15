package lv.javaguru.homework.lesson8.level1;

public class Truck extends Vehicle {

    protected int cargoWeight;

    Truck(String brand, String color, int seats, int wheels, int cargoWeight) {
        super(brand, color, seats, wheels);
        this.cargoWeight = cargoWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return cargoWeight == truck.cargoWeight;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "cargoWeight=" + cargoWeight +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", seats=" + seats +
                ", wheels=" + wheels +
                '}';
    }
}
