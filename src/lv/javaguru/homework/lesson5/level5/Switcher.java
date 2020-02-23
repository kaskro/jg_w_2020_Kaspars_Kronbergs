package lv.javaguru.homework.lesson5.level5;

public class Switcher {
    private LightBulb lightBulb;
    private boolean turnedOn;

    public LightBulb getLightBulb() {
        return lightBulb;
    }

    public void setLightBulb(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    public void switchOnOff() {
        toggleOnOff();
        if (turnedOn) lightBulb.turnOff();
        else lightBulb.turnOn();
    }

    private void toggleOnOff() {
        turnedOn = !turnedOn;
    }
}
