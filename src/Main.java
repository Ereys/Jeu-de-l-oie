import controllers.GameController;
import models.Game;
import models.Player;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.createGame(15);

        Player p = new Player("Ribollet", "Pierre", "pie jf", "a012");
        Player p2 = new Player("Rib", "Pier", "pie jf", "a2");
        gameController.getGame().addPlayerToGame(p);
        gameController.getGame().addPlayerToGame(p2);

        gameController.getGame().movePlayer(p,17);

        gameController.render();

    }
}