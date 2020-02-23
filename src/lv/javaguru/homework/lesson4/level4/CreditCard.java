package lv.javaguru.homework.lesson4.level4;

//ok
public class CreditCard {
    private String cardNumber;
    private String pinCode;
    private double balance;
    private double creditLimit;
    private double usedCredit;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getUsedCredit() {
        return usedCredit;
    }

    CreditCard(String cardNumber, String pinCode, double balance, double creditLimit, double usedCredit) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.usedCredit = usedCredit;
    }

    public boolean deposit(double amount, String pinCode) {
        boolean canDeposit = false;
        if (this.pinCode.equals(pinCode)) {
            balance += usedCredit > 0 ? amount - usedCredit : amount;
            canDeposit = true;
        }
        return canDeposit;
    }

    public void withdraw(double amount, String pinCode) {
        if (canWithdrawMoney(pinCode, isEnoughMoney(amount, getAvailableAmount()))) {
            withdrawMoney(amount);
        }
    }

    private void withdrawMoney(double amount) {
        if (amount > balance) {
            usedCredit = amount - balance;
            balance = 0;
        } else {
            balance -= amount;
        }
    }

    private boolean canWithdrawMoney(String pinCode, boolean isEnoughMoney) {
        return this.pinCode.equals(pinCode) && isEnoughMoney;
    }

    private boolean isEnoughMoney(double amount, double availableAmount) {
        return availableAmount - amount > 0.001;
    }

    private double getAvailableAmount() {
        return balance + (creditLimit - usedCredit);
    }

}
