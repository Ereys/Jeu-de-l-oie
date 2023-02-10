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

        User newUser = null;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        do{
            


        }while(newUser == null);

        GameAuthentificator gameAuth = new GameAuthentificator();
        newUser = gameAuth.register();
        gameAuth.logout(newUser);
        newUser = gameAuth.login();




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