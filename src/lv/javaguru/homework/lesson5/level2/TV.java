package lv.javaguru.homework.lesson5.level2;

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
            currentChannel = currentChannel + 1 < 100 ? currentChannel + 1 : 0; //nosacījumu labak iznest atsevišķā metodē vai mainīgajā
        }
        return currentChannel;
    }

    //šī metode nav notestēta
    public int previousChannel() {
        if (turnedOn) {
            currentChannel = currentChannel - 1 >= 0 ? currentChannel - 1 : 99; //nosacījumu labak iznest atsevišķā metodē vai mainīgajā
        }
        return currentChannel;
    }

    //šī metode nav notestēta
    public int increaseVolume() {
        if (turnedOn) {
            currentVolumeLevel += currentVolumeLevel + 1 <= 100 ? 1 : 0; //nosacījumu labak iznest atsevišķā metodē vai arī mainīgajā
        }
        return currentVolumeLevel;
    }

    //šī metode nav notestēta
    public int decreaseVolume() {
        if (turnedOn) {
            currentVolumeLevel -= currentVolumeLevel - 1 >= 0 ? 1 : 0; //nosacījumu labak iznest atsevišķā metodē vai arī mainīgajā
        }
        return currentVolumeLevel;
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
        if (currentChannel != tv.currentChannel) return false;
        if (currentVolumeLevel != tv.currentVolumeLevel) return false;
        if (turnedOn != tv.turnedOn) return false;
        return manufacturer.equals(tv.manufacturer);
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
