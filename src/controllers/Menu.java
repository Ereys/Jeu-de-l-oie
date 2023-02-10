package controllers;

import models.Player;
import models.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {

    private GameAuthentificator gameAuth;
    private GameController game;

    public Menu(){
        this.gameAuth = new GameAuthentificator();
    }

    public User authentificationMenu(){

        User newUser = null;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";

        do{
            try {
                System.out.println("1. Se connecter");
                System.out.println("2. S'enregistrer");
                System.out.println("3. Quitter");

                System.out.print("Votre choix : ");
                choice = buffer.readLine();

                if(choice.equals("1")){
                    newUser = gameAuth.login();
                    return newUser;
                }
                if(choice.equals("2")) {
                    newUser = gameAuth.register();
                    return newUser;
                }
                if(choice.equals("3")) break;
            }catch (Exception exception){
                System.err.println(exception);
            }
        }while(newUser == null);
        return null;
    }

    public void gameSelectionMenu(User user){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        int size = 15;
        boolean quit = false;

        do {
            try {
                System.out.println("1. Créer une partie");
                System.out.println("2. Rejoindre une partie");
                System.out.println("3. Se déconnecter");
                System.out.print("Votre choix : ");
                choice = buffer.readLine();

                if (choice.equals("1")) {
                    this.game = new GameController();
                    System.out.print("Taille du plateau de jeu : ");
                    size =Integer.parseInt(buffer.readLine());
                    this.game.create(size);
                    this.game.addPlayerToGame(new Player(user.getUniqId()));
                    this.game.run();
                }
                if (choice.equals("2")){
                    this.game.resume();
                }
                if (choice.equals("3")){
                    quit = true;
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }while(!quit);
        user.logout();
    }
}
