package lv.javaguru.homework.lesson8.level2;

public abstract class AbstractShape implements Shape {

    protected String name;
    protected String color;

    public AbstractShape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
