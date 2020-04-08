package lv.javaguru.homework.lesson12.tictactoe;

import java.util.Objects;

public abstract class Player {

    private String name;
    private String symbol;

    public Player() {
    }

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void askForInput(Field field) {
        System.out.print(name + "( '" + symbol + "' ) , please enter one: ");
        for (Integer cellId : field.getFreeCells()) {
            System.out.print("'" + cellId + "' ");
        }
        System.out.println(";");
    }

    public abstract void makeAMove(Field field);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(symbol, player.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
