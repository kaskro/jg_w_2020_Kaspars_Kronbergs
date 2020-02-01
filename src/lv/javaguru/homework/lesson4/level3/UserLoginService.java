package lv.javaguru.homework.lesson4.level3;

public class UserLoginService {

    public boolean login(String inputPassword, User user){
        if(!user.blocked){
            if(verify(inputPassword, user.password)){
                return true;
            } else {
                user.loginAttemptsLeft--;
                user.block();
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean verify(String inputPassword, String userPassword){
        return inputPassword.equals(userPassword);
    }
}
