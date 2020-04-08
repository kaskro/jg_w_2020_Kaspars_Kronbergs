package lv.javaguru.homework.lesson12.gravitrips;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    private Field field;

    @BeforeEach
    void setUp() {
        field = new Field();
    }

    @Test
    void shouldDisplayField() {
        field.displayField();
    }

    @Test
    void shouldGetColumnById() {
        String[] testColumn = {".", ".", ".", ".", ".", ".",};

        String[] resultColumn = field.getColumnById(1);

        assertArrayEquals(testColumn, resultColumn);
    }

    @Test
    void shouldBeTrueWhenCanAddToColumn() {
        assertTrue(field.canAddToColumn(0));
    }

    @Test
    void shouldAddValueToColumn() {
        field.addValueToColumn(0, "X");
        assertEquals("X", field.getColumnById(0)[Field.getROW() - 1]);
    }

    @Test
    void shouldReturnFalseWhenColumnIsFull() {
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        assertFalse(field.addValueToColumn(0, "X"));
    }

    @Test
    void shouldGetRowById() {
        String[] testRow = {"X", ".", ".", ".", ".", ".", "."};

        field.addValueToColumn(0, "X");
        String[] resultRow = field.getRowById(5);

        assertArrayEquals(testRow, resultRow);
    }

    @Test
    void shouldGetFreeColumnIDs() {
        int[] freeColumns = {-1, 1, 2, -1, 4, 5, 6};
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");

        field.addValueToColumn(3, "X");
        field.addValueToColumn(3, "X");
        field.addValueToColumn(3, "X");
        field.addValueToColumn(3, "X");
        field.addValueToColumn(3, "X");
        field.addValueToColumn(3, "X");

        assertArrayEquals(freeColumns, field.getFreeColumnIDs());
    }

    @Test
    void shouldBeTrueWhenThereIsFourSameValuesInAColumns() {
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");
        field.addValueToColumn(0, "X");

        assertTrue(field.isFourSameValuesInColumns("X"));
    }

    @Test
    void shouldBeTrueWhenThereIsFourSameValuesInARows() {
        field.addValueToColumn(3, "X");
        field.addValueToColumn(4, "X");
        field.addValueToColumn(5, "X");
        field.addValueToColumn(6, "X");

        assertTrue(field.isFourSameValuesInRows("X"));
    }

    @Test
    void shouldBeTrueWhenThereIsFourSameValuesInDiagonal() {
        field.addValueToColumn(0, "X");
        field.addValueToColumn(1, "O");
        field.addValueToColumn(1, "X");
        field.addValueToColumn(2, "O");
        field.addValueToColumn(2, "O");
        field.addValueToColumn(2, "X");
        field.addValueToColumn(3, "O");
        field.addValueToColumn(3, "O");
        field.addValueToColumn(3, "O");
        field.addValueToColumn(3, "X");

        assertTrue(field.isFourSameValuesInDiagonals("X"));
    }

    @Test
    void shouldBeTrueWhenAnyDirectionHasFourSameValues() {
        field.addValueToColumn(3, "X");
        field.addValueToColumn(4, "X");
        field.addValueToColumn(5, "X");
        field.addValueToColumn(6, "X");

        assertTrue(field.isFourValuesFoundInAnyDirection("X"));
    }
}