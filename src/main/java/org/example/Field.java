package org.example;

public class Field {

    Pane firstPane = new Pane(0);
    Pane secondPane = new Pane(1);
    Pane thirdPane = new Pane(2);

    Pane[] panes = {firstPane, secondPane, thirdPane};
    public Player winningPlayer = null;


    public Field() {
        System.out.println("Field created!");
    }

    public Pane getPane(int id) throws IllegalArgumentException {
        //get the pane with the given id (0, 1 or 2) and return it (or throw an exception if the id is invalid)
        return switch (id-1) {
            case 0 -> firstPane;
            case 1 -> secondPane;
            case 2 -> thirdPane;
            default -> throw new IllegalArgumentException("Invalid Pane ID!");
        };
    }


    public void printField() {
        //print the field
        Main.clearConsole();

        System.out.println("Field:");
        firstPane.printPane();
        System.out.println();
        secondPane.printPane();
        System.out.println();
        thirdPane.printPane();
    }

    //getter setter
    public Pane[] getPanes() {
        return panes;
    }

    public Player checkWin() {

        //check win in each pane
        for (int i = 0; i < 3; i++) {
            winningPlayer = panes[i].checkWin2D();
            if (winningPlayer != null) {
                return winningPlayer;
            }
        }

        //check win in 3D (3 panes)
        winningPlayer = checkWin3D();


        return winningPlayer;
    }


    public Player checkWin3D() {


        //check z axis (3 panes)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (panes[0].pane[i][j] == panes[1].pane[i][j] && panes[1].pane[i][j] == panes[2].pane[i][j] && panes[0].pane[i][j] != ' ') {
                    if (panes[0].pane[i][j] == Main.player1.symbol) {
                        winningPlayer = Main.player1;
                    } else {
                        winningPlayer = Main.player2;
                    }
                }
            }

        }

        //diagonal in 3D (3 panes) edge to edge
        for (int i = 0; i < 3; i++) {
            //front bottom edge to back top edge
            if (panes[0].pane[i][0] == panes[1].pane[i][1] && panes[1].pane[i][1] == panes[2].pane[i][2] && panes[0].pane[i][0] != ' ') {
                if (panes[0].pane[i][0] == Main.player1.symbol) {
                    winningPlayer = Main.player1;
                } else {
                    winningPlayer = Main.player2;
                }
            }
            //front top edge to back bottom edge
            if (panes[0].pane[i][2] == panes[1].pane[i][1] && panes[1].pane[i][1] == panes[2].pane[i][0] && panes[0].pane[i][2] != ' ') {
                if (panes[0].pane[i][2] == Main.player1.symbol) {
                    winningPlayer = Main.player1;
                } else {
                    winningPlayer = Main.player2;
                }
            }
        }

        // check diagonal in 3D (3 panes) corner to corner
        // front bottom left to back top right corner
        if (panes[0].pane[0][0] == panes[1].pane[1][1] && panes[1].pane[1][1] == panes[2].pane[2][2] && panes[0].pane[0][0] != ' ') {
            if (panes[0].pane[0][0] == Main.player1.symbol) {
                winningPlayer = Main.player1;
            } else {
                winningPlayer = Main.player2;
            }
        }
        //front bottom right corner to back top left corner
        if (panes[0].pane[0][2] == panes[1].pane[1][1] && panes[1].pane[1][1] == panes[2].pane[2][0] && panes[0].pane[0][2] != ' ') {
            if (panes[0].pane[0][2] == Main.player1.symbol) {
                winningPlayer = Main.player1;
            } else {
                winningPlayer = Main.player2;
            }
        }

        //front top left corner to back bottom right corner
        if (panes[0].pane[2][0] == panes[1].pane[1][1] && panes[1].pane[1][1] == panes[2].pane[0][2] && panes[0].pane[2][0] != ' ') {
            if (panes[0].pane[2][0] == Main.player1.symbol) {
                winningPlayer = Main.player1;
            } else {
                winningPlayer = Main.player2;
            }
        }

        //front top right corner to back bottom left corner
        if (panes[0].pane[2][2] == panes[1].pane[1][1] && panes[1].pane[1][1] == panes[2].pane[0][0] && panes[0].pane[2][2] != ' ') {
            if (panes[0].pane[2][2] == Main.player1.symbol) {
                winningPlayer = Main.player1;
            } else {
                winningPlayer = Main.player2;
            }
        }
        return winningPlayer;
    }

    public boolean checkDraw() {
        //check if the game is a draw
        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            draw = panes[i].checkDraw();
        }
        return draw;
    }
}




