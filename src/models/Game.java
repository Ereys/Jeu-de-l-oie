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
        p.setCurrentCase(1);
        this.listPlayer.add(p);
    }
    public boolean gameInProgress(){
        return this.inProgress;
    }

    public void movePlayer(Player p, int diceNumber){
        p.incrScore();

        for(int i = 0; i < diceNumber; i++){
            if(board.getCaseById(p.getCurrentCase()).hasNext()){
                p.setCurrentCase(board.getCaseById(i).getIdCase());
            }else{ // On est a la fin

            }
        }
    }

    public void checkIfWin(Player p){
        if(p.getCurrentCase() == board.getSize()){
            p.switchFinished();
        }
    }
    public ArrayList<Player> getPlayers(){
        return this.listPlayer;
    }
}
