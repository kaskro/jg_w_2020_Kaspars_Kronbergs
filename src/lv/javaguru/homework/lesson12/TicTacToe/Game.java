package lv.javaguru.homework.lesson12.TicTacToe;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        GameStates currentGameState = GameStates.PICK_MODE;
        GameMode selectedGameMode = null;
        Player playerOne = new Player("", "");
        Player playerTwo = new Player("", "");
        boolean isMoveDone = false;
        Player currentPlayer;
        Field field = new Field();

        Scanner scanner = new Scanner(System.in);

        while (!currentGameState.equals(GameStates.GAME_END)) {
            switch (currentGameState) {
                case PICK_MODE:
                    while (selectedGameMode == null) {
                        System.out.println("Please select game mode:");
                        System.out.println("1 - Player vs Player;");
                        System.out.println("2 - Player vs Computer;");
                        System.out.println("3 - Computer vs Computer;");
                        String selection = scanner.nextLine();
                        switch (selection) {
                            case "1":
                                System.out.println("'Player vs Player' selected.");
                                selectedGameMode = GameMode.PLAYER_VS_PLAYER;
                                currentGameState = GameStates.GAME_IN_PROGRESS;
                                break;
                            case "2":
                                System.out.println("'Player vs Computer' selected.");
                                selectedGameMode = GameMode.PLAYER_VS_COMPUTER;
                                currentGameState = GameStates.GAME_IN_PROGRESS;
                                break;
                            case "3":
                                System.out.println("'Computer vs Computer' selected.");
                                selectedGameMode = GameMode.COMPUTER_VS_COMPUTER;
                                currentGameState = GameStates.GAME_IN_PROGRESS;
                                break;
                            default:
                                System.out.println("Please select (1 , 2 or 3). Mode '" + selection + "' not found!");
                        }
                    }
                    break;
                case GAME_IN_PROGRESS:

                    switch (selectedGameMode) {
                        case PLAYER_VS_COMPUTER:
                            playerOne = new Player("PlayerOne", "X");
                            currentPlayer = playerOne;
                            playerTwo = new ComputerPlayer("PlayerTwo", "O");
                            break;
                        case COMPUTER_VS_COMPUTER:
                            playerOne = new ComputerPlayer("PlayerOne", "X");
                            currentPlayer = playerOne;
                            playerTwo = new ComputerPlayer("PlayerTwo", "O");
                            break;
                        default:

                            System.out.println("Player one:");
                            playerOne = addPlayer(playerTwo, "p");
                            System.out.println("Player two:");
                            playerTwo = addPlayer(playerOne, "p");

                            currentPlayer = playerOne;

                            while (currentGameState.equals(GameStates.GAME_IN_PROGRESS)) {

//                                while (!isMoveDone) {
//                                    askForInput(currentPlayer, field);
//                                    isMoveDone = isPlayerMoveDone(isMoveDone, currentPlayer, field);
//                                }
                                playerMove(currentPlayer, field);

                                currentGameState = getGameStateFromActions(playerOne, playerTwo, field);
                                currentPlayer = getPlayer(playerOne, playerTwo, currentPlayer);
//                                isMoveDone = false;
                            }
                    }

                    break;

                case PLAYER_ONE_WINS:
                    System.out.println("Congratulations, " + playerOne.getName() + ", you win!");
                    currentGameState = doGameReset();
                    break;
                case PLAYER_TWO_WINS:
                    System.out.println("Congratulations, " + playerTwo.getName() + ", you win!");
                    currentGameState = doGameReset();
                    break;
                case DRAW:
                    System.out.println("It's a draw!");
                    currentGameState = doGameReset();
                case RESET_GAME:
                    field.resetField();
                    currentPlayer = playerOne;
                    selectedGameMode = null;
                    currentGameState = GameStates.PICK_MODE;
                    break;
            }
        }

    }

//    private static boolean isPlayerMoveDone(boolean isMoveDone, Player currentPlayer, Field field) {
//        Scanner scanner = new Scanner(System.in);
//        try {
//            Integer id = Integer.parseInt(scanner.nextLine());
//            if (!field.getValueFromCell(id).equals("")) {
//                System.out.println("Cell '" + id + "' is taken, choose other cell!");
//            } else {
//                isMoveDone = field.addValueToCell(id, currentPlayer.getSymbol());
//                field.displayField();
//            }
//        } catch (Exception e) {
//            System.out.println("Wrong input, please try again!");
//        }
//        return isMoveDone;
//    }

    private static void playerMove(Player currentPlayer, Field field) {
        Scanner scanner = new Scanner(System.in);
        boolean isMoveDone = false;
        while (!isMoveDone) {
            try {
                askForInput(currentPlayer, field);
                field.displayField();
                Integer id = Integer.parseInt(scanner.nextLine());
                if (!field.getValueFromCell(id).equals("")) {
                    System.out.println("Cell '" + id + "' is taken, choose other cell!");
                } else {
                    isMoveDone = field.addValueToCell(id, currentPlayer.getSymbol());
                }
            } catch (Exception e) {
                System.out.println("Wrong input, please try again!");
            }
        }
    }

    private static Player addPlayer(Player other, String type) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String symbol = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Please enter name (minimum length 2 characters):");
            name = scanner.nextLine();
            if (name.length() < 2) {
                System.out.println("'" + name + "' is less than 2 characters! Try again.");
            } else if (other.getName().equals(name)) {
                System.out.println("This name \"" + name + "\" is taken by other player. Please choose different name.");
            } else {
                isValid = true;
            }
        }

        isValid = false;
        while (!isValid) {
            System.out.println("Please enter your symbol:");
            symbol = "" + scanner.nextLine().charAt(0);
            if (symbol == "") {
                System.out.println("Can't be nothing! Try again.");
            } else if (other.getSymbol().equals(symbol)) {
                System.out.println("This symbol \"" + symbol + "\" is taken by other player. Please choose different symbol.");
            } else {
                isValid = true;
            }
        }

        return type.equals("p") ? new Player(name, symbol) : new ComputerPlayer(name, symbol);
    }

    private static GameStates doGameReset() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Do you want to reset game? Y/N");
        input = scanner.nextLine();
        if (input.equals("Y") || input.equals("y")) {
            return GameStates.RESET_GAME;
        }
        System.out.println("Bye bye!");
        return GameStates.GAME_END;
    }

    private static Player getPlayer(Player playerOne, Player playerTwo, Player currentPlayer) {
        if (currentPlayer.equals(playerOne)) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
        return currentPlayer;
    }

    private static void askForInput(Player player, Field field) {
        System.out.print(player.getName() + "( '" + player.getSymbol() + "' ) , please enter one: ");
        for (Integer cellId : field.getFreeCells()) {
            System.out.print("'" + cellId + "' ");
        }
        System.out.println(";");
    }

    private static GameStates getGameStateFromActions(Player playerOne, Player playerTwo, Field field) {
        if (!field.isThreeInAnyDirection(playerOne.getSymbol())
                && !field.isThreeInAnyDirection(playerTwo.getSymbol())
                && field.getValueCount("") < 1) {
            return GameStates.DRAW;
        } else if (field.isThreeInAnyDirection(playerOne.getSymbol())) {
            return GameStates.PLAYER_ONE_WINS;
        } else if (field.isThreeInAnyDirection(playerTwo.getSymbol())) {
            return GameStates.PLAYER_TWO_WINS;
        } else return GameStates.GAME_IN_PROGRESS;
    }
}
