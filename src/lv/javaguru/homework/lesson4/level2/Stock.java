package lv.javaguru.homework.lesson4.level2;

public class Stock {
    String company;
    double currentValue;
    double max;
    double min;

    Stock(String company, double currentValue){
        this.company = company;
        this.currentValue = currentValue;
        this.min = currentValue;
        this.max = currentValue;
    }

    public String getCompany() {
        return company;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public void updatePrice(double value){
        max = Math.max(value, getMax());
        min = Math.min(value, getMin());
        currentValue = value;
    }

    public void printInformation(){
        System.out.println("current value = " + getCurrentValue());
        System.out.println("max = " + getMax());
        System.out.println("min = " + getMin());
    }
}
