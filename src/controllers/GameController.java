package controllers;

import com.sun.jdi.ClassNotLoadedException;
import exceptions.GameNotFoundException;
import models.Game;
import models.Player;
import utils.CheckerRegex;
import utils.Dice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameController implements GameControllerInterface {

    private Game game = null;

    /**
     *
     * @param p
     */
    public void addPlayerToGame(Player p) throws GameNotFoundException{
        if(this.game == null) throw new GameNotFoundException("Veuillez creer une partie");
        this.game.addPlayerToGame(p);
    }

    @Override
    public void create(int size) {
        //On demande la taille du plateau de jeu
        this.game = new Game(size);
    }

    @Override
    public void destroy() throws GameNotFoundException {
        if(this.game == null) throw new GameNotFoundException("Vous ne pouvez pas détruire une partie qui n'existe pas");
        this.game = null;
    }

    @Override
    public void run() throws Exception{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";

        while(this.game.gameInProgress()){

            for(Player player : game.getPlayers()) { // Chacun son tour
                if (player.hasFinished()) {
                    System.out.println("1. Continuer a regarder");
                    System.out.println("2. Quitter la partie");
                    System.out.print("Votre choix : ");

                    choice = buffer.readLine();
                    CheckerRegex.choiceNumber(choice);
                    if(choice.equals(1))continue;
                    if(choice.equals(2)){
                        this.game.switchGameStatus(false);
                        break;
                    }
                }
                try {
                    System.out.println("1. Jette le dé");
                    System.out.println("2. Montrer le score");
                    System.out.println("3. Quitter la partie (pause)");

                    System.out.print("Votre choix : ");
                    choice = buffer.readLine();
                    CheckerRegex.choiceNumber(choice);

                    if (choice.equals("1")) {
                        this.game.movePlayer(player, Dice.rollDice());
                    }
                    if (choice.equals("2")) {
                        render();
                    }
                    if (choice.equals("3")) {
                        this.pause();
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
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
    }

    /**
     * Only for test
     * @return
     */
    public Game getGame(){
        return this.game;
    }

}
