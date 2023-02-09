package models;

import java.util.ArrayList;

public class BoardGame {

    private ArrayList<Case> listCase;
    private int size;
    public BoardGame(int size){
        this.size = size;
        this.listCase = new ArrayList<Case>();

        for(int i = 1; i <= size; i++){
            this.listCase.add(new Case(i));
        }
    }
}

