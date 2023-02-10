package controllers;

import models.Player;
import models.User;
import utils.CheckerRegex;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {

    private GameAuthentificator gameAuth;
    private GameController game;

    public Menu(){
        this.gameAuth = new GameAuthentificator();
    }

    public void authentificationMenu(){

        User newUser = null;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";

        do{
            try {
                System.out.flush();
                System.out.println("-------------------------------------------------------------");
                System.out.println("------------------ Authentification -------------------------");
                System.out.println("-------------------------------------------------------------");
                System.out.println("1. Se connecter");
                System.out.println("2. S'enregistrer");
                System.out.println("3. Quitter");
                System.out.println();
                System.out.print("Votre choix : ");
                choice = buffer.readLine();
                CheckerRegex.choiceNumber(choice);

                if(choice.equals("1")){
                    newUser = gameAuth.login();
                    if(newUser != null) gameSelectionMenu(newUser);
                }
                if(choice.equals("2")) {
                    newUser = gameAuth.register();
                    gameSelectionMenu(newUser);
                }
                if(choice.equals("3")) break;
            }catch (Exception exception){
                System.out.println("*************************************");
                System.out.println(exception.getMessage());
                System.out.println("*************************************");
            }
        }while(newUser == null);
    }

    public void gameSelectionMenu(User user){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        int size = 15;
        boolean quit = false;

        do {
            try {
                System.out.flush();
                System.out.println("---------------------------------------------------------");
                System.out.println("------------------ Jeu de l'oie -------------------------");
                System.out.println("---------------------------------------------------------");
                System.out.println("1. Créer une partie");
                System.out.println("2. Rejoindre une partie");
                System.out.println("3. Se déconnecter");
                System.out.println();
                System.out.print("Votre choix : ");

                choice = buffer.readLine();
                CheckerRegex.choiceNumber(choice);

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
                    this.game.run();
                }
                if (choice.equals("3")){
                    quit = true;
                }
            } catch (Exception e) {
                System.out.println("-------------------------------------------");
                System.out.println(e.getMessage());
                System.out.println("-------------------------------------------");
            }
        }while(!quit);
        user.logout();
        this.authentificationMenu();
    }
}
