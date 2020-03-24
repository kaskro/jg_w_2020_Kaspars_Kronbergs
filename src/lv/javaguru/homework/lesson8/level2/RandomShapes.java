package lv.javaguru.homework.lesson8.level2;

import java.util.Random;

//Šeit esi pārcenties
//Te varēji vienkāŗši izveidot no katra tipa pa vienai fugūrai un ar to pietiktu
public class RandomShapes {
    public static void main(String[] args) {

        Random random = new Random();
        int shapeNumber;
        int shapeCount = 0;
        int min = 5;
        int max = 20;
        int arraySize = getRandomNumberInRange(random, min, max);

        Shape[] randomShapeArray = new Shape[arraySize];

        while (shapeCount < arraySize) {
            shapeNumber = random.nextInt(5);
            randomShapeArray[shapeCount] = createRandomShape(shapeNumber, shapeCount, random, min, max);
            shapeCount++;
        }
        for (Shape shape : randomShapeArray) {
            showInfo(shape);
        }
    }

    private static Shape createRandomShape(int shapeNumber, int shapeCount, Random random, int min, int max) {
        Shape shape;
        switch (shapeNumber) {
            case 0:
                shape = new Circle("Circle" + shapeCount, pickRandomColor(random.nextInt(5)), getRandomNumberInRange(random, min, max));
                break;
            case 1:
                shape = new Triangle("Triangle" + shapeCount, pickRandomColor(random.nextInt(5)), getRandomNumberInRange(random, min, max), getRandomNumberInRange(random, min, max));
                break;
            case 2:
                shape = new Square("Square" + shapeCount, pickRandomColor(random.nextInt(5)), getRandomNumberInRange(random, min, max));
                break;
            case 3:
                shape = new Rectangle("Rectangle" + shapeCount, pickRandomColor(random.nextInt(5)), getRandomNumberInRange(random, min, max), getRandomNumberInRange(random, min, max));
                break;
            default:
                shape = new Rhombus("Rhombus" + shapeCount, pickRandomColor(random.nextInt(5)), getRandomNumberInRange(random, min, max), getRandomNumberInRange(random, min, max));
                break;
        }
        return shape;
    }

    private static int getRandomNumberInRange(Random random, int min, int max) {
        return random.nextInt(max) + min;
    }

    private static void showInfo(Shape shape) {
        System.out.println(shape.getName() + " with area " + shape.getArea());
    }

    private static String pickRandomColor(int colorNumber) {
        String color;
        switch (colorNumber) {
            case 0:
                color = "Blue";
                break;
            case 1:
                color = "Red";
                break;
            case 2:
                color = "Green";
                break;
            case 3:
                color = "Yellow";
                break;
            default:
                color = "Purple";
                break;
        }
        return color;
    }
}
