package org.example;
import java.util.Scanner;

public class Player {

    static char symbol;
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
        if(name.length() < 0){this.name = "Player";}
        else {
            this.name = name;
        }
    }
}

