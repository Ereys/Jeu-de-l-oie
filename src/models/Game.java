package models;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> listPlayer;
    private BoardGame board;

    private boolean inProgress;

    public Game(int size){
        this.board = new BoardGame(size);
        this.listPlayer = new ArrayList<Player>();
        this.inProgress = true;
    }

    public void addPlayerToGame(Player p){
        this.listPlayer.add(p);
    }

    public boolean gameInProgress(){
        return this.inProgress;
    }

    public ArrayList<Player> getPlayers(){
        return this.listPlayer;
    }
}
