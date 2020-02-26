package lv.javaguru.homework.lesson5.level5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightBulbTest {

    @Test
    void shouldBeFalseWhenIsTurnedOnIsNotSet() {

        LightBulb lightBulb = new LightBulb();

        assertFalse(lightBulb.isTurnedOn());
    }

    @Test
    void shouldSetTurnedOnToTrue() {

        LightBulb lightBulb = new LightBulb();
        lightBulb.setTurnedOn(true);

        assertTrue(lightBulb.isTurnedOn());
    }

    @Test
    void shouldGetMAX_TURN_ON_COUNT_Constant() {

        LightBulb lightBulb = new LightBulb();

        assertEquals(5, lightBulb.getMAX_TURN_ON_COUNT());
    }

    @Test
    void shouldGetCurrentTurnOnCount() {

        LightBulb lightBulb = new LightBulb();

        assertEquals(0, lightBulb.getCurrentTurnOnCount());
    }

    @Test
    void shouldSetCurrentTurnOnCount() {

        int currentTurnOnCount = 3;

        LightBulb lightBulb = new LightBulb();
        lightBulb.setCurrentTurnOnCount(currentTurnOnCount);

        assertEquals(currentTurnOnCount, lightBulb.getCurrentTurnOnCount());
    }

    @Test
    void shouldTurnOffTheLightBulb() {

        LightBulb lightBulb = new LightBulb();
        lightBulb.setTurnedOn(true);
        lightBulb.turnOff();

        assertFalse(lightBulb.isTurnedOn());
    }

    @Test
    void shouldTurnOnTheLightBulb() {

        LightBulb lightBulb = new LightBulb();
        lightBulb.turnOn();

        assertTrue(lightBulb.isTurnedOn());
    }
}