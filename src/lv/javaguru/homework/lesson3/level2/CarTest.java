package lv.javaguru.homework.lesson3.level2;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();

        car.setColor("Gray");
        System.out.println("Color of the car is \"" + car.getColor() + "\".");

        car.setBrand("Audi");
        System.out.println("Brand of the car is \"" + car.getBrand() + "\".");

        car.setYear(2000);
        System.out.println("Year of the car is \"" + car.getYear() + "\".");
    }
}
