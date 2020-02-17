package lv.javaguru.homework.lesson5.level5;

public class LightBulb {
    private final int MAX_TURN_ON_COUNT = 5;
    private boolean turnedOn;
    private int currentTurnOnCount;


    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    public int getMAX_TURN_ON_COUNT() {
        return MAX_TURN_ON_COUNT;
    }

    public int getCurrentTurnOnCount() {
        return currentTurnOnCount;
    }

    public void setCurrentTurnOnCount(int currentTurnOnCount) {
        this.currentTurnOnCount = currentTurnOnCount;
    }

    public void turnOn() {
        if (currentTurnOnCount < MAX_TURN_ON_COUNT && turnedOn == false) {
            currentTurnOnCount++;
            turnedOn = true;
        } else {
            turnedOn = false;
        }
    }

    public void turnOff() {
        turnedOn = false;
    }

}
