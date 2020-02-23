package lv.javaguru.homework.lesson5.level2;

import java.util.Objects;

public class TV {
    private int currentChannel;
    private int currentVolumeLevel;
    private String manufacturer;
    private boolean turnedOn;

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }

    public int getCurrentVolumeLevel() {
        return currentVolumeLevel;
    }

    public void setCurrentVolumeLevel(int currentVolumeLevel) {
        this.currentVolumeLevel = currentVolumeLevel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    //šī metode nav notestēta
    public int nextChannel() {
        if (turnedOn) {
            switchToNextChannel();
        }
        return currentChannel;
    }

    private void switchToNextChannel() {
        currentChannel = canDoNextChannel() ? currentChannel + 1 : 0;
    }

    private boolean canDoNextChannel() {
        return currentChannel + 1 < 100;
    }

    //šī metode nav notestēta
    public int previousChannel() {
        if (turnedOn) {
            switchToPreviousChannel();
        }
        return currentChannel;
    }

    private void switchToPreviousChannel() {
        currentChannel = canDoPreviousChannel() ? currentChannel - 1 : 99;
    }

    private boolean canDoPreviousChannel() {
        return currentChannel - 1 >= 0;
    }

    //šī metode nav notestēta
    public int increaseVolume() {
        if (turnedOn) {
            increaseVolumeByOne();
        }
        return currentVolumeLevel;
    }

    private void increaseVolumeByOne() {
        currentVolumeLevel += canIncreaseVolume() ? 1 : 0;
    }

    private boolean canIncreaseVolume() {
        return currentVolumeLevel + 1 <= 100;
    }

    //šī metode nav notestēta
    public int decreaseVolume() {
        if (turnedOn) {
            decreaseVolumeByOne();
        }
        return currentVolumeLevel;
    }

    private void decreaseVolumeByOne() {
        currentVolumeLevel -= canDecreaseVolume() ? 1 : 0;
    }

    private boolean canDecreaseVolume() {
        return currentVolumeLevel - 1 >= 0;
    }

    //šī metode nav notestēta
    public void turnOn() {
        turnedOn = true;
    }

    //šī metode nav notestēta
    public void turnOff() {
        turnedOn = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TV tv = (TV) o;

        //šeit izmanto "&&" un saliec visu vienā izteiksmē
         return Objects.equals(currentChannel, tv.currentChannel) &&
                Objects.equals(currentVolumeLevel, tv.currentVolumeLevel) &&
                Objects.equals(turnedOn, tv.turnedOn) &&
                Objects.equals(manufacturer, tv.manufacturer);
    }

    @Override
    public String toString() {
        return "TV{" +
                "currentChannel=" + currentChannel +
                ", currentVolumeLevel=" + currentVolumeLevel +
                ", manufacturer='" + manufacturer + '\'' +
                ", turnedOn=" + turnedOn +
                '}';
    }
}
