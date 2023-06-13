package org.haloiok.TicTacToe3D;

public class Player {

    public char symbol;
    String name;



    public Player(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }


    public void setName(String name){
        if (name.length() == 0) {
            this.name = "Player";
        } else {
            this.name = name;
        }
    }
}

