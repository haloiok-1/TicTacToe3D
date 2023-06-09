package org.haloiok.TicTacToe3D;
import java.util.Scanner;

public class Main extends Thread {
    static Field field;
    static Player player1;
    static Player player2;


    static Player currentPlayer = null;
    static Pane currentPane = null;

    static int[] currentCoordinates = new int[3];

    static Scanner scanner = new Scanner(System.in);

    static String gameName = "Tic Tac Toe 3D";

    public Main() {
        super();
        field = new Field();
        player1 = new Player('X', "Player 1");
        player2 = new Player('O', "Player 2");
        scanner.useDelimiter("[\r\n]+");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setGameName("Goofy ass Game");
        boolean endGame = false;
        currentPlayer = player2;

        while (!endGame) {
            System.out.println("next round");
            // switch the current player
            switchPlayer();

            // let the player choose a pane and a position and set the symbol
            currentCoordinates = getCompleteCoordinates();
            currentPane = field.getPane(currentCoordinates[0]);
            currentPane.setSymbolAtPosition(currentCoordinates[1], currentCoordinates[2], currentPlayer);

            //check for win
            Player winner = field.checkWin();
            //check for draw
            boolean draw = field.checkDraw();

            //if there is a winner or a draw, end the game
            if (winner != null || draw) {
                endGame = true;
            }
        }

        //print the winner
        clearConsole();
        if (field.checkWin3D() != null) {
            System.out.println(field.checkWin3D().name + " won the game!");
        } else {
            System.out.println("Draw!");
        }


    }

    public static boolean checkWin() {

        //check for win
        Player winner = field.checkWin3D();
        //check for draw
        boolean draw = field.checkDraw();

        //if there is a winner or a draw, end the game
        return winner != null || draw;
    }

    public void run() {
        //TODO implement the game logic
        //nothing to do here yet

    }

    //switch between players as current player
    public static void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public static int getPaneInput() {
        //set selectedPane to null and paneInput to -1 to enter the while loop
        int paneInput = 0;

        //while loop to check if the user input is valid
        while (paneInput < 1 || paneInput > 3) {
            clearConsole();
            field.printField();
            System.out.println("Which PANE do you want to select: ");

            //get user input and check if it is an integer
            try {
                paneInput = scanner.nextInt();
                field.getPane(paneInput);

                clearConsole();
                field.getPane(paneInput).printPane();
            } catch (Exception e) {
                System.out.println("Please enter a valid number between 1 and 3!");
                pressEnterToContinue(false);
                scanner.next();
            }
        }

        //print the selected pane
        clearConsole();
        currentPane = field.getPane(paneInput);
        return paneInput;
    }

    public static int[] getSquareInput() {
        String input = null;
        //get rid of newline character

        while (input == null || input.length() < 2 || input.length() > 3 || !checkCoordinates(input) || askYesOrNo()) {
            clearConsole();
            currentPane.printPane();
            System.out.println("Please enter the number of the square you want to place your symbol in:");
            input = scanner.next();

            try{
                clearConsole();
                currentPane.printPaneWithPlaceHolder(parseStringToIntArray(input)[0], parseStringToIntArray(input)[1]);

            }
            catch(Exception ignored){}
        }

        //parses the input string to an int array by splitting the string at every non-numeric character
        String[] parts = input.replaceAll("\\D+", " ").trim().split(" ");

        //convert the string array to an int array
        int[] coordinates = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            //parse the string to an int
            coordinates[i] = Integer.parseInt(parts[i]);
        }

        //feedback for the user
        System.out.println("You selected the square with the coordinates: " + coordinates[0] + ", " + coordinates[1]);

        //return the selected square
        return coordinates;
    }

    public static int[] getCompleteCoordinates() {
        int[] coordinates = new int[3];

        //get the pane input and the square input for the coordinates array
        coordinates[0] = getPaneInput();
        int[] squareInputArray = getSquareInput();
        coordinates[1] = squareInputArray[1];
        coordinates[2] = squareInputArray[0];

        return coordinates;
    }

    public static boolean askYesOrNo() {
        String input = null;

        //check if input is yes or no or the short form of yes or no
        while(input == null || input.length() < 1 || input.length() > 3 || !checkYesOrNo(input)) {
            System.out.println("Do you want to confirm:");
            input = scanner.next();
        }
        //return true if input is yes or y
        return !input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("y");
    }
    public static boolean checkYesOrNo(String input) {
        //return true if input is yes or y
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")
                || input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n");
    }

    public static boolean checkCoordinates(String input) {
        //parses the input string to an int array by splitting the string at every non-numeric character
        int[] coordinates = parseStringToIntArray(input);

        if (coordinates.length != 2) {
            System.out.println("Please enter only two numbers!");

            pressEnterToContinue(false);
            return false;
        }

        //check if coordinates are in range and give feedback witch coordinates are not in range
        if (coordinates[0] < 1 || coordinates[0] > 4) {
            System.out.println("The first number must be between 1 and 3!");
            pressEnterToContinue(false);
        }

        if (coordinates[1] < 1 || coordinates[1] > 4) {
            System.out.println("The second number must be between 1 and 3!");
            pressEnterToContinue(false);
        }
        //check if the square is already taken by an character
        if (currentPane.getSymbolAtPosition(coordinates[1], coordinates[0]) != ' ') {
            System.out.println("This square is already taken!");
            pressEnterToContinue(false);
        }

        //return true if coordinates are in range
        return coordinates[0] > 0 && coordinates[0] <= 3 && coordinates[1] > 0 && coordinates[1] <= 3;
    }

    public static int[] parseStringToIntArray(String text) {
        //convert the string array to an int array
        String[] parts = text.replaceAll("\\D+", " ").trim().split(" ");

        int[] coordinates = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            //parse the string to an int
            coordinates[i] = Integer.parseInt(parts[i]);
        }

        //return the selected square
        return coordinates;
    }

    //simple methods to handle the console
    public static void clearConsole() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(gameName);
            System.out.println("--------------");
            System.out.println("Spieler " + currentPlayer.getName() + " ist am Zug!");
            System.out.println();
        } catch (Exception e) {
            // Handle any exceptions.
        }

    }
    private static void pressEnterToContinue(boolean clearConsole) {
        System.out.println();
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        } catch (Exception ignored) {
        }

        //clear console if clearConsole is true
        if (clearConsole) {
            clearConsole();
        }
    }


    //test function to fill the field with characters to test the win condition
    public static void fillField() {
        field.getPane(1).setSymbolAtPosition(1, 1, player1);
        field.getPane(1).setSymbolAtPosition(1, 2, player1);
        field.getPane(1).setSymbolAtPosition(1, 3, player1);

        field.getPane(1).printPane();

        System.out.println("Check win is: " + checkWin());

        pressEnterToContinue(true);

    }

    // getter setter
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}