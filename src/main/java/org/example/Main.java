package org.example;
import java.util.Scanner;


public class Main extends Thread{

    Field field;
    Player player1;
    Player player2;

    static Scanner scanner = new Scanner(System.in);

    public Main() {
        super();
        field = new Field();
        player1 = new Player('X', "Player 1");
        player2 = new Player('O', "Player 2");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startGame();

        main.printPane(0);
        System.out.println("Started game!");
    }

    public void startGame() {

        //print welcome message
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player 1 is X, Player 2 is O");
        System.out.println("Player 1 starts!");

        //describe the field with 3 dimensions
        System.out.println("The field is divided into 3 panes, each pane is divided into 3 fields");
        System.out.println("The field looks like this:");
        System.out.println("1 | 2 | 3");
        System.out.println("4 | 5 | 6");
        System.out.println("7 | 8 | 9");

        //describe the input method
        System.out.println("At first you will be asked to enter the number of the pane you want to place your symbol in.");
        System.out.println("To place your symbol in the top pane, enter 1");
        System.out.println("After this the game will show you the pane you chose and ask you to enter the number of the field you want to place your symbol in.");
        System.out.println("To place your symbol on a field, enter the number of the field");
        System.out.println("For example, to place your symbol on the top right field, enter 3");
        System.out.println("To place your symbol on the middle left field, enter 4");

        //
        System.out.println("For questions, suggestions or bug reports: ");
        System.out.println("Good luck!");
    }


    public void run() {
        //TODO implement the game logic



    }


    public void clearConsole() {
        System.out.print("\033[H\033[2J");
    }

    public void printPane(int id){

        Pane currentPane = field.getPane(id);

        System.out.println("Current pane: " + id);
        System.out.println(currentPane.field[0][0] + " | " + currentPane.field[0][1] + " | " + currentPane.field[0][2]);
        System.out.println(currentPane.field[1][0] + " | " + currentPane.field[1][1] + " | " + currentPane.field[1][2]);
        System.out.println(currentPane.field[2][0] + " | " + currentPane.field[2][1] + " | " + currentPane.field[2][2]);
    }

    public void getInputByPlayer(Player player) {
        //TODO implement the input method



    }






}