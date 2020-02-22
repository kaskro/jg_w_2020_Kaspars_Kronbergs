package lv.javaguru.homework.lesson4.level3;

//Ok
public class UserLoginServiceTest {
    public void mainTest() { //testa nosaukums neizsaka neko par testa scenariju
        User user = new User();
        user.setUser("test");
        user.setPassword("abc");
        String wrongPassword = "ab";
        UserLoginService loginService = new UserLoginService();
        check("testForWrongPassword", loginService.login(wrongPassword, user), false);
        check("testForRightPassword", loginService.login(user.getPassword(), user), true);

        loginService.login(wrongPassword, user);
        loginService.login(wrongPassword, user);
        // Failed 3 login attempts
        check("testForBlockedUserIfAttemptsAre0", user.isBlocked(), true);
        user.resetLoginAttempts();
        check("testForBlockedUserIfAttemptsAre3", user.isBlocked(), false);
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
        UserLoginServiceTest testRunner = new UserLoginServiceTest();
        testRunner.mainTest();
    }
}
