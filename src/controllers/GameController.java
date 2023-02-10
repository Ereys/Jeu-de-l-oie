package controllers;

import com.sun.jdi.ClassNotLoadedException;
import exceptions.GameNotFoundException;
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
    public void create(int size) {
        //On demande la taille du plateau de jeu
        this.game = new Game(size);
    }


    @Override
    public void run() {
        while(this.game.gameInProgress()){
            for(Player player : game.getPlayers()){ // Chacun son tour
                if(player.hasFinished()){
                    continue;
                }

                System.out.println("Je suis ici !");
                // Bufferedreader : 1 2 3

                // Tu teste si c'est 1 2 ou 3
                //

                // on demande : switch ou if
                //  1. Lancé le dé ( utiliser la méthode static throwDice(), et utiliser la classe Game pour déplacer  ),
                //  2. Afficher son score( utiliser la méthode render() ) , Q
                //  3. Quitter le jeu (break);
            }
            update();
        }
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
        this.game.displayAllPlayersInformation();
        System.out.println("******************************************");
    }

    @Override
    public void pause() throws GameNotFoundException{
        if(this.game == null) throw new GameNotFoundException("Veuillez creer une partie");
        this.game.switchGameStatus(false);
    }

    @Override
    public void resume() throws GameNotFoundException {
        if(this.game == null) throw new GameNotFoundException("Veuillez creer une partie");
        System.out.println("Votre partie va reprendre !");
        this.game.switchGameStatus(true);
        this.run();
    }

    /**
     * Only for test
     * @return
     */
    public Game getGame(){
        return this.game;
    }

}
