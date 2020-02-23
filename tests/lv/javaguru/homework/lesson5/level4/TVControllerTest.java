package lv.javaguru.homework.lesson5.level4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TVControllerTest {

    @Test
    void shouldGetTV() {

        TVController tvController = new TVController();

        assertNull(tvController.getTv());
    }

    @Test
    void shouldSetTV() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(true);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);

        assertEquals(tv, tvController.getTv());
    }

    @Test
    void shouldChangeToNextChannelWhileTVIsOn() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(true);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);
        tvController.nextChannel();

        assertEquals(2, tv.getCurrentChannel());
    }

    @Test
    void shouldChangeToPreviousChannelWhileTVIsOn() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(true);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);
        tvController.previousChannel();

        assertEquals(0, tv.getCurrentChannel());
    }

    @Test
    void shouldNotChangeToNextChannelWhileTVIsOff() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(false);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);
        tvController.nextChannel();

        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    void shouldNotChangeToPreviousChannelWhileTVIsOff() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(false);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);
        tvController.previousChannel();

        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    void shouldIncreaseVolumeLevelWhileTVIsOn() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(true);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);
        tvController.increaseVolume();

        assertEquals(51, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldDecreaseVolumeLevelWhileTVIsOn() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(true);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);
        tvController.decreaseVolume();

        assertEquals(49, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldNotIncreaseVolumeLevelWhileTVIsOff() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(false);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);
        tvController.increaseVolume();

        assertEquals(50, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldNotDecreaseVolumeLevelWhileTVIsOff() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(false);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);
        tvController.decreaseVolume();

        assertEquals(50, tv.getCurrentVolumeLevel());
    }

    @Test
    void shouldTurnTVOn() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(false);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);
        tvController.turnOn();

        assertTrue(tv.isTurnedOn());
    }

    @Test
    void shouldTurnTVOff() {

        TV tv = new TV();
        tv.setManufacturer("Sony");
        tv.setTurnedOn(true);
        tv.setCurrentChannel(1);
        tv.setCurrentVolumeLevel(50);

        TVController tvController = new TVController();
        tvController.setTv(tv);
        tvController.turnOff();

        assertFalse(tv.isTurnedOn());
    }


}