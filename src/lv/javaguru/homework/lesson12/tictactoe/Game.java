package lv.javaguru.homework.lesson12.tictactoe;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        GameStates currentGameState = GameStates.PICK_MODE;
        GameMode selectedGameMode = null;
        Player playerOne = new RealPlayer();
        Player playerTwo = new RealPlayer();
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

                            System.out.println("Player one:");
                            playerOne = createPlayer("r", null);

                            System.out.println("Player two:");
                            playerTwo = createPlayer("c", playerOne);

                            currentPlayer = playerOne;

                            currentGameState = doGameLoop(currentGameState, playerOne, playerTwo, currentPlayer, field);

                            break;
                        case COMPUTER_VS_COMPUTER:

                            System.out.println("Player one:");
                            playerOne = createPlayer("c", null);

                            System.out.println("Player two:");
                            playerTwo = createPlayer("c", playerOne);

                            currentPlayer = playerOne;

                            currentGameState = doGameLoop(currentGameState, playerOne, playerTwo, currentPlayer, field);

                            break;
                        default:

                            System.out.println("Player one:");
                            playerOne = createPlayer("r", null);

                            System.out.println("Player two:");
                            playerTwo = createPlayer("r", playerOne);

                            currentPlayer = playerOne;

                            currentGameState = doGameLoop(currentGameState, playerOne, playerTwo, currentPlayer, field);
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
                    break;
                case RESET_GAME:
                    field.resetField();
                    selectedGameMode = null;
                    currentGameState = GameStates.PICK_MODE;
                    break;
            }
        }

    }

    private static Player createPlayer(String type, Player other) {
        Player player;
        player = type.equals("r") ? new RealPlayer() : new ComputerPlayer();
        player.setName(addName(other == null ? "" : other.getName()));
        player.setSymbol(addSymbol(other == null ? "" : other.getSymbol()));
        return player;
    }

    private static GameStates doGameLoop(GameStates currentGameState, Player playerOne, Player playerTwo, Player currentPlayer, Field field) {
        while (currentGameState.equals(GameStates.GAME_IN_PROGRESS)) {
            currentPlayer.makeAMove(field);
            currentGameState = getGameStateFromActions(playerOne, playerTwo, field);
            currentPlayer = switchPlayers(playerOne, playerTwo, currentPlayer);
        }
        return currentGameState;
    }

    private static String addName(String other) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        String name = "";

        while (!isValid) {
            System.out.println("Please enter name (minimum length 2 characters):");
            name = scanner.nextLine();
            if (name.length() < 2) {
                System.out.println("'" + name + "' is less than 2 characters! Try again.");
            } else if (other.equals(name)) {
                System.out.println("This name \"" + name + "\" is taken by other player. Please choose different name.");
            } else {
                isValid = true;
            }
        }
        return name;
    }

    private static String addSymbol(String other) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        String symbol = "";

        while (!isValid) {
            System.out.println("Please enter your symbol ( Single character, can't be numbers from 1 - 9):");
            symbol = "" + scanner.nextLine();
            if (symbol.length() > 1) {
                System.out.println("Must be single character! Try again.");
            } else if (symbol.matches("[1-9]")) {
                System.out.println("Can't be numbers from 1 to 9! Try again.");
            } else if (symbol.equals("")) {
                System.out.println("Can't be nothing! Try again.");
            } else if (other.equals(symbol)) {
                System.out.println("This symbol \"" + symbol + "\" is taken by other player. Please choose different symbol.");
            } else {
                isValid = true;
            }
        }
        return symbol;
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

    private static Player switchPlayers(Player playerOne, Player playerTwo, Player currentPlayer) {
        if (currentPlayer.equals(playerOne)) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
        return currentPlayer;
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
