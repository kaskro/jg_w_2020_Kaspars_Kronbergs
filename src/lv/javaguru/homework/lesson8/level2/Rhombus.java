package lv.javaguru.homework.lesson8.level2;

public class Rhombus extends AbstractShape {

    protected double firstDiameter;
    protected double secondDiameter;

    public Rhombus(String name, String color, double firstDiameter, double secondDiameter) {
        super(name, color);
        this.firstDiameter = firstDiameter;
        this.secondDiameter = secondDiameter;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return (firstDiameter * secondDiameter) / 2;
    }
}
