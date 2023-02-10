import controllers.GameAuthentificator;
import controllers.GameController;
import models.Game;
import models.Player;
import models.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main class to test the game
 */

public class Main {
    public static void main(String[] args) {

        GameAuthentificator gameAuth = new GameAuthentificator();
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

                if(choice.equals("1")) newUser = gameAuth.login();
                if(choice.equals("2")) newUser = gameAuth.register();
                if(choice.equals("3"))break;
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
       }while(newUser == null);


        // Connecté



      /*  GameController gameController = new GameController();
        gameController.create();

        try {
          //  gameController.addPlayerToGame(p);
          //  gameController.addPlayerToGame(p2);
        }catch (Exception e){
            System.out.println(e);
        }
        gameController.run();
    }*/
    }
}