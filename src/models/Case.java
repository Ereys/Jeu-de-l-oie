package models;

import java.util.ArrayList;

public class Case {
    private ArrayList<Player> playerInCase;
    private Case hasNext;
    private int idCase;

    public  Case(int  idCase){
        this.playerInCase = new ArrayList<Player>();
        this.hasNext = null;
    }

    public void setNextCase(Case hasNext) {
        this.hasNext = hasNext;
    }
    public Case getNextCase(){
        return this.hasNext;
    }
    public boolean hasNext(){
        return this.hasNext != null;
    }

    public void addPlayerInCase(Player p){
        this.playerInCase.add(p);
    }
    public void removePlayerInCase(Player p){
        this.playerInCase.remove(p);
    }
    public int getIdCase() {
        return idCase;
    }
}
