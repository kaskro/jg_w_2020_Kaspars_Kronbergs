package lv.javaguru.homework.lesson12.tictactoe;

import java.util.Scanner;

public class RealPlayer extends Player {

    public RealPlayer() {
    }

    public RealPlayer(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    public void makeAMove(Field field) {
        Scanner scanner = new Scanner(System.in);
        boolean isMoveDone = false;
        while (!isMoveDone) {
            try {
                askForInput(field);
                field.displayField();
                Integer id = Integer.parseInt(scanner.nextLine());
                if (!field.getValueFromCell(id).equals("")) {
                    System.out.println("Cell '" + id + "' is taken, choose other cell!");
                } else {
                    isMoveDone = field.addValueToCell(id, getSymbol());
                }
            } catch (Exception e) {
                System.out.println("Wrong input, please try again!");
            }
        }
    }

}
