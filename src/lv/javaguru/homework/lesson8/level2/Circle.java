package lv.javaguru.homework.lesson8.level2;

public class Circle extends AbstractShape {

    protected double radius;

    Circle(String name, String color, double radius) {
        super(name, color);
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return radius * radius * 3.14;  //izmanto Math vai arī iznes 3.14 kostantē
    }
}
