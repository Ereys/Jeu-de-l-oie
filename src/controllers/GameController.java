package controllers;

import models.Game;
import models.Player;

public class GameController implements GameControllerInterface {

    private Game game;

    public void createGame(int size){
        this.game = new Game(size);
    }

    public void run(){

        do{
            update();
            render();
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
        for(Player p: this.game.getPlayers()){
            System.out.println(p.toString());
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    public Game getGame(){
        return this.game;
    }
}
