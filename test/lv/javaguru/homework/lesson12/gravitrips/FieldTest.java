package lv.javaguru.homework.lesson12.gravitrips;

import org.junit.jupiter.api.BeforeEach;

class FieldTest {

    private Field field;

    @BeforeEach
    void setUp() {
        field = new Field();
    }

//    @Test
//    void shouldDisplayField() {
//        field.displayField();
//    }
//
//    @Test
//    void shouldGetColumnById() {
//        String[] testColumn = {".", ".", ".", ".", ".", ".",};
//
//        String[] resultColumn = field.getColumnById(1);
//
//        assertArrayEquals(testColumn, resultColumn);
//    }
//
//    @Test
//    void shouldBeTrueWhenCanAddToColumn() {
//        assertTrue(field.canAddToColumn(0));
//    }
//
//    @Test
//    void shouldAddValueToColumn() {
//        field.addValueToColumn(0, "X");
//        assertEquals("X", field.getColumnById(0)[Field.getROW() - 1]);
//    }
//
//    @Test
//    void shouldReturnFalseWhenColumnIsFull() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        assertFalse(field.addValueToColumn(0, "X"));
//    }
//
//    @Test
//    void shouldGetRowById() {
//        String[] testRow = {"X", ".", ".", ".", ".", ".", "."};
//
//        field.addValueToColumn(0, "X");
//        String[] resultRow = field.getRowById(5);
//
//        assertArrayEquals(testRow, resultRow);
//    }
//
//    @Test
//    void shouldGetFreeColumnIDs() {
//        int[] freeColumns = {-1, 1, 2, -1, 4, 5, 6};
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//
//        field.addValueToColumn(3, "X");
//        field.addValueToColumn(3, "X");
//        field.addValueToColumn(3, "X");
//        field.addValueToColumn(3, "X");
//        field.addValueToColumn(3, "X");
//        field.addValueToColumn(3, "X");
//
//        assertArrayEquals(freeColumns, field.getFreeColumnIDs());
//    }
//
//    @Test
//    void shouldBeTrueWhenThereIsEvenValuePatternInARows() {
//        field.addValueToColumn(4, "X");
//        field.addValueToColumn(6, "X");
//
//        assertTrue(field.isPatternFoundInRows("X", Field.getCountInSequence()));
//    }
//
//    @Test
//    void shouldBeFalseWhenThereIsNoEvenValuePatternInARows() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(1, "X");
//        field.addValueToColumn(2, "X");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(4, "O");
//        field.addValueToColumn(5, "X");
//
//        assertFalse(field.isPatternFoundInRows("X", Field.getCountInSequence()));
//    }
//
//    @Test
//    void shouldBeTrueWhenThereIsEvenValuePatternInDiagonals() {
//        field.addValueToColumn(4, "X");
//        field.addValueToColumn(4, "O");
//        field.addValueToColumn(4, "X");
//        field.addValueToColumn(6, "X");
//        field.displayField();
//
//        assertTrue(field.isPatternFoundInDiagonals("X", Field.getCountInSequence()));
//    }
//
//    @Test
//    void shouldBeFalseWhenThereIsNoEvenValuePatternInDiagonals() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(1, "X");
//        field.addValueToColumn(2, "X");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(4, "O");
//        field.addValueToColumn(5, "X");
//
//        assertFalse(field.isPatternFoundInRows("X", Field.getCountInSequence()));
//    }
//
//
//    @Test
//    void shouldBeTrueWhenThereIsFourSameValuesInAColumns() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//
//        assertTrue(field.isSameSequenceFound("X", Field.getCountInSequence(), "col"));
//    }
//
//    @Test
//    void shouldBeFalseWhenThereIsNotFourSameValuesInAColumns() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "O");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//
//        assertFalse(field.isSameSequenceFound("X", Field.getCountInSequence(), "col"));
//    }
//
//    @Test
//    void shouldBeTrueWhenThereIsFourSameValuesInARows() {
//        field.addValueToColumn(3, "X");
//        field.addValueToColumn(4, "X");
//        field.addValueToColumn(5, "X");
//        field.addValueToColumn(6, "X");
//
//        assertTrue(field.isSameSequenceFound("X", Field.getCountInSequence(), "row"));
//    }
//
//    @Test
//    void shouldBeFalseWhenThereIsNoFourSameValuesInARows() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(1, "X");
//        field.addValueToColumn(2, "X");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(4, "O");
//        field.addValueToColumn(5, "X");
//
//        assertFalse(field.isSameSequenceFound("X", Field.getCountInSequence(), "row"));
//    }
//
//
//    @Test
//    void shouldBeTrueWhenAllValuesAreSame() {
//        String[] arr = {"X", "X", "X", "X"};
//        assertTrue(field.isAllValuesTheSame(arr, arr.length, "X"));
//    }
//
//    @Test
//    void shouldBeFalseWhenAllValuesAreNotSame() {
//        String[] arr = {"X", "X", "O", "X"};
//        assertFalse(field.isAllValuesTheSame(arr, arr.length, "X"));
//    }
//
//    @Test
//    void shouldBeTrueWhenThereIsFourSameValuesInDiagonal() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(1, "O");
//        field.addValueToColumn(1, "X");
//        field.addValueToColumn(2, "O");
//        field.addValueToColumn(2, "O");
//        field.addValueToColumn(2, "X");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(3, "X");
//
//        assertTrue(field.isSameValueAmountFoundInDiagonals("X", Field.getCountInSequence()));
//    }
//
//    @Test
//    void shouldBeTrueWhenAnyDirectionHasFourSameValues() {
//        field.addValueToColumn(3, "X");
//        field.addValueToColumn(4, "X");
//        field.addValueToColumn(5, "X");
//        field.addValueToColumn(6, "X");
//
//        assertTrue(field.isSameValueAmountFoundInAnyDirection("X", Field.getCountInSequence()));
//    }
//
//    @Test
//    void shouldGetAmountOfFreeSpaces() {
//        assertEquals(Field.getROW() * Field.getCOL(), field.getAmountOfFreeSpaces());
//    }
//
//    @Test
//    void shouldRemoveLastPieceOfColumnWhenFull() {
//        String[] testArr = {".", "X", "X", "X", "X", "X"};
//
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.removeColumnsLastPieceWhenFull();
//        assertArrayEquals(testArr, field.getColumnById(0));
//    }
//
//    @Test
//    void shouldBeTrueWhenRowIsFull() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(1, "O");
//        field.addValueToColumn(2, "X");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(4, "X");
//        field.addValueToColumn(5, "O");
//        field.addValueToColumn(6, "X");
//
//        assertTrue(field.isRowFull(Field.getROW() - 1));
//    }
//
//    @Test
//    void shouldRemoveLastRowWhenFull() {
//        String[] testRow = {".", ".", ".", ".", ".", ".", "."};
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(1, "O");
//        field.addValueToColumn(2, "X");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(4, "X");
//        field.addValueToColumn(5, "O");
//        field.addValueToColumn(6, "X");
//        field.removeLastRowWhenFull();
//        assertArrayEquals(testRow, field.getRowById(Field.getROW() - 1));
//    }
//
//    @Test
//    void shouldReturnMaxCountOfValueInSequenceInRow() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(1, "X");
//        field.addValueToColumn(2, "O");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(4, "X");
//        field.addValueToColumn(5, "X");
//        field.addValueToColumn(6, "X");
//
//        assertEquals(3, field.maxCountOfValueSequenceInArray(field.getRowById(Field.getROW() - 1), "X"));
//
//    }
//
//    @Test
//    void shouldReturnMaxCountOfValueInSequenceInColumn() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "O");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//
//        assertEquals(3, field.maxCountOfValueSequenceInArray(field.getColumnById(0), "X"));
//    }
//
//    @Test
//    void shouldGetAllUniqueSymbolsInField() {
//        Set<String> testSet = new HashSet<>();
//        testSet.add("X");
//        testSet.add("O");
//        testSet.add(".");
//
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "O");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(0, "X");
//
//        assertEquals(testSet, field.getFieldSymbols());
//    }
//
//    @Test
//    void shouldGetCopyOfField() {
//        field.addValueToColumn(0, "X");
//        field.addValueToColumn(1, "X");
//        field.addValueToColumn(2, "O");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(3, "O");
//        field.addValueToColumn(4, "X");
//        field.addValueToColumn(5, "X");
//        field.addValueToColumn(6, "O");
//        field.addValueToColumn(6, "X");
//        field.addValueToColumn(6, "O");
//        field.addValueToColumn(6, "X");
//
//        Field newField = new Field(field.getCopyOfField());
//
//        assertNotEquals(newField, field);
//    }
//
//    @Test
//    void shouldGetDiagonalFromTopLeftToRightBottom() {
//        String[][] test = {
//                {"X", ".", ".", "."},
//                {".", "X", ".", "."},
//                {".", ".", "X", "."},
//                {".", ".", ".", "X"},
//        };
//        String[] testResult = {"X", "X", "X", "X"};
//
//        assertArrayEquals(testResult, field.getDiagonalOfArray(test, true));
//    }
//
//    @Test
//    void shouldGetDiagonalFromBottomLeftToRightTop() {
//        String[][] test = {
//                {".", ".", ".", "X"},
//                {".", ".", "X", "."},
//                {".", "X", ".", "."},
//                {"X", ".", ".", "."},
//        };
//        String[] testResult = {"X", "X", "X", "X"};
//
//        assertArrayEquals(testResult, field.getDiagonalOfArray(test, false));
//    }
//
//    @Test
//    void shouldBeTrueWenEvenValuesFound() {
//        String[] test = {"X", ".", "X", "."};
//        String[] test2 = {".", "X", ".", "X"};
//
//        assertTrue(field.isEvenValuesTheSame(test, "X"));
//        assertTrue(field.isEvenValuesTheSame(test2, "X"));
//    }
//
//    @Test
//    void shouldBeFalseWhenEvenValuesNotFound() {
//        String[] test = {".", "X", "O", "X"};
//
//        assertFalse(field.isEvenValuesTheSame(test, "X"));
//    }
//
//    @Test
//    void shouldBeTwoSymbols() {
//        String[] test = {"X", ".", "X", "."};
//        assertEquals(2, field.getSymbolCount(test, "X"));
//    }
//
//    @Test
//    void shouldBeTrueWhenNoOtherSymbolFound() {
//        String[] test = {"X", ".", "X", "."};
//        assertTrue(field.isOnlyOneSymbol(test, "X"));
//    }
//
//    @Test
//    void shouldBeFalseWhenThereIsMoreThanOneSymbolFound() {
//        String[] test = {"X", "O", "X", "."};
//        assertFalse(field.isOnlyOneSymbol(test, "X"));
//    }
}