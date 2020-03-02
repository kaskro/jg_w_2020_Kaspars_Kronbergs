package lv.javaguru.homework.lesson5.level4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//OK
class TVControllerTest {

    private TVController tvController;
    private TV tv;

    @BeforeEach
    void setUp() {
        tvController = new TVController();

        tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(true);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);
    }

    @Test
    void shouldGetTV() {

        assertNull(tvController.getTv());
    }

    @Test
    void shouldSetTV() {

        tvController.setTv(tv);

        assertEquals(tv, tvController.getTv());
    }

    @Test
    void shouldChangeToNextChannelWhileTVIsOn() {

        tvController.setTv(tv);
        tvController.nextChannel();

        assertEquals(2, tv.getCurrentChannel());
    }

    @Test
    void shouldChangeToPreviousChannelWhileTVIsOn() {

        tvController.setTv(tv);
        tvController.previousChannel();

        assertEquals(0, tv.getCurrentChannel());
    }

    @Test
    void shouldNotChangeToNextChannelWhileTVIsOff() {

        tv.setTurnedOn(false);
        tvController.setTv(tv);
        tvController.nextChannel();

        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    void shouldNotChangeToPreviousChannelWhileTVIsOff() {

        tv.setTurnedOn(false);
        tvController.setTv(tv);
        tvController.previousChannel();

        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    void shouldIncreaseVolumeLevelWhileTVIsOn() {

        tvController.setTv(tv);
        tvController.increaseVolume();

        assertEquals(51, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldDecreaseVolumeLevelWhileTVIsOn() {

        tvController.setTv(tv);
        tvController.decreaseVolume();

        assertEquals(49, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldNotIncreaseVolumeLevelWhileTVIsOff() {

        tv.setTurnedOn(false);
        tvController.setTv(tv);
        tvController.increaseVolume();

        assertEquals(50, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldNotDecreaseVolumeLevelWhileTVIsOff() {

        tv.setTurnedOn(false);
        tvController.setTv(tv);
        tvController.decreaseVolume();

        assertEquals(50, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldTurnTVOn() {

        tv.setTurnedOn(false);
        tvController.setTv(tv);
        tvController.turnOn();

        assertTrue(tv.isTurnedOn());
    }

    @Test
    void shouldTurnTVOff() {

        tvController.setTv(tv);
        tvController.turnOff();

        assertFalse(tv.isTurnedOn());
    }


}