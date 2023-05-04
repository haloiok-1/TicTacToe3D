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
        switch (id) {
            case 1:
                return firstPane;
            case 2:
                return secondPane;
            case 3:
                return thirdPane;
            default:
                throw new IllegalArgumentException("Invalid Pane ID!");
        }
    }

    public Pane[] getPanes(){
        return panes;
    }


}
