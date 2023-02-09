package models;

import java.util.ArrayList;

public class Case {
    private ArrayList<Player> playerInCase;
    private int idCase;

    public  Case(int idCase){
        this.idCase = idCase;
        this.playerInCase = new ArrayList<Player>();
    }

    /**
     * Add a player in the case
     * @param p Player
     */
    public void addPlayerInCase(Player p){
        this.playerInCase.add(p);
    }

    /**
     * Remove a player from a case
     * @param p Player
     */
    public void removePlayerFromCase(Player p){
        this.playerInCase.remove(p);
    }

    /**
     * Get the id of the case
     * @return the id of the case
     */
    public int getIdCase() {
        return idCase;
    }
}
