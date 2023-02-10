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

    /**
     * Method to add a player to the game
     * @param p player
     */
    public void addPlayerToGame(Player p){
        p.setCurrentCase(1);
        this.listPlayer.add(p);
    }

    /**
     * Method to know if the game is on progress
     * @return boolean true if the game is on progress
     */
    public boolean gameInProgress(){
        return this.inProgress;
    }

    /**
     * Use this method to switch the state of the game
     * @param status true : inProgress, false : paused
     */
    public void switchGameStatus(boolean status){
        this.inProgress = status;
    }

    /**
     * Method to move a player in the board
     * @param p player
     * @param diceNumber a number between [1-6]
     */
    public void movePlayer(Player p, int diceNumber){
        p.setScore(diceNumber);
        boolean outOfBound = false;
        int comptToDecrease = 0;
        board.getCaseById(p.getCurrentCase()).removePlayerFromCase(p);
        if(p.getCurrentCase() + diceNumber <= board.getSize()){
            p.setCurrentCase(p.getCurrentCase() + diceNumber);
        }else{
            p.setCurrentCase(board.getSize() - ((p.getCurrentCase() + diceNumber) - board.getSize() ));
        }
        board.getCaseById(p.getCurrentCase()).addPlayerInCase(p);
    }

    /**
     * Method to check if a player is on the last case of the board
     * @param p Player
     */
    public void checkIfWin(Player p){
        if(p.getCurrentCase() == board.getSize()){
            p.switchFinished(true);
        }else {
            p.switchFinished(false);
        }
    }

    /**
     * Method to check if all players has win the game
     * @return
     */

    public boolean checkEndGame(){
        int compteur = 0;
        for(Player p : listPlayer){
            if(p.hasFinished()) compteur++;
        }

        if(compteur == listPlayer.size()) return true;
        else return false;
    }

    /**
     * Method to get the list of the players in the game
     * @return ArrayList<Player> List of the players in the game
     */
    public ArrayList<Player> getPlayers(){
        return this.listPlayer;
    }

    public void displayAllPlayersInformation(){
        for (Player p: this.listPlayer) {
            System.out.println(p.toString() + "/ " + this.board.getSize());
        }
    }
}
