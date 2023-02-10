package controllers;

import com.sun.jdi.ClassNotLoadedException;
import models.Game;
import models.Player;

public class GameController implements GameControllerInterface {

    private Game game;

    /**
     *
     * @param p
     */
    public void addPlayerToGame(Player p) throws ClassNotLoadedException{
        if(this.game != null) this.game.addPlayerToGame(p);
        else throw new ClassNotLoadedException("Create a game instance");
    }

    @Override
    public void create() {
        int size=0;
        //On demande la taille du plateau de jeu
        this.game = new Game(size);
    }


    @Override
    public void run() {
        do{
            for(Player player : game.getPlayers()){ // Chacun son tour
                if(player.hasFinished()){
                    continue;
                }

                // on demande :
                //  1. Lancé le dé ( utiliser la méthode static throwDice(), et utiliser la classe Game pour déplacer  ),
                //  2. Afficher son score( utiliser la méthode render() ) , Q
                //  3. Quitter le jeu (break);


            }
            update();
        }while(this.game.gameInProgress());
    }


    /**
     * Update data for the game
     */
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
