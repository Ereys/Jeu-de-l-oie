package controllers;

import exceptions.GameNotFoundException;
import models.Game;
import models.Player;
import utils.Dice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameController implements GameControllerInterface {

    private Game game = null;
    private GameMenu menu;

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
        this.menu = new GameMenu();
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
        boolean quit = false;

        while(this.game.gameInProgress() && !quit){
            for(Player player : game.getPlayers()) {
                if (player.hasFinished() && !player.isBot()) {
                    choice = this.menu.hasFinishedMenu();
                    switch(choice){
                        case "1": {
                            player.switchFinished(true);
                            render();
                            break;
                        }
                        case "2": {
                            quit = true;
                        }
                    }
                }else{
                    try {
                        if(!player.isBot()){
                           choice = menu.inGameMenu();
                           switch(choice){
                               case "1": {
                                   this.game.movePlayer(player, Dice.rollDice());
                                   System.out.println(player);
                                   break;
                               }
                               case "2": {
                                   render();
                                   break;
                               }
                               case "3": {
                                   this.pause();
                                   break;
                               }
                           }
                        }else if(player.isBot() && !player.hasFinished()) this.game.movePlayer(player, Dice.rollDice());
                        } catch (Exception e) {
                            System.out.println(e);
                    }
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
        if(this.game.checkEndGame()){
            this.game.switchGameStatus(false);
            System.out.println("Tous le monde a fini la partie");
            System.out.println();
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
        System.out.println();
        this.game.switchGameStatus(true);
    }

}
