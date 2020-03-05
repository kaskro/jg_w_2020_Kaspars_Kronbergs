package lv.javaguru.homework.lesson5.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TVTest {

    private TV tv;

    @BeforeEach
    void setUp() {
        tv = new TV();
    }

    @Test
    void shouldSetAndGetCurrentChannel() {

        int testValue = 10;

        tv.setCurrentChannel(testValue);

        assertEquals(testValue, tv.getCurrentChannel());
    }

    @Test
    void shouldSetAndGetCurrentVolumeLevel() {

        int testValue = 40;

        tv.setCurrentVolumeLevel(testValue);

        assertEquals(testValue, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldSetAndGetManufacturer() {

        String testValue = "Samsung";

        tv.setManufacturer(testValue);

        assertEquals(testValue, tv.getManufacturer());
    }

    @Test
    void shouldSetAndGetIsTurnedOn() {

        tv.setTurnedOn(true);

        assertTrue(tv.isTurnedOn());
    }

    @Test
    void shouldNotChangeChannelToNextWhileTVisOff() {

        tv.nextChannel();

        assertEquals(0, tv.getCurrentChannel());
    }

    @Test
    void shouldChangeChannelToNextWhileTVIsOn() {

        tv.turnOn();
        tv.nextChannel();

        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    void shouldChangeChannelTo0WhenGetsAbove99() {

        tv.turnOn();
        tv.setCurrentChannel(99);
        tv.nextChannel();

        assertEquals(0, tv.getCurrentChannel());
    }

    @Test
    void shouldNotChangeChannelToPreviousWhileTVisOff() {

        tv.previousChannel();

        assertEquals(0, tv.getCurrentChannel());
    }

    @Test
    void shouldChangeChannelToPreviousWhileTVIsOn() {

        tv.turnOn();
        tv.nextChannel();
        tv.nextChannel();
        tv.previousChannel();

        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    void shouldChangeChannelTo99WhenGetsBelow0() {

        tv.turnOn();
        tv.setCurrentChannel(0);
        tv.previousChannel();

        assertEquals(99, tv.getCurrentChannel());
    }

    @Test
    void shouldNotIncreaseVolumeWhileTVIsOff() {

        tv.increaseVolume();

        assertEquals(0, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldIncreaseVolumeBy1WhileTVIsOn() {

        tv.turnOn();
        tv.increaseVolume();

        assertEquals(1, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldStayAt100WhenVolumeIsIncreasedAbove100() {

        tv.turnOn();
        tv.setCurrentVolumeLevel(100);
        tv.increaseVolume();
        tv.increaseVolume();

        assertEquals(100, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldNotDecreaseVolumeWhileTVIsOff() {

        tv.decreaseVolume();

        assertEquals(0, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldDecreaseVolumeBy1WhileTVIsOn() {

        tv.turnOn();
        tv.increaseVolume();
        tv.increaseVolume();
        tv.decreaseVolume();

        assertEquals(1, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldStayAt0WhenVolumeIsDecreasedBelow0() {

        tv.turnOn();
        tv.setCurrentVolumeLevel(0);
        tv.decreaseVolume();
        tv.decreaseVolume();

        assertEquals(0, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldTurnOnTheTV() {

        tv.turnOn();

        assertTrue(tv.isTurnedOn());
    }

    @Test
    void shouldTurnOffTheTV() {

        tv.turnOn();
        tv.turnOff();

        assertFalse(tv.isTurnedOn());
    }

    //šim piemērotāks nosaukums būtu: shouldBeEqualsTvs
    @Test
    void shouldBeEqualsTVs() {

        boolean turnedOn = true;
        int currentChannel = 10;
        int currentVolumeLevel = 50;
        String manufacturer = "Samsung";

        //šādu objektu veidošanu droši var iznest atsevišķā metodē
        //un nodot stāvokļus izmantojot parametrus
        TV firstTV = createTv(turnedOn, currentChannel, currentVolumeLevel, manufacturer);

        TV secondTV = createTv(turnedOn, currentChannel, currentVolumeLevel, manufacturer);

        assertTrue(firstTV.equals(secondTV));
    }

    private TV createTv(boolean turnedOn, int currentChannel, int currentVolumeLevel, String manufacturer) {
        tv = new TV();

        tv.setTurnedOn(turnedOn);
        tv.setCurrentChannel(currentChannel);
        tv.setCurrentVolumeLevel(currentVolumeLevel);
        tv.setManufacturer(manufacturer);
        return tv;
    }

    //šim piemērotāks nosaukums būtu: shouldNotBeEqualsTvs
    @Test
    void shouldNotBeEqualsTVs() {
        //šādu objektu veidošanu droši var iznest atsevišķā metodē
        //un nodot stāvokļus izmantojot parametrus
        TV firstTV = createTv(true, 10, 30, "Demo 1");

        TV secondTV = createTv(false, 10, 30, "Demo 2");

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

        tv.setTurnedOn(turnedOn);
        tv.setCurrentChannel(currentChannel);
        tv.setCurrentVolumeLevel(currentVolumeLevel);
        tv.setManufacturer(manufacturer);

        assertEquals(correctFormat, tv.toString());
    }

}