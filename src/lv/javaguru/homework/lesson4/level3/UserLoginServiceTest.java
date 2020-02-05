package lv.javaguru.homework.lesson4.level3;

public class UserLoginServiceTest {
    public void mainTest(){
        User user = new User();
        user.setUser("test");
        user.setPassword("abc");
        String wrongPassword = "ab";
        UserLoginService loginService = new UserLoginService();
        check(loginService.login(wrongPassword,user), false, "testForWrongPassword");
        check(loginService.login(user.getPassword(),user), true, "testForRightPassword");

        loginService.login(wrongPassword,user);
        loginService.login(wrongPassword,user);
        // Failed 3 login attempts
        check(user.isBlocked(), true, "testForBlockedUserIfAttemptsAre0");
        user.resetLoginAttempts();
        check(user.isBlocked(), false, "testForBlockedUserIfAttemptsAre3");
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
