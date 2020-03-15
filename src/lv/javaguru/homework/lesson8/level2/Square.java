package lv.javaguru.homework.lesson8.level2;

public class Square extends AbstractShape {

    protected double sideLength;

    public Square(String name, String color, double sideLength) {
        super(name, color);
        this.sideLength = sideLength;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }
}
