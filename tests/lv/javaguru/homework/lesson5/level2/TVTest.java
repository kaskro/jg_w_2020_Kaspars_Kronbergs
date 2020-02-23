package lv.javaguru.homework.lesson5.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TVTest {

    @Test
    void shouldGetCurrentChannel() {

        TV tv = new TV();

        assertEquals(0, tv.getCurrentChannel());
    }

    @Test
    void shouldSetCurrentChannel() {

        int testValue = 10;

        TV tv = new TV();
        tv.setCurrentChannel(testValue);

        assertEquals(testValue, tv.getCurrentChannel());
    }

    @Test
    void shouldGetCurrentVolumeLevel() {

        TV tv = new TV();

        assertEquals(0, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldSetCurrentVolumeLevel() {

        int testValue = 40;

        TV tv = new TV();
        tv.setCurrentVolumeLevel(testValue);

        assertEquals(testValue, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldGetManufacturer() {

        TV tv = new TV();

        assertNull(tv.getManufacturer());
    }

    @Test
    void shouldSetManufacturer() {

        String testValue = "Samsung";

        TV tv = new TV();
        tv.setManufacturer(testValue);

        assertEquals(testValue, tv.getManufacturer());
    }

    @Test
    void shouldIsTurnedOnReturnFalse() {

        TV tv = new TV();

        assertFalse(tv.isTurnedOn());
    }

    @Test
    void shouldSetTurnedOnToTrue() {

        TV tv = new TV();
        tv.setTurnedOn(true);

        assertTrue(tv.isTurnedOn());
    }

    @Test
    void shouldNotChangeChannelToNextWhileTVisOff() {

        TV tv = new TV();
        tv.nextChannel();

        assertEquals(0, tv.getCurrentChannel());
    }

    @Test
    void shouldChangeChannelToNextWhileTVIsOn() {

        TV tv = new TV();
        tv.turnOn();
        tv.nextChannel();

        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    void shouldChangeChannelTo0WhenGetsAbove99() {

        TV tv = new TV();
        tv.turnOn();
        tv.setCurrentChannel(99);
        tv.nextChannel();

        assertEquals(0, tv.getCurrentChannel());
    }

    @Test
    void shouldNotChangeChannelToPreviousWhileTVisOff() {

        TV tv = new TV();
        tv.previousChannel();

        assertEquals(0, tv.getCurrentChannel());
    }

    @Test
    void shouldChangeChannelToPreviousWhileTVIsOn() {

        TV tv = new TV();
        tv.turnOn();
        tv.nextChannel();
        tv.nextChannel();
        tv.previousChannel();

        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    void shouldChangeChannelTo99WhenGetsBelow0() {

        TV tv = new TV();
        tv.turnOn();
        tv.setCurrentChannel(0);
        tv.previousChannel();

        assertEquals(99, tv.getCurrentChannel());
    }

    @Test
    void shouldNotIncreaseVolumeWhileTVIsOff() {

        TV tv = new TV();
        tv.increaseVolume();

        assertEquals(0, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldIncreaseVolumeBy1WhileTVIsOn() {

        TV tv = new TV();
        tv.turnOn();
        tv.increaseVolume();

        assertEquals(1, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldStayAt100WhenVolumeIsIncreasedAbove100() {

        TV tv = new TV();
        tv.turnOn();
        tv.setCurrentVolumeLevel(100);
        tv.increaseVolume();
        tv.increaseVolume();

        assertEquals(100, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldNotDecreaseVolumeWhileTVIsOff() {

        TV tv = new TV();
        tv.decreaseVolume();

        assertEquals(0, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldDecreaseVolumeBy1WhileTVIsOn() {

        TV tv = new TV();
        tv.turnOn();
        tv.increaseVolume();
        tv.increaseVolume();
        tv.decreaseVolume();

        assertEquals(1, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldStayAt0WhenVolumeIsDecreasedBelow0() {

        TV tv = new TV();
        tv.turnOn();
        tv.setCurrentVolumeLevel(0);
        tv.decreaseVolume();
        tv.decreaseVolume();

        assertEquals(0, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldTurnOnTheTV() {

        TV tv = new TV();
        tv.turnOn();

        assertTrue(tv.isTurnedOn());
    }

    @Test
    void shouldTurnOffTheTV() {

        TV tv = new TV();
        tv.turnOn();
        tv.turnOff();

        assertFalse(tv.isTurnedOn());
    }

    @Test
    void shouldReturnTrueWhenTwoObjectsAreEqual() {

        boolean turnedOn = true;
        int currentChannel = 10;
        int currentVolumeLevel = 50;
        String manufacturer = "Samsung";

        TV firstTV = new TV();

        firstTV.setTurnedOn(turnedOn);
        firstTV.setCurrentChannel(currentChannel);
        firstTV.setCurrentVolumeLevel(currentVolumeLevel);
        firstTV.setManufacturer(manufacturer);

        TV secondTV = new TV();

        secondTV.setTurnedOn(turnedOn);
        secondTV.setCurrentChannel(currentChannel);
        secondTV.setCurrentVolumeLevel(currentVolumeLevel);
        secondTV.setManufacturer(manufacturer);

        assertTrue(firstTV.equals(secondTV));
    }

    @Test
    void shouldReturnFalseWhenTwoObjectsAreNotEqual() {

        TV firstTV = new TV();

        firstTV.setTurnedOn(true);
        firstTV.setCurrentChannel(10);
        firstTV.setCurrentVolumeLevel(30);
        firstTV.setManufacturer("Demo 1");

        TV secondTV = new TV();

        secondTV.setTurnedOn(false);
        secondTV.setCurrentChannel(10);
        secondTV.setCurrentVolumeLevel(30);
        secondTV.setManufacturer("Demo 2");

        assertFalse(firstTV.equals(secondTV));
    }

    @Test
    void shouldReturnTrueWhenStringHasCorrectFormat() {

        int currentChannel = 1;
        int currentVolumeLevel = 50;
        String manufacturer = "Samsung";
        boolean turnedOn = false;

        String correctFormat = "TV{" +
                "currentChannel=" + currentChannel +
                ", currentVolumeLevel=" + currentVolumeLevel +
                ", manufacturer='" + manufacturer + '\'' +
                ", turnedOn=" + turnedOn +
                '}';

        TV tv = new TV();

        tv.setTurnedOn(turnedOn);
        tv.setCurrentChannel(currentChannel);
        tv.setCurrentVolumeLevel(currentVolumeLevel);
        tv.setManufacturer(manufacturer);

        assertEquals(correctFormat, tv.toString());
    }

}