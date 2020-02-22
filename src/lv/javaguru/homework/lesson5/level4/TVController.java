package lv.javaguru.homework.lesson5.level4;

//ok
public class TVController {
    private TV tv;

    public TV getTv() {
        return tv;
    }

    public void setTv(TV tv) {
        this.tv = tv;
    }

    public void nextChannel() {
        tv.nextChannel();
    }

    public void previousChannel() {
        tv.previousChannel();
    }

    public void increaseVolume() {
        tv.increaseVolume();
    }

    public void decreaseVolume() {
        tv.decreaseVolume();
    }

    public void turnOn() {
        tv.turnOn();
    }

    //nav izmantota metode
    public void turnOff() {
        tv.turnOff();
    }
}
