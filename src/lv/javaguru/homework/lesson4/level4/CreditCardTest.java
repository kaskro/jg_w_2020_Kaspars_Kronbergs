package lv.javaguru.homework.lesson4.level4;

public class CreditCardTest {
    public void mainTest(){
        String cardNumber = "1234 5678 1234 1234";
        String pinCode = "1234";
        double balance = 100;
        double creditLimit = 200;
        double usedCredit = 0;

        CreditCard creditCard = new CreditCard(cardNumber, pinCode , balance, creditLimit, usedCredit);

        check(creditCard.deposit(100, "1111"), false, "testForWrongPinWhileTopup");
        check(creditCard.deposit(100, pinCode), true, "testForRightPinWhileTopup");
        check(creditCard.withdraw(100, "1111"), false, "testForWrongPinWhileWithdraw");
        check(creditCard.withdraw(500, pinCode), false, "testForRightPinAndExceedingLimitWithdraw");
        check(creditCard.withdraw(200, pinCode), true, "testForRightPinAndAllowedLimitWithdraw");
    }

    public void check(boolean actualResult, boolean expectedResult, String testName) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }



    public static void main(String[] args) {
        CreditCardTest testRunner = new CreditCardTest();
        testRunner.mainTest();
    }
}
