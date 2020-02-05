package lv.javaguru.homework.lesson4.level4;

public class CreditCard {
    private String cardNumber;
    private String pinCode;
    private double balance;
    private double creditLimit;
    private double usedCredit;

    CreditCard(String cardNumber, String pinCode, double balance, double creditLimit, double usedCredit){
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.usedCredit = usedCredit;
    }

    public boolean deposit(double amount, String pinCode){
        boolean canDeposit = false;
        if(this.pinCode.equals(pinCode)){
            balance += usedCredit > 0 ? amount - usedCredit : amount;
            canDeposit = true;
        }
        return canDeposit;
    }

    public boolean withdraw(double amount, String pinCode){
        boolean canWithdraw = false;
        double availableAmount = balance + (creditLimit - usedCredit);
        boolean isEnoughMoney = availableAmount - amount > 0.001;
        if(this.pinCode.equals(pinCode) && isEnoughMoney){
            if(amount > balance){
                balance = 0;
                usedCredit = amount - balance;
            } else {
                balance -= amount;
            }
            canWithdraw = true;
        }
        return canWithdraw;
    }

}
