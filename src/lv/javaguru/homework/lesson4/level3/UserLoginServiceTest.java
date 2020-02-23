package lv.javaguru.homework.lesson4.level3;

//Ok
public class UserLoginServiceTest {

    public void shouldBeFalseWhilePasswordIsIncorrect() {
        String wrongPassword = "ab";

        User user = new User();
        user.setUser("test");
        user.setPassword("abc");

        UserLoginService loginService = new UserLoginService();
        check("testForWrongPassword", loginService.login(wrongPassword, user), false);
    }

    public void shouldBeTrueWhilePasswordIsCorrect() {
        String password = "abc";

        User user = new User();
        user.setUser("test");
        user.setPassword(password);

        UserLoginService loginService = new UserLoginService();
        check("testForRightPassword", loginService.login(password, user), true);
    }

    public void shouldBeTrueWhenUserFails3TimesToLogIn() {
        String password = "abc";
        String wrongPassword = "ab";

        User user = new User();
        user.setUser("test");
        user.setPassword(password);

        UserLoginService loginService = new UserLoginService();

        loginService.login(wrongPassword, user);
        loginService.login(wrongPassword, user);
        loginService.login(wrongPassword, user);

        check("testForBlockedUserIfAttemptsAre0", user.isBlocked(), true);
    }

    public void check(String testName, boolean actualResult, boolean expectedResult) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public void check(String testName, int actualResult, int expectedResult) {
        if (actualResult == expectedResult) {
            System.out.println(testName + " has passed!");
        } else {
            System.out.println(testName + " has failed!");
            System.out.println("Expected " + expectedResult + " but was " + actualResult);
        }
    }

    public static void main(String[] args) {
        UserLoginServiceTest testRunner = new UserLoginServiceTest();
        testRunner.shouldBeFalseWhilePasswordIsIncorrect();
        testRunner.shouldBeTrueWhenUserFails3TimesToLogIn();
        testRunner.shouldBeTrueWhilePasswordIsCorrect();
    }
}
