package lv.javaguru.homework.lesson3.level1;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();

        circle.setRadius(10);
        System.out.println("Area for circle with radius " + circle.getRadius() + " is " + circle.calculateArea());
    }
}
