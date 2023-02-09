package controllers;

import models.Game;
import models.Player;

public class GameController implements GameControllerInterface {

    private Game game;

    /**
     * Method to create an instance of a game
     * @param size int size of the board
     */
    public void createGame(int size){
        this.game = new Game(size);
    }

    @Override
    public void run() {
        do{
            update();
        }while(this.game.gameInProgress());
    }

    @Override
    public void update() {
        for(Player p: this.game.getPlayers()){
            game.checkIfWin(p);
        }
    }

    @Override
    public void render() {
        System.out.println("******************************************");
        for(Player p: this.game.getPlayers()){
            System.out.println(p.toString());
        }
        System.out.println("******************************************");
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    /**
     * Only for test
     * @return
     */
    public Game getGame(){
        return this.game;
    }
}
