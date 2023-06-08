package org.example;


public class Pane {

    // Eigenschaften
    public char[][] pane = new char[3][3];
    int id;

    //constructor
    public Pane(int id) {
        this.id = id;

        // initialize field and set all values to ' '
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pane[i][j] = ' ';
            }
        }
    }

    public void setSymbolAtPosition(int x, int y, Player player) {
        pane[x - 1][y - 1] = player.symbol;
        this.printPane();
        System.out.println("Symbol set!");
    }

    public char getSymbolAtPosition(int x, int y) {
        return pane[x - 1][y - 1];
    }

    public void printPane() {
        //print the pane
        System.out.println("Pane " + (id + 1) + ":");
        System.out.println();
        System.out.println("    |  1  |  2  |  3  |");
        for (int i = 0; i < 3; i++) {
            System.out.println("   ---------------------");
            System.out.println("  " + (i + 1) + " |  " + pane[i][0] + "  |  " + pane[i][1] + "  |  " + pane[i][2] + "  |");
            System.out.println("   ---------------------");
        }
    }

    public void printPaneWithPlaceHolder(int x, int y) {
        //print the pane but with an O at the x, y position
        char[][] copyOfCurrentPane = new char[pane.length][pane[0].length];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) copyOfCurrentPane[i][j] = pane[i][j];
        }
        if (copyOfCurrentPane[y - 1][x - 1] == ' ') copyOfCurrentPane[y - 1][x - 1] = '?';
        else System.out.println("This field is already occupied!");


        System.out.println("Pane " + (id + 1) + ":");
        System.out.println();
        System.out.println("    |  1  |  2  |  3  |");
        for (int i = 0; i < 3; i++) {
            System.out.println("   ---------------------");
            System.out.println("  " + (i + 1) + " |  " + copyOfCurrentPane[i][0] + "  |  " + copyOfCurrentPane[i][1] + "  |  " + copyOfCurrentPane[i][2] + "  |");
            System.out.println("   ---------------------");
        }

    }

    //check for win in Tic Tac Toe field
    public Player checkWin2D() {
        //check for win in rows
        for (int i = 0; i < 3; i++) {
            if (pane[i][0] == pane[i][1] && pane[i][1] == pane[i][2] && pane[i][0] != ' ') {
                if (pane[i][0] == Main.player1.symbol) return Main.player1;
                else return Main.player2;
            }
        }

        //check for wins in columns
        for (int i = 0; i < 3; i++) {
            if (pane[0][i] == pane[1][i] && pane[1][i] == pane[2][i] && pane[0][i] != ' ') {
                if (pane[0][i] == Main.player1.symbol) return Main.player1;
                else return Main.player2;
            }
        }

        // check for wins in diagonal
        if (pane[0][0] == pane[1][1] && pane[1][1] == pane[2][2] && pane[0][0] != ' ') {
            if (pane[0][0] == Main.player1.symbol) return Main.player1;
            else return Main.player2;
        }

        // check for wins in diagonal
        if (pane[0][2] == pane[1][1] && pane[1][1] == pane[2][0] && pane[0][2] != ' ') {
            if (pane[0][2] == Main.player1.symbol) return Main.player1;
            else return Main.player2;
        }

        return null;
    }


    public boolean checkDraw() {
        //check if there is a draw
        boolean draw = true;
        for (char[] chars : pane) {
            for (int j = 0; j < pane[0].length; j++) {
                if (chars[j] == ' ') {
                    draw = false;
                    break;
                }
            }
        }
        return draw;

    }

}