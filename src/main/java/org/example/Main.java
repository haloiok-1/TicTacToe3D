package org.example;
import java.util.Scanner;


public class Main extends Thread{

    static Field field;
    Player player1;
    Player player2;

    static int[] fieldCoordinates = {-1, -1, -1};
    Player currentPlayer = null;

    static Scanner scanner = new Scanner(System.in);

    public Main() {
        super();
        field = new Field();
        player1 = new Player('X', "Player 1");
        player2 = new Player('O', "Player 2");
    }

    public static void main(String[] args) {
        Main main = new Main();
        fieldCoordinates[0] = getPaneInput();
        fieldCoordinates[1] = getSquareInput()[0];
        fieldCoordinates[2] = getSquareInput()[1];
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



    public static void printPane(int id){

        Pane currentPane = field.getPane(id);

        System.out.println("    |  1  |  2  |  3  |");

        for (int i = 0; i < 3; i++) {
            System.out.println("  --------------------");
            System.out.println("  " + (i + 1) + " |  " + currentPane.field[i][0] + "  |  "
                    + currentPane.field[i][1] + "  |  " + currentPane.field[i][2] + "  |");
            System.out.println("  --------------------");
        }
    }

    public static int getPaneInput() {
        //set selectedPane to null and paneInput to -1 to enter the while loop
        Pane selectedPane = null;
        int paneInput = -1;

        //while loop to check if the user input is valid
        while (paneInput < 1 || paneInput > 3) {
            clearConsole();
            System.out.println("Which PANE do you want to select: ");

            //get user input and check if it is an integer
            paneInput = scanner.nextInt();

            //try to get the pane with the given id, if the id is not valid, an IllegalArgumentException is raised
            try {
                selectedPane = field.getPane(paneInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid number between 1 and 3!");
            }
        }

        //return the selected pane
        return paneInput;
    }
    public static int[] getSquareInput() {
        //set selectedSquare to null and squareInput to -1 to enter the while loop
        String input = null;

        //while loop to check if the user input is valid
        while(input == null || input.length() == 0 || input.length() > 3 || !checkCoordinates(input)) {
            System.out.println("Please enter the number of the square you want to place your symbol in: ");
            //get user input as string with all type of separators
            input = scanner.nextLine();
        }

        //parses the input string to an int array by splitting the string at every non-numeric character
        String[] parts = input.replaceAll("\\D+", " ").trim().split(" ");

        //convert the string array to an int array
        int[] coordinates = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            //parse the string to an int
            coordinates[i] = Integer.parseInt(parts[i]);
        }

        //return the selected square
        return coordinates;
    }



    public static boolean checkCoordinates(String input) {
        //parses the input string to an int array by splitting the string at every non-numeric character
        String[] parts = input.replaceAll("\\D+", " ").trim().split(" ");

        int[] coordinates = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            coordinates[i] = Integer.parseInt(parts[i]);
        }


        //check if coordinates are in range and give feedback witch coordinates are not in range
        if (coordinates[0] < 1 || coordinates[0] > 3) {
            System.out.println("The first number must be between 1 and 3!");
        }
        if (coordinates[1] < 1 || coordinates[1] > 3) {
            System.out.println("The second number must be between 1 and 3!");
        }
        //return true if coordinates are in range
        return coordinates[0] > 0 && coordinates[0] < 3 && coordinates[1] > 0 && coordinates[1] < 3;
    }

    public static void fillField(int pane, int x, int y, Player currentPlayer) {
        Pane currentPane = field.getPane(pane);
        currentPane.field[x][y] = Player.symbol;
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