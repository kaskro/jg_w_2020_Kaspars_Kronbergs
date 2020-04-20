package lv.javaguru.homework.lesson12.gravitrips;

public class SmartComputerPlayer extends Player {
    public SmartComputerPlayer() {
    }

    public SmartComputerPlayer(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    public void makeAMove(Field field) {

        int bestScore = Integer.MIN_VALUE;
        int bestMove = 0;
        int score;

        for (int id : field.getFreeColumnIDs()) {
            Field testField = new Field(field.getCopyOfField());
            testField.addValueToColumn(id, getSymbol());
            testField.removeColumnsLastPieceWhenFull();
            testField.removeLastRowWhenFull();
            score = minimax(id, testField, 2, true);
            if (score > bestScore) {
                bestScore = score;
                bestMove = id;
            }
        }

        field.addValueToColumn(bestMove, getSymbol());
        field.displayField();
    }

    private int minimax(int id, Field field, int depth, boolean isMaximizing) {
        if (field.isValueSequenceFound(getSymbol())) {
            return 1000;
        } else if (field.isValueSequenceFound(getEnemySymbol(field))) {
            return -1000;
        } else if (depth == 0) {
            return calculateScore(field, id);
        }

        if (isMaximizing) {
            int maxEval = Integer.MIN_VALUE;
            int eval;
            for (int newId : field.getFreeColumnIDs()) {
                Field testField = new Field(field.getCopyOfField());
                testField.addValueToColumn(newId, getEnemySymbol(field));
                testField.removeColumnsLastPieceWhenFull();
                testField.removeLastRowWhenFull();
                eval = minimax(newId, testField, depth - 1, false);
                maxEval = Math.max(eval, maxEval);
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            int eval;
            for (int newId : field.getFreeColumnIDs()) {
                Field testField = new Field(field.getCopyOfField());
                testField.addValueToColumn(newId, getSymbol());
                testField.removeColumnsLastPieceWhenFull();
                testField.removeLastRowWhenFull();
                eval = minimax(newId, testField, depth - 1, true);
                minEval = Math.min(eval, minEval);
            }
            return minEval;
        }
    }


    private String getEnemySymbol(Field field) {
        for (String symbol : field.getFieldSymbols()) {
            if (!symbol.equals(".") || !symbol.equals(getSymbol())) {
                return symbol;
            }
        }
        return ".";
    }

    private static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private int calculateScore(Field field, int id) {
        int score = 0;

        String[][] temp;
        for (int i = 0; i <= Field.getRowAmount() - Field.getCountInSequence(); i++) {
            for (int j = 0; j <= Field.getColAmount() - Field.getCountInSequence(); j++) {
                temp = field.getInnerArray(Field.getCountInSequence(), i, j);
                for (int tempId = 0; tempId < Field.getCountInSequence(); tempId++) {
                    if (field.isValueFound(getSymbol(), temp, "row", tempId, 2)) {
                        score += 2;
                    }
                    if (field.isValueFound(getSymbol(), temp, "col", tempId, 2)) {
                        score += 2;
                    }
                    if (field.isValueFound(getSymbol(), temp, "diagonal", tempId, 2)) {
                        score += 2;
                    }
                    if (field.isValueFound(getSymbol(), temp, "row", tempId, 3)) {
                        score += 5;
                    }
                    if (field.isValueFound(getSymbol(), temp, "col", tempId, 3)) {
                        score += 5;
                    }
                    if (field.isValueFound(getSymbol(), temp, "diagonal", tempId, 3)) {
                        score += 5;
                    }
                    if (field.isValueFound(getEnemySymbol(field), temp, "row", tempId, 2)) {
                        score -= 2;
                    }
                    if (field.isValueFound(getEnemySymbol(field), temp, "col", tempId, 2)) {
                        score -= 2;
                    }
                    if (field.isValueFound(getEnemySymbol(field), temp, "diagonal", tempId, 2)) {
                        score -= 2;
                    }
                    if (field.isValueFound(getEnemySymbol(field), temp, "row", tempId, 3)) {
                        score -= 100;
                    }
                    if (field.isValueFound(getEnemySymbol(field), temp, "col", tempId, 3)) {
                        score -= 100;
                    }
                    if (field.isValueFound(getEnemySymbol(field), temp, "diagonal", tempId, 3)) {
                        score -= 100;
                    }
                }
            }
        }
        return score;
    }

}
