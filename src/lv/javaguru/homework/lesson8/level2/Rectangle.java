package lv.javaguru.homework.lesson8.level2;

public class Rectangle extends AbstractShape {

    protected double width;
    protected double height;

    public Rectangle(String name, String color, double width, double height) {
        super(name, color);
        this.width = width;
        this.height = height;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
