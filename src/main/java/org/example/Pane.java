package org.example;
import java.util.Scanner;

public class Pane {

    char[][] field = new char[3][3];
    int id;

    static Scanner scanner = new Scanner(System.in);

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
        if(pane != id) {
            System.out.println("This is not the pane you are looking for!");
            return;
        }

        else if(field[x][y] != ' ') {
            System.out.println("This field is already occupied!");
            return;
        }

        else {

            System.out.println("Symbol set!");

        }
    }



}
