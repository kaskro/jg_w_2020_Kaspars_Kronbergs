package lv.javaguru.homework.lesson4.level3;

public class UserLoginService {

    //šai
    public boolean login(String inputPassword, User user) {
        if (!user.isBlocked()) {
            if (verify(inputPassword, user.getPassword())) {
                return true;
            } else {
                user.block();
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean verify(String inputPassword, String userPassword) {
        return inputPassword.equals(userPassword);
    }
}
