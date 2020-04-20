package lv.javaguru.homework.lesson12.gravitrips;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Field {

    private static final int ROW_AMOUNT = 6;
    private static final int COL_AMOUNT = 7;
    private static final int COUNT_IN_SEQUENCE = 4;
    private String emptySpace = ".";
    private String[][] field = new String[COL_AMOUNT][ROW_AMOUNT];

    Field() {
        for (int c = 0; c < COL_AMOUNT; c++) {
            for (int r = 0; r < ROW_AMOUNT; r++) {
                field[c][r] = emptySpace;
            }
        }
    }

    public Field(String[][] field) {
        this.field = field;
    }

    public void setField(String[][] field) {
        this.field = field;
    }

    public boolean addValueToColumn(int col, String value) {
        if (canAddToColumn(col)) {
            for (int r = ROW_AMOUNT - 1; r >= 0; r--) {
                if (field[col][r].equals(emptySpace)) {
                    field[col][r] = value;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canAddToColumn(int id) {
        if (isIdInRange(id)) {
            for (String value : field[id]) {
                if (value.equals(emptySpace)) return true;
            }
        }
        return false;
    }

    public void removeColumnsLastPieceWhenFull() {
        for (int c = 0; c < COL_AMOUNT; c++) {
            if (!canAddToColumn(c)) {
                removeLastElementInArray(c);
            }
        }
    }

    public void removeLastRowWhenFull() {
        if (isRowFull(ROW_AMOUNT - 1)) {
            for (int c = 0; c < COL_AMOUNT; c++) {
                removeLastElementInArray(c);
            }
        }
    }

    private void removeLastElementInArray(int c) {
        for (int i = field[c].length - 1; i >= 0; i--) {
            if (i == 0) {
                field[c][i] = emptySpace;
            } else {
                field[c][i] = field[c][i - 1];
            }
        }
    }

    public boolean isRowFull(int id) {
        String[] row = getRowById(id);
        for (String el : row) {
            if (el.equals(emptySpace)) return false;
        }
        return true;
    }

    private boolean isIdInRange(int id) {
        return id >= 0 && id < COL_AMOUNT;
    }


    public int getSymbolCount(String[] arr, String value) {
        int count = 0;
        for (String symbol : arr) {
            if (symbol.equals(value))
                count++;
        }
        return count;
    }

    public boolean isOnlyOneSymbol(String[] arr, String value) {
        for (String symbol : arr) {
            if (!symbol.equals(value) && !symbol.equals(emptySpace)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValueSequenceFound(String value) {
        String[][] temp;
        for (int i = 0; i <= ROW_AMOUNT - COUNT_IN_SEQUENCE; i++) {
            for (int j = 0; j <= COL_AMOUNT - COUNT_IN_SEQUENCE; j++) {
                temp = getInnerArray(COUNT_IN_SEQUENCE, i, j);
                for (int id = 0; id < COUNT_IN_SEQUENCE; id++) {
                    if (isFoundInRow(value, temp, id)) return true;
                    if (isFoundInCol(value, temp, id)) return true;
                    if (isFoundInDiagonals(value, temp)) return true;
                }
            }
        }
        return false;
    }

    private boolean isFoundInDiagonals(String value, String[][] temp) {
        if (isOnlyOneSymbol(getDiagonalOfArray(temp, true).get(), value)
                && getSymbolCount(getDiagonalOfArray(temp, true).get(), value) == COUNT_IN_SEQUENCE
        ) return true;
        if (isOnlyOneSymbol(getDiagonalOfArray(temp, false).get(), value)
                && getSymbolCount(getDiagonalOfArray(temp, false).get(), value) == COUNT_IN_SEQUENCE
        ) return true;
        return false;
    }

    private boolean isFoundInCol(String value, String[][] temp, int id) {
        if (isOnlyOneSymbol(getArrayColById(temp, id).get(), value)
                && getSymbolCount(getArrayColById(temp, id).get(), value) == COUNT_IN_SEQUENCE
        ) return true;
        return false;
    }

    private boolean isFoundInRow(String value, String[][] temp, int id) {
        if (isOnlyOneSymbol(getArrayRowById(temp, id).get(), value)
                && getSymbolCount(getArrayRowById(temp, id).get(), value) == COUNT_IN_SEQUENCE
        ) return true;
        return false;
    }

    public boolean isValueFound(String value, String[][] temp, String direction, int id, int amount) {
        switch (direction) {
            case "col":
                if (isOnlyOneSymbol(getArrayColById(temp, id).get(), value)
                        && getSymbolCount(getArrayColById(temp, id).get(), value) == amount
                ) return true;
                break;
            case "diagonal":
                if (isOnlyOneSymbol(getDiagonalOfArray(temp, true).get(), value)
                        && getSymbolCount(getDiagonalOfArray(temp, true).get(), value) == amount
                ) return true;
                if (isOnlyOneSymbol(getDiagonalOfArray(temp, false).get(), value)
                        && getSymbolCount(getDiagonalOfArray(temp, false).get(), value) == amount
                ) return true;
                break;
            default:
                if (isOnlyOneSymbol(getArrayRowById(temp, id).get(), value)
                        && getSymbolCount(getArrayRowById(temp, id).get(), value) == amount
                ) return true;
        }
        return false;
    }

    public String[][] getInnerArray(int amount, int rowOffset, int colOffset) {
        String[][] result = new String[amount][amount];
        int incI = 0;
        int incJ = 0;
        for (int r = rowOffset; r < amount + rowOffset; r++) {
            for (int c = colOffset; c < amount + colOffset; c++) {
                result[incI][incJ] = field[c][r];
                incJ++;
            }
            incJ = 0;
            incI++;
        }
        return result;
    }

    public Optional<String[]> getArrayRowById(String[][] arr, int id) {
        if (arr.length == arr[0].length || id < 0 || id > arr.length) {
            String[] tempRow = new String[arr.length];
            for (int c = 0; c < arr.length; c++) {
                tempRow[c] = arr[c][id];
            }
            return Optional.of(tempRow);
        } else {
            return Optional.empty();
        }
    }

    public Optional<String[]> getArrayColById(String[][] arr, int id) {
        if (arr.length == arr[0].length || id < 0 || id > arr.length) {
            return Optional.of(arr[id]);
        } else {
            return Optional.empty();
        }
    }

    public int getAmountOfFreeSpaces() {
        int count = 0;
        for (String[] innerArr : field) {
            for (String value : innerArr) {
                if (value.equals(emptySpace)) {
                    count++;
                }
            }
        }
        return count;
    }

    public Optional<String[]> getDiagonalOfArray(String[][] arr, boolean topLeftToBottomRight) {
        if (arr.length == arr[0].length) {
            String[] result = new String[arr.length];
            for (int r = 0; r < arr.length; r++) {
                for (int c = 0; c < arr[r].length; c++) {
                    if (topLeftToBottomRight) {
                        if (r == c) {
                            result[r] = arr[r][c];
                        }
                    } else {
                        if (r == (arr[r].length - 1) - c) {
                            result[r] = arr[r][c];
                        }
                    }
                }
            }
            return Optional.of(result);
        } else {
            return Optional.empty();
        }
    }

    public String getEmptySpace() {
        return emptySpace;
    }

    public void setEmptySpace(String emptySpace) {
        this.emptySpace = emptySpace;
    }

    public static int getRowAmount() {
        return ROW_AMOUNT;
    }

    public static int getColAmount() {
        return COL_AMOUNT;
    }

    public static int getCountInSequence() {
        return COUNT_IN_SEQUENCE;
    }

    public String[][] getField() {
        return field;
    }

    public Set<String> getFieldSymbols() {
        Set<String> set = new HashSet<>();
        for (String[] innerArr : field) {
            for (String value : innerArr) {
                set.add(value);
            }
        }
        return set;
    }

    public Optional<String[]> getColumnById(int id) {
        if (id >= 0 && id == field.length) {
            return Optional.of(field[id]);
        } else {
            return Optional.empty();
        }
    }

    public String[] getRowById(int id) {
        String[] tempRow = new String[COL_AMOUNT];
        for (int c = 0; c < COL_AMOUNT; c++) {
            tempRow[c] = field[c][id];
        }
        return tempRow;
    }

    public int[] getFreeColumnIDs() {
        int[] temp = new int[COL_AMOUNT];
        for (int i = 0; i < COL_AMOUNT; i++) {
            if (canAddToColumn(i)) {
                temp[i] = i;
            } else {
                temp[i] = -1;
            }
        }
        return temp;
    }

    public String[][] getCopyOfField() {
        String[][] newCopy = new String[COL_AMOUNT][ROW_AMOUNT];
        for (int c = 0; c < COL_AMOUNT; c++) {
            for (int r = 0; r < ROW_AMOUNT; r++) {
                newCopy[c][r] = field[c][r];
            }
        }
        return newCopy;
    }

    public void displayField() {
        for (int r = -1; r < ROW_AMOUNT; r++) {
            for (int c = 0; c < COL_AMOUNT; c++) {
                if (r == -1) {
                    System.out.print((getFreeColumnIDs()[c] == -1) ? "  " : getFreeColumnIDs()[c] + 1 + " ");
                } else {
                    System.out.print(field[c][r] + " ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field1 = (Field) o;
        return Arrays.equals(field, field1.field);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(field);
    }

    @Override
    public String toString() {
        return "Field{" +
                "field=" + Arrays.toString(field) +
                '}';
    }
}
