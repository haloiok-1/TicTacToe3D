package org.example;
import java.util.Scanner;

public class Main extends Thread {
    static Field field;
    static Player player1;
    static Player player2;

    static Player currentPlayer = null;
    static Pane currentPane = null;

    static int[] currentCoordinates = new int[3];

    static Scanner scanner = new Scanner(System.in);

    public Main() {
        super();
        field = new Field();
        player1 = new Player('X', "Player 1");
        player2 = new Player('O', "Player 2");
        scanner.useDelimiter("[\r\n]+");
    }

    public static void main(String[] args) {
        Main main = new Main();
        int counter = 10;

        while (counter > 0) {
            System.out.println("next round");
            currentPlayer = player1;

            currentCoordinates = getCompleteCoordinates();
            currentPane = field.getPane(currentCoordinates[0]);
            currentPane.setSymbolAtPosition(currentCoordinates[1], currentCoordinates[2], currentPlayer);

            currentPlayer = player2;

            currentCoordinates = getCompleteCoordinates();
            currentPane = field.getPane(currentCoordinates[0]);
            currentPane.setSymbolAtPosition(currentCoordinates[1], currentCoordinates[2], currentPlayer);

            counter--;
        }


    }

    public static void startGame() {

        //print welcome message
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player 1 is X, Player 2 is O");
        System.out.println("Player 1 starts!");

        pressEnterToContinue(false);

        //describe the field with 3 dimensions
        System.out.println("The field is divided into 3 panes, each pane is divided into 9 squares.");
        System.out.println("A pane looks like this:");
        System.out.println("1 | 2 | 3");
        System.out.println("4 | 5 | 6");
        System.out.println("7 | 8 | 9");

        pressEnterToContinue(false);

        //describe the input method
        System.out.println("At first you will be asked to enter the number of the pane you want to place your symbol in.");
        System.out.println("To place your symbol in the top pane, enter 1");
        System.out.println("After this the game will show you the pane you chose and ask you to enter the number of the field you want to place your symbol in.");
        System.out.println("To place your symbol on a field, enter the number of the field");
        System.out.println("For example, to place your symbol on the top right field, enter 3");
        System.out.println("To place your symbol on the middle left field, enter 4");

        //
        System.out.println();
        System.out.println("For questions, suggestions or bug reports: Czylonio#0529 on Discord");
        System.out.println("Good luck!");

        pressEnterToContinue(true);
    }

    public void run() {
        //TODO implement the game logic
        //nothing to do here yet

    }

    public static int getPaneInput() {
        //set selectedPane to null and paneInput to -1 to enter the while loop
        int paneInput = 0;

        //while loop to check if the user input is valid
        while (paneInput < 1 || paneInput > 3 || askYesOrNo()) {
            clearConsole();
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
                continue;
            }
        }

        //print the selected pane
        clearConsole();
        System.out.println("You selected the pane with the id: " + paneInput);
        pressEnterToContinue(true);
        currentPane = field.getPane(paneInput);
        return paneInput;
    }

    public static int[] getSquareInput() {
        String input = null;
        //get rid of newline character

        while (input == null || input.length() < 2 || input.length() > 3 || !checkCoordinates(input) || askYesOrNo()) {
            clearConsole();
            System.out.println("Please enter the number of the square you want to place your symbol in:");
            input = scanner.next();

            try{
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
        }
        catch(Exception ignored)
        {}

        //clear console if clearConsole is true
        if (clearConsole) {
            clearConsole();
        }
    }

}