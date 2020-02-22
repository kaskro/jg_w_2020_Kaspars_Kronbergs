package lv.javaguru.homework.lesson4.level3;

//Ok
public class User {
    private String user;
    private String password;
    private int loginAttemptsLeft = 3;
    private boolean blocked;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginAttemptsLeft() {
        return loginAttemptsLeft;
    }

    public void setLoginAttemptsLeft(int loginAttemptsLeft) {
        this.loginAttemptsLeft = loginAttemptsLeft;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void resetLoginAttempts() {
        loginAttemptsLeft = 3;
        blocked = false;
    }

    public void block() {
        loginAttemptsLeft -= loginAttemptsLeft > 0 ? 1 : 0;
        blocked = loginAttemptsLeft <= 0;
    }
}
