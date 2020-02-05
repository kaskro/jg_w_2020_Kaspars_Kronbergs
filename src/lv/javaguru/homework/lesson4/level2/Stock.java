package lv.javaguru.homework.lesson4.level2;

public class Stock {
    private String company;
    private double currentValue;
    private double max;
    private double min;

    Stock(String company, double currentValue){
        this.company = company;
        this.currentValue = currentValue;
        this.min = currentValue;
        this.max = currentValue;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
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
