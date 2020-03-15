package lv.javaguru.homework.lesson8.level2;

public class Triangle extends AbstractShape {

    protected double base;
    protected double height;

    public Triangle(String name, String color, double base, double height) {
        super(name, color);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }
}
