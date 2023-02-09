package controllers;

import models.Game;

public class GameController implements GameControllerInterface {

    Game game;

    public void createGame(int size){
        this.game = new Game(size);
    }
    @Override
    public void update() {

    }

    @Override
    public void render() {
        public void displayAllPlayer(){
            for(Player p: this.game.getPlayers()){
                System.out.println();
            }
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
