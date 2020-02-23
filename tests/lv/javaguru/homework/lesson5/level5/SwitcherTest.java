package lv.javaguru.homework.lesson5.level5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitcherTest {

    @Test
    void shouldGetLightBulb() {

        Switcher switcher = new Switcher();

        assertNull(switcher.getLightBulb());
    }

    @Test
    void setLightBulb() {

        LightBulb lightBulb = new LightBulb();
        lightBulb.setTurnedOn(false);
        lightBulb.setCurrentTurnOnCount(0);

        Switcher switcher = new Switcher();
        switcher.setLightBulb(lightBulb);

        assertEquals(lightBulb, switcher.getLightBulb());
    }

    @Test
    void shouldBeFalseWhenIsTurnedOnIsNotSet() {

        Switcher switcher = new Switcher();

        assertFalse(switcher.isTurnedOn());
    }

    @Test
    void shouldSetTurnedOn() {

        Switcher switcher = new Switcher();
        switcher.setTurnedOn(true);

        assertTrue(switcher.isTurnedOn());
    }

    @Test
    void shouldBeTrueWhenSwitchOnOffIsCalledOneTime() {

        LightBulb lightBulb = new LightBulb();
        lightBulb.setTurnedOn(false);
        lightBulb.setCurrentTurnOnCount(0);

        Switcher switcher = new Switcher();
        switcher.setLightBulb(lightBulb);

        switcher.switchOnOff();

        assertTrue(switcher.isTurnedOn());
    }

    @Test
    void shouldBeFalseWhenSwitchOnOffIsCalledTwoTime() {

        LightBulb lightBulb = new LightBulb();
        lightBulb.setTurnedOn(false);
        lightBulb.setCurrentTurnOnCount(0);

        Switcher switcher = new Switcher();
        switcher.setLightBulb(lightBulb);

        switcher.switchOnOff();
        switcher.switchOnOff();

        assertFalse(switcher.isTurnedOn());
    }


    @Test
    void shouldBeFalseWhenSwitchOnOffIsCalledMoreThanFiveTimes() {

        LightBulb lightBulb = new LightBulb();
        lightBulb.setTurnedOn(false);
        lightBulb.setCurrentTurnOnCount(0);

        Switcher switcher = new Switcher();
        switcher.setLightBulb(lightBulb);

        switcher.switchOnOff();
        switcher.switchOnOff();
        switcher.switchOnOff();
        switcher.switchOnOff();
        switcher.switchOnOff();
        switcher.switchOnOff();

        assertFalse(switcher.isTurnedOn());
    }


}