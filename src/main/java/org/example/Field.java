package org.example;

public class Field {

    Pane firstPane = new Pane(0);
    Pane secondPane = new Pane(1);
    Pane thirdPane = new Pane(2);

    Pane[] panes = {firstPane, secondPane, thirdPane};


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
}
