package lv.javaguru.homework.lesson5.level5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightBulbTest {

    private LightBulb lightBulb;

    @BeforeEach
    void setUp() {
        lightBulb = new LightBulb();
    }

    @Test
    void shouldBeFalseWhenIsTurnedOnIsNotSet() {

        assertFalse(lightBulb.isTurnedOn());
    }

    @Test
    void shouldSetTurnedOnToTrue() {

        lightBulb.setTurnedOn(true);

        assertTrue(lightBulb.isTurnedOn());
    }

    @Test
    void shouldGetMAX_TURN_ON_COUNT_Constant() {

        assertEquals(5, lightBulb.getMAX_TURN_ON_COUNT());
    }

    @Test
    void shouldGetCurrentTurnOnCount() {

        assertEquals(0, lightBulb.getCurrentTurnOnCount());
    }

    @Test
    void shouldSetCurrentTurnOnCount() {

        int currentTurnOnCount = 3;

        lightBulb.setCurrentTurnOnCount(currentTurnOnCount);

        assertEquals(currentTurnOnCount, lightBulb.getCurrentTurnOnCount());
    }

    @Test
    void shouldTurnOffTheLightBulb() {

        lightBulb.setTurnedOn(true);
        lightBulb.turnOff();

        assertFalse(lightBulb.isTurnedOn());
    }

    @Test
    void shouldTurnOnTheLightBulb() {

        lightBulb.turnOn();

        assertTrue(lightBulb.isTurnedOn());
    }
}