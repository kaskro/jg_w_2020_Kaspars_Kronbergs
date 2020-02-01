package lv.javaguru.homework.lesson4.level3;

public class UserLoginServiceTest {
    public void mainTest(){
        User user = new User();
        user.user = "test";
        user.password = "abc";
        String wrongPassword = "ab";
        UserLoginService loginService = new UserLoginService();
        check(loginService.login(wrongPassword,user), false, "testForWrongPassword");
        check(loginService.login(user.password,user), true, "testForRightPassword");

        loginService.login(wrongPassword,user);
        loginService.login(wrongPassword,user);
        // Failed 3 login attempts
        check(user.blocked, true, "testForBlockedUserIfAttemptsAre0");
        user.resetLoginAttempts();
        check(user.blocked, false, "testForBlockedUserIfAttemptsAre3");
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
        UserLoginServiceTest testRunner = new UserLoginServiceTest();
        testRunner.mainTest();
    }
}
