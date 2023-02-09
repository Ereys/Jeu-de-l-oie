package models;

import java.util.ArrayList;

public class Case {
    private ArrayList<Player> playerInCase;
    private int idCase;

    public  Case(int idCase){
        this.idCase = idCase;
        this.playerInCase = new ArrayList<Player>();
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
