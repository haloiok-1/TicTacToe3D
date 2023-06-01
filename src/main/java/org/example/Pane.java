package org.example;


public class Pane {

    public char[][] pane = new char[3][3];
    int id;

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


}

