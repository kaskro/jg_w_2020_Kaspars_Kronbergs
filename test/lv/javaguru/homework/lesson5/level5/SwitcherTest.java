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

        createLightBulb();
    }

    private void createLightBulb() {
        lightBulb = new LightBulb();
        lightBulb.setTurnedOn(false);
        lightBulb.setCurrentTurnOnCount(0);
    }

    @Test
    void shouldSetAndGetLightBulb() {

        switcher.setLightBulb(lightBulb);

        assertEquals(lightBulb, switcher.getLightBulb());
    }

    @Test
    void shouldSetAndGetTurnedOn() {

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
        //centies izvairīties testos rakstīt pārak daudz komplicētu loģiku
        //jo tad var sanakt, ka vajag arī to testēt :)
        //šeit drošī var uzrakstīt 6 rindiņas ar metodes izsaukumu
        switcher.switchOnOff();
        switcher.switchOnOff();
        switcher.switchOnOff();
        switcher.switchOnOff();
        switcher.switchOnOff();
        switcher.switchOnOff();
        switcher.switchOnOff();

        assertFalse(lightBulb.isTurnedOn());
    }


}