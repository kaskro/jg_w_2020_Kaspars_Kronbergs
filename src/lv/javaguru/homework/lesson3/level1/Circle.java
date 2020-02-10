package lv.javaguru.homework.lesson3.level1;

//Ok
public class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    double calculateArea(){
        return 3.14 * radius * radius;
    }

}
