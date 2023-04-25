package org.example;

public class Pane {

    char[][] field = new char[3][3];
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

}
