package lv.javaguru.homework.lesson12.TicTacToe;

import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name, String symbol) {
        super(name, symbol);
    }

    public Integer pickRandomNumberFromList(List<Integer> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
