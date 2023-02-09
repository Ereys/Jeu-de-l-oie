package models;
import java.util.ArrayList;
public class Game {
    private ArrayList<Player> listPlayer;
    private BoardGame board;
    private boolean inProgress;
    public Game(int size){
        this.board = new BoardGame(size);
       System.out.println(board.getCaseById(2).getIdCase());
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
        boolean outOfBound = false;
        int comptToDecrease = 0;

        if(p.getCurrentCase() + diceNumber <= board.getSize()){
            p.setCurrentCase(p.getCurrentCase() + diceNumber);
        }else{
            p.setCurrentCase(board.getSize() - ((p.getCurrentCase() + diceNumber) - board.getSize() ));
        }
        board.getCaseById(p.getCurrentCase()).addPlayerInCase(p);
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
