package lv.javaguru.homework.lesson12.TicTacToe;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer() {
    }

    public ComputerPlayer(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    public void makeAMove(Field field) {
        Random random = new Random();
        askForInput(field);
        field.addValueToCell(field.getFreeCells().get(random.nextInt(field.getFreeCells().size())), getSymbol());
        field.displayField();
        wait(1000);
    }

    private static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
