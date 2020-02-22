package lv.javaguru.homework.lesson4.level4;

public class CreditCardTest {

    //testus labāk sadalīt atsevišķās metodēs
    //un katram testam ir jāsākās ar "tīru" objektu
    //tas ir stāvokļis tiek iesetots no jauna
    public void mainTest() {
        String cardNumber = "1234 5678 1234 1234";
        String pinCode = "1234";
        double balance = 100;
        double creditLimit = 200;
        double usedCredit = 0;

        CreditCard creditCard = new CreditCard(cardNumber, pinCode, balance, creditLimit, usedCredit);

        check("testForWrongPinWhileDepositing", creditCard.deposit(100, "1111"), false);
        check("testForRightPinWhileDepositing", creditCard.deposit(100, pinCode), true);
        check("testForWrongPinWhileWithdraw", creditCard.withdraw(100, "1111"), false);
        check("testForRightPinAndExceedingLimitWithdraw", creditCard.withdraw(500, pinCode), false);
        check("testForRightPinAndAllowedLimitWithdraw", creditCard.withdraw(200, pinCode), true);
    }

    public void check(String testName, boolean actualResult, boolean expectedResult) {
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
