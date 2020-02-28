package lv.javaguru.homework.lesson5.level5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitcherTest {

    private Switcher switcher;
    private LightBulb lightBulb;

    @BeforeEach
    void setUp() {

        switcher = new Switcher();

        lightBulb = new LightBulb();
        lightBulb.setTurnedOn(false);
        lightBulb.setCurrentTurnOnCount(0);
    }

    @Test
    void shouldGetLightBulb() {

        assertNull(switcher.getLightBulb());
    }

    @Test
    void setLightBulb() {

        switcher.setLightBulb(lightBulb);

        assertEquals(lightBulb, switcher.getLightBulb());
    }

    @Test
    void shouldBeFalseWhenIsTurnedOnIsNotSet() {

        assertFalse(switcher.isTurnedOn());
    }

    @Test
    void shouldSetTurnedOn() {

        switcher.setTurnedOn(true);

        assertTrue(switcher.isTurnedOn());
    }

    @Test
    void shouldBeTrueWhenSwitchOnOffIsCalledOneTime() {

        switcher.setLightBulb(lightBulb);
        switcher.switchOnOff();

        assertTrue(switcher.isTurnedOn());
    }

    @Test
    void shouldBeFalseWhenSwitchOnOffIsCalledTwoTime() {

        switcher.setLightBulb(lightBulb);
        switcher.switchOnOff();
        switcher.switchOnOff();

        assertFalse(switcher.isTurnedOn());
    }


    @Test
    void shouldBeFalseWhenSwitchOnOffIsCalledMoreThanFiveTimes() {

        switcher.setLightBulb(lightBulb);
        for(int i = 0; i < 7; i++){
            switcher.switchOnOff();
        }

        assertFalse(lightBulb.isTurnedOn());
    }


}