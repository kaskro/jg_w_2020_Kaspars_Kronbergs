package lv.javaguru.homework.lesson3.level3;

public class Product {
    String name;
    double regularPrice;
    double discount;

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

    double calculateActualPrice(){
        return regularPrice - (regularPrice * discount)/100;
    }

    public void printInformation(){
        System.out.print("Product : ");
        System.out.print("name = " + getName() + ", ");
        System.out.print("regular price = " + getRegularPrice() + ", ");
        System.out.print("discount = " + getDiscount() + "%, ");
        System.out.print("actual price = " + calculateActualPrice() + " EUR");
    }
}
