package controllers;

import models.Game;
import models.Player;

public class GameController implements GameControllerInterface {

    private Game game;

    public void createGame(int size){
        this.game = new Game(size);
    }
    @Override
    public void update() {

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
}
