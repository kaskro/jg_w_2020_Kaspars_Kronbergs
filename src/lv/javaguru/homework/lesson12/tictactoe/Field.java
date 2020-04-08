package lv.javaguru.homework.lesson12.tictactoe;

import java.util.*;

public class Field {

    private Map<Integer, String> field = new LinkedHashMap<>();

    public Field() {
        for (int i = 1; i < 10; i++) {
            field.put(i, "");
        }
    }

    public void resetField() {
        for (int i = 1; i < 10; i++) {
            field.put(i, "");
        }
    }

    public boolean addValueToCell(Integer id, String value) {
        if (field.get(id).equals("")) {
            field.put(id, value);
            return true;
        }
        return false;
    }

    public String getValueFromCell(Integer id) {
        return field.get(id);
    }

    public Integer getValueCount(String value) {
        int count = 0;
        for (Map.Entry<Integer, String> cell : field.entrySet()) {
            if (cell.getValue().equals(value)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getFreeCells() {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, String> cell : field.entrySet()) {
            if (cell.getValue().equals("")) {
                result.add(cell.getKey());
            }
        }
        return result;
    }

    public boolean isThreeInRow(String value) {
        int rowOffset = 1;
        for (int i = 2; i <= 8; i += 3) {
            if (isThreeIdValuesEqual(value, i, i - rowOffset, i + rowOffset)) {
                return true;
            }
        }
        return false;
    }

    public boolean isThreeInColumn(String value) {
        int columnOffset = 3;
        for (int i = 4; i <= 6; i++) {
            if (isThreeIdValuesEqual(value, i, i - columnOffset, i + columnOffset)) {
                return true;
            }
        }
        return false;
    }

    public boolean isThreeInDiagonal(String value) {
        return isThreeIdValuesEqual(value, 1, 5, 9) || isThreeIdValuesEqual(value, 3, 5, 7);
    }

    public boolean isThreeInAnyDirection(String value) {
        return isThreeInRow(value) || isThreeInColumn(value) || isThreeInDiagonal(value);
    }

    private boolean isThreeIdValuesEqual(String value, int firstId, int secondId, int thirdId) {
        return field.get(firstId).equals(value) && field.get(secondId).equals(value) && field.get(thirdId).equals(value);
    }

    public void displayField() {
        String top = "╔═══╤═══╤═══╗";
        String mid = "╟───┼───┼───╢";
        String bot = "╚═══╧═══╧═══╝";

        System.out.println(top);
        for (Map.Entry<Integer, String> cell : field.entrySet()) {
            if (cell.getKey() == 1 || cell.getKey() == 4 || cell.getKey() == 7) {
                System.out.print("║ ");
                printCellValue(cell);
                System.out.print(" │ ");
            } else if (cell.getKey() == 3 || cell.getKey() == 6) {
                System.out.print(" │ ");
                printCellValue(cell);
                System.out.println(" ║");
                System.out.println(mid);
            } else if (cell.getKey() == 9) {
                System.out.print(" │ ");
                printCellValue(cell);
                System.out.println(" ║");
            } else {
                printCellValue(cell);
            }
        }
        System.out.println(bot);
    }

    private void printCellValue(Map.Entry<Integer, String> cell) {
        if (isCellEmpty(cell)) {
            System.out.print(cell.getKey());
        } else {
            System.out.print(cell.getValue());
        }
    }

    private boolean isCellEmpty(Map.Entry<Integer, String> cell) {
        return cell.getValue().equals("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field1 = (Field) o;
        return Objects.equals(field, field1.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }

    @Override
    public String toString() {
        return "Field{" +
                "field=" + field +
                '}';
    }
}
