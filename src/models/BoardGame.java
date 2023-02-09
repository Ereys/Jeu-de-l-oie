package models;

import java.util.ArrayList;

public class BoardGame {

    private Case firstCase;
    private int size;
    public BoardGame(int size){
        this.size = size;
        this.firstCase = new Case(1);
        for(int i = 1; i <= size; i++){
        }
    }

    public int getSize(){
        return this.size;
    }

    public void boardConstruction(int size){
        Case current = firstCase;
        for(int i = 1; i <= size; i++){
            current.setNextCase(new Case(i));
            current = current.getNextCase();
        }
    }

    /**
     * Method to get the first case of the board
     * @return the first case of the board
     */
    public Case getFirstCase(){
        return this.firstCase;
    }

    /**
     * Method to get a case by an id
     * @param id int: the id of the target case
     * @return the case with the target id
     */
    public Case getCaseById(int id) {
        Case target = firstCase;
        while (target.getIdCase() != id && target.hasNext()) {
            target = target.getNextCase();
        }
        return target;
    }
}

