package lv.javaguru.homework.lesson12.TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;

    @BeforeEach
    void setUp() {
        computerPlayer = new ComputerPlayer("Computer", "X");
    }

    @Test
    void shouldPickRandomNumberFromList() {
        List<Integer> testList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        testList.add(1);
        testList.add(4);
        testList.add(7);

        resultList.add(computerPlayer.pickRandomNumberFromList(testList));
        resultList.add(computerPlayer.pickRandomNumberFromList(testList));
        resultList.add(computerPlayer.pickRandomNumberFromList(testList));

        assertNotEquals(testList, resultList);
    }
}