package lv.javaguru.homework.lesson12.gravitrips;

import java.util.Random;

public class ComputerPlayer extends Player {
    @Override
    public void makeAMove(Field field) {
        Random random = new Random();
        askForInput(field);
        int randomId = field.getFreeColumnIDs()[random.nextInt(field.getFreeColumnIDs().length)];
        field.addValueToColumn(randomId, getSymbol());
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
