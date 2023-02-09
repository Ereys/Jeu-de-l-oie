import controllers.GameController;
import models.Game;
import models.Player;

/**
 * Main class to test the game
 */
public class Main {
    public static void main(String[] args) {

        Player p = new Player("Ribollet", "Pierre", "pie jf", "a012");
        Player p2 = new Player("Rib", "Pier", "pie jf", "a2");

        GameController gameController = new GameController();
        gameController.create();

        try {
            gameController.addPlayerToGame(p);
            gameController.addPlayerToGame(p2);
        }catch (Exception e){
            System.out.println(e);
        }
        gameController.run();
    }
}