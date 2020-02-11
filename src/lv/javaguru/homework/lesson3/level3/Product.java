package lv.javaguru.homework.lesson3.level3;

//Ok, bet izmanto kombināciju "ctrl + alt + l"
public class Product {
    private String name;
    private double regularPrice;
    private double discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    //trūkst public
    public double calculateActualPrice() {
        return regularPrice - (regularPrice * discount) / 100;
    }

    public void printInformation() {
        System.out.print("Product : ");
        System.out.print("name = " + getName() + ", ");
        System.out.print("regular price = " + getRegularPrice() + ", ");
        System.out.print("discount = " + (int) getDiscount() + "%, "); //procentiem jābūt izdrukātiem bez ",0"
        System.out.print("actual price = " + calculateActualPrice() + " EUR");
    }
}
