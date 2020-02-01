package lv.javaguru.homework.lesson4.level3;

public class User {
    String user;
    String password;
    int loginAttemptsLeft = 3;
    boolean blocked;

    public void resetLoginAttempts(){
        loginAttemptsLeft = 3;
        blocked = false;
    }

    public void block(){
        blocked = loginAttemptsLeft <= 0;
    }
}
