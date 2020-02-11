package lv.javaguru.homework.lesson3.level2;

//Ok, tik atstarpes, inicializācija viena daļa, izvade otra
public class CarTest {
    public static void main(String[] args) {

        Car car = new Car();
        car.setColor("Gray");
        car.setBrand("Audi");
        car.setYear(2000);

        System.out.println("Color of the car is \"" + car.getColor() + "\".");
        System.out.println("Brand of the car is \"" + car.getBrand() + "\".");
        System.out.println("Year of the car is \"" + car.getYear() + "\".");
    }
}
