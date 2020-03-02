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

    //skatīt iepriekš komentāru pie gettera testa
    //principā get un set metodēm pietiktu ar vienu testu, kur ieseto vertību un tad pārbauda, kas tur ir iekšā
    @Test
    void shouldGetCurrentChannel() {

        assertEquals(0, tv.getCurrentChannel());
    }

    @Test
    void shouldSetCurrentChannel() {

        int testValue = 10;

        tv.setCurrentChannel(testValue);

        assertEquals(testValue, tv.getCurrentChannel());
    }

    @Test
    void shouldGetCurrentVolumeLevel() {

        assertEquals(0, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldSetCurrentVolumeLevel() {

        int testValue = 40;

        tv.setCurrentVolumeLevel(testValue);

        assertEquals(testValue, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldGetManufacturer() {

        assertNull(tv.getManufacturer());
    }

    @Test
    void shouldSetManufacturer() {

        String testValue = "Samsung";

        tv.setManufacturer(testValue);

        assertEquals(testValue, tv.getManufacturer());
    }

    @Test
    void shouldIsTurnedOnReturnFalse() {

        assertFalse(tv.isTurnedOn());
    }

    @Test
    void shouldSetTurnedOnToTrue() {

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
    void shouldReturnTrueWhenTwoObjectsAreEqual() {

        boolean turnedOn = true;
        int currentChannel = 10;
        int currentVolumeLevel = 50;
        String manufacturer = "Samsung";

        //šādu objektu veidošanu droši var iznest atsevišķā metodē
        //un nodot stāvokļus izmantojot parametrus
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

    //šim piemērotāks nosaukums būtu: shouldNotBeEqualsTvs
    @Test
    void shouldReturnFalseWhenTwoObjectsAreNotEqual() {
        //šādu objektu veidošanu droši var iznest atsevišķā metodē
        //un nodot stāvokļus izmantojot parametrus
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

        tv.setTurnedOn(turnedOn);
        tv.setCurrentChannel(currentChannel);
        tv.setCurrentVolumeLevel(currentVolumeLevel);
        tv.setManufacturer(manufacturer);

        assertEquals(correctFormat, tv.toString());
    }

}