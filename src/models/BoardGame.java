package models;

import java.util.ArrayList;

public class BoardGame {

    private int size;
    private ArrayList<Case> listCase;
    public BoardGame(int size){
        this.size = size;
        this.listCase = new ArrayList<Case>();
        this.boardConstruction(size);
    }

    public int getSize(){
        return this.size;
    }

    public void boardConstruction(int size){
        for(int i = 1; i <= size; i++){
            this.listCase.add(new Case(i));
        }
    }

    /**
     * Method to get the first case of the board
     * @return the first case of the board
     */
    public Case getFirstCase(){
        return this.listCase.get(0);
    }

    /**
     * Method to get a case by an id
     * @param id int: the id of the target case
     * @return the case with the target id
     */
    public Case getCaseById(int id) {
        for(Case c : this.listCase){
            if(c.getIdCase() == id) return c;
        }
        return null;
    }
}

