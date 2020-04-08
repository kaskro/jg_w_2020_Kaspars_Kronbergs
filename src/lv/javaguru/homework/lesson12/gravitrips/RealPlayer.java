package lv.javaguru.homework.lesson12.gravitrips;

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
                int id = Integer.parseInt(scanner.nextLine());
                if (!field.canAddToColumn(id - 1)) {
                    System.out.println("Can't choose column '" + id + "' , pick other column!");
                } else {
                    isMoveDone = field.addValueToColumn(id - 1, getSymbol());
                }
            } catch (Exception e) {
                System.out.println("Wrong input, please try again!");
            }
            field.displayField();
        }
    }

}
