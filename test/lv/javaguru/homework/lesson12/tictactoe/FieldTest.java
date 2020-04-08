package lv.javaguru.homework.lesson12.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    private Field field;

    @BeforeEach
    void setUp() {
        field = new Field();
    }

    @Test
    void shouldDisplayFieldInConsole() {
        field.displayField();
    }

    @Test
    void shouldAddValueToSelectedFreeCell() {
        assertTrue(field.addValueToCell(1, "X"));
    }

    @Test
    void shouldNotAddValueToSelectedOccupiedCell() {
        field.addValueToCell(1, "X");
        assertFalse(field.addValueToCell(1, "O"));
        field.displayField();
    }

    @Test
    void shouldGetValueFromCellById() {
        field.addValueToCell(1, "X");
        assertEquals("X", field.getValueFromCell(1));
    }

    @Test
    void shouldGetValueCount() {
        assertEquals(9, field.getValueCount(""));
    }

    @Test
    void shouldGetListOfFreeCells() {
        List<Integer> freeCells = new ArrayList<>();

        populateTestList(freeCells);

        assertEquals(freeCells, field.getFreeCells());
    }

    private void populateTestList(List<Integer> freeCells) {
        for (int i = 1; i < 10; i++) {
            freeCells.add(i);
        }
    }

    @Test
    void shouldBeThreeInRow() {
        field.addValueToCell(1, "X");
        field.addValueToCell(2, "X");
        field.addValueToCell(3, "X");

        assertTrue(field.isThreeInRow("X"));
    }

    @Test
    void shouldNotBeThreeInRow() {
        field.addValueToCell(1, "X");
        field.addValueToCell(3, "X");

        assertFalse(field.isThreeInRow("X"));
    }

    @Test
    void shouldBeThreeInColumn() {
        field.addValueToCell(3, "X");
        field.addValueToCell(6, "X");
        field.addValueToCell(9, "X");

        assertTrue(field.isThreeInColumn("X"));
    }

    @Test
    void shouldNotBeThreeInColumn() {
        field.addValueToCell(1, "X");
        field.addValueToCell(9, "X");

        assertFalse(field.isThreeInColumn("X"));
    }

    @Test
    void shouldBeThreeInDiagonal() {
        field.addValueToCell(1, "X");
        field.addValueToCell(5, "X");
        field.addValueToCell(9, "X");

        assertTrue(field.isThreeInDiagonal("X"));
    }

    @Test
    void shouldNotBeThreeInDiagonal() {
        field.addValueToCell(2, "X");
        field.addValueToCell(9, "X");

        assertFalse(field.isThreeInDiagonal("X"));
    }

    @Test
    void shouldBeTrueWhenThereIsThreeInSequence() {
        field.addValueToCell(1, "X");
        field.addValueToCell(5, "X");
        field.addValueToCell(9, "X");

        assertTrue(field.isThreeInAnyDirection("X"));
    }

    @Test
    void shouldNotBeTrueWhenThereIsNotThreeInSequence() {
        field.addValueToCell(2, "X");
        field.addValueToCell(9, "X");

        assertFalse(field.isThreeInAnyDirection("X"));
    }

    @Test
    void shouldResetField() {
        Field testField = new Field();

        field.addValueToCell(1, "X");
        field.addValueToCell(5, "X");
        field.addValueToCell(9, "X");

        field.resetField();
        assertEquals(testField, field);
    }
}