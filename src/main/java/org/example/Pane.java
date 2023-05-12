package org.example;
import java.util.Scanner;

public class Pane {

    static char[][] field = new char[3][3];
    int id;

    public Pane(int id) {
        this.id = id;

        // initialize field and set all values to ' '
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = ' ';
            }
        }
    }

    public void setSymbolAtPosition(int pane,int x, int y, Player player) {
        if(field[x][y] != ' ') {
            System.out.println("This field is already occupied!");
            return;
        }

        else {
            field[x][y] = Player.symbol;
            this.printPane();
            System.out.println("Symbol set!");

        }
    }

    public void printPane(){
        //print the pane
        System.out.println("Pane " + id+1 + ":");
        System.out.println();
        System.out.println("    |  1  |  2  |  3  |");
        for (int i = 0; i < 3; i++) {
            System.out.println("   ---------------------");
            System.out.println("  " + (i + 1) + " |  " + field[i][0] + "  |  " + field[i][1] + "  |  " + field[i][2] + "  |");
            System.out.println("   ---------------------");
        }
    }

    public void printPaneWithPlaceHolder(int x, int y) {
        //print the pane but with an O at the x, y position
        char[][] fieldCopy = new char[field.length][field[0].length];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j< 3; j++) fieldCopy[i][j] = field[i][j];
        }
            if(fieldCopy[y - 1][x - 1] == ' ') fieldCopy[y - 1][x - 1] = 'O';


            System.out.println("Pane " + (id+1) + ":");
            System.out.println();
            System.out.println("    |  1  |  2  |  3  |");
            for (int i = 0; i < 3; i++) {
                System.out.println("   ---------------------");
                System.out.println("  " + (i + 1) + " |  " + fieldCopy[i][0] + "  |  " + fieldCopy[i][1] + "  |  " + fieldCopy[i][2] + "  |");
                System.out.println("   ---------------------");
            }

        }


}

