package org.example;

public class Field {

    Pane firstPane = new Pane(0);
    Pane secondPane = new Pane(1);
    Pane thirdPane = new Pane(2);

    Pane[] panes = {firstPane, secondPane, thirdPane};


    public Field() {
        System.out.println("Field created!");

    }

    public Pane getPane(int id) {
        switch (id) {
            case 0:
                return firstPane;
            case 1:
                return secondPane;
            case 2:
                return thirdPane;
            default:
                return null;
        }
    }

    public Pane[] getPanes(){
        return panes;
    }


}
