package lv.javaguru.homework.lesson12.gravitrips;

import java.util.Arrays;

public class Field {

    private static final int ROW = 6;
    private static final int COL = 7;
    private String[][] field = new String[COL][ROW];

    Field() {
        for (int c = 0; c < COL; c++) {
            for (int r = 0; r < ROW; r++) {
                field[c][r] = ".";
            }
        }
    }

    public void displayField() {
        for (int r = -1; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (r == -1) {
                    System.out.print((getFreeColumnIDs()[c] == -1) ? "  " : getFreeColumnIDs()[c] + 1 + " ");
                } else {
                    System.out.print(field[c][r] + " ");
                }
            }
            System.out.println();
        }
    }

    public String[] getColumnById(int id) {
        return field[id];
    }

    public String[] getRowById(int id) {
        String[] tempRow = new String[COL];
        for (int c = 0; c < COL; c++) {
            tempRow[c] = field[c][id];
        }
        return tempRow;
    }

    public boolean canAddToColumn(int id) {
        if (isIdInRange(id)) {
            for (String value : field[id]) {
                if (value.equals(".")) return true;
            }
        }
        return false;
    }

    private boolean isIdInRange(int id) {
        return id >= 0 && id < COL;
    }

    public boolean addValueToColumn(int col, String value) {
        if (canAddToColumn(col)) {
            for (int r = ROW - 1; r >= 0; r--) {
                if (field[col][r].equals(".")) {
                    field[col][r] = value;
                    return true;
                }
            }
        }
        return false;
    }

    public int[] getFreeColumnIDs() {
        int[] temp = new int[COL];
        for (int i = 0; i < COL; i++) {
            if (canAddToColumn(i)) {
                temp[i] = i;
            } else {
                temp[i] = -1;
            }
        }
        return temp;
    }


    public static int getROW() {
        return ROW;
    }

    public boolean isFourSameValuesInColumns(String value) {
        String[] col;
        for (int id = 0; id < COL; id++) {
            col = getColumnById(id);
            for (int i = 0; i < 3; i++) {
                if (col[i].equals(value)
                        && col[i + 1].equals(value)
                        && col[i + 2].equals(value)
                        && col[i + 3].equals(value)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFourSameValuesInRows(String value) {
        String[] row;
        for (int id = 0; id < ROW; id++) {
            row = getRowById(id);
            for (int i = 0; i < 4; i++) {
                if (row[i].equals(value)
                        && row[i + 1].equals(value)
                        && row[i + 2].equals(value)
                        && row[i + 3].equals(value)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFourSameValuesInDiagonals(String value) {
        int colOffset = 4;
        int rowOffset = 3;
        int amount = 4;

        for (int i = 0; i < rowOffset; i++) {
            for (int j = 0; j < colOffset; j++) {
                if (checkBothDiagonals(getInnerArray(amount, i, j), value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFourValuesFoundInAnyDirection(String value) {
        return isFourSameValuesInRows(value) || isFourSameValuesInColumns(value) || isFourSameValuesInDiagonals(value);
    }

    private String[][] getInnerArray(int amount, int i, int j) {
        String[][] result = new String[amount][amount];
        int incI = 0;
        int incJ = 0;
        for (int r = i; r < amount + i; r++) {
            for (int c = j; c < amount + j; c++) {
                result[incI][incJ] = field[c][r];
                incJ++;
            }
            incJ = 0;
            incI++;
        }
        return result;
    }

    public int getAmountOfFreeSpaces() {
        int count = 0;
        for (String[] innerArr : field) {
            for (String value : innerArr) {
                if (value.equals(".")) {
                    count++;
                }
            }
        }
        return count;
    }

    private void printArray(String[][] arr) {
        for (String[] innerArr : arr) {
            for (String value : innerArr) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private boolean checkFirstDiagonal(String[][] arr, String value) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (r == c) {
                    if (!arr[r][c].equals(value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkSecondDiagonal(String[][] arr, String value) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (r == (arr[r].length - 1) - c) {
                    if (!arr[r][c].equals(value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkBothDiagonals(String[][] arr, String value) {
        return (checkFirstDiagonal(arr, value) || checkSecondDiagonal(arr, value));
    }

    private static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static int getCOL() {
        return COL;
    }

    public String[][] getField() {
        return field;
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
