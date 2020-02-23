package lv.javaguru.homework.lesson4.level4;

public class CreditCardTest {

    //testus labāk sadalīt atsevišķās metodēs
    //un katram testam ir jāsākās ar "tīru" objektu
    //tas ir stāvokļis tiek iesetots no jauna

    public void shouldBeFalseWhenUsingWrongPinWhileDepositing() {
        String wrongPinCode = "1111";
        double testAmount = 100;

        String cardNumber = "1234 5678 1234 1234";
        String pinCode = "1234";
        double balance = 100;
        double creditLimit = 200;
        double usedCredit = 0;

        CreditCard creditCard = new CreditCard(cardNumber, pinCode, balance, creditLimit, usedCredit);

        check("testForWrongPinWhileDepositing", creditCard.deposit(testAmount, wrongPinCode), false);
    }

    public void shouldBeTrueWhenUsingRightPinWhileDepositing() {
        double testAmount = 100;

        String cardNumber = "1234 5678 1234 1234";
        String pinCode = "1234";
        double balance = 100;
        double creditLimit = 200;
        double usedCredit = 0;

        CreditCard creditCard = new CreditCard(cardNumber, pinCode, balance, creditLimit, usedCredit);

        check("testForRightPinWhileDepositing", creditCard.deposit(testAmount, pinCode), true);
    }

    public void shouldNotAllowWithdrawWhenPinIsIncorrect() {
        String wrongPinCode = "1111";
        double testAmount = 100;

        String cardNumber = "1234 5678 1234 1234";
        String pinCode = "1234";
        double balance = 100;
        double creditLimit = 200;
        double usedCredit = 0;

        CreditCard creditCard = new CreditCard(cardNumber, pinCode, balance, creditLimit, usedCredit);
        creditCard.withdraw(testAmount, wrongPinCode);
        check("testForWrongPinWhileWithdraw", creditCard.getBalance(), balance);
    }

    public void shouldNotAllowWithdrawWhenPinIsCorrectAndExceedsWithdrawLimit() {
        double testAmount = 500;

        String cardNumber = "1234 5678 1234 1234";
        String pinCode = "1234";
        double balance = 100;
        double creditLimit = 200;
        double usedCredit = 0;

        CreditCard creditCard = new CreditCard(cardNumber, pinCode, balance, creditLimit, usedCredit);
        creditCard.withdraw(testAmount, pinCode);

        check("testForRightPinAndExceedingLimitWithdraw", creditCard.getBalance(), balance);
    }

    public void shouldAllowWithdrawWhenPinIsCorrectAndAllowedLimitProvided() {
        double testAmount = 200;

        String cardNumber = "1234 5678 1234 1234";
        String pinCode = "1234";
        double balance = 100;
        double creditLimit = 200;
        double usedCredit = 0;

        CreditCard creditCard = new CreditCard(cardNumber, pinCode, balance, creditLimit, usedCredit);
        creditCard.withdraw(testAmount, pinCode);

        check("testForBalanceAfterWithdraw", creditCard.getBalance(), 0);
        check("testForCreditLimitAfterWithdraw", creditCard.getUsedCredit(), 100);
    }

    public void check(String testName, boolean actualResult, boolean expectedResult) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public void check(String testName, double actualResult, double expectedResult) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public static void main(String[] args) {
        CreditCardTest testRunner = new CreditCardTest();
        testRunner.shouldBeFalseWhenUsingWrongPinWhileDepositing();
        testRunner.shouldBeTrueWhenUsingRightPinWhileDepositing();
        testRunner.shouldNotAllowWithdrawWhenPinIsIncorrect();
        testRunner.shouldNotAllowWithdrawWhenPinIsCorrectAndExceedsWithdrawLimit();
        testRunner.shouldAllowWithdrawWhenPinIsCorrectAndAllowedLimitProvided();
    }
}
