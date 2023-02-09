import controllers.GameController;
import models.Game;
import models.Player;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.createGame(10);

        Player p = new Player("Ribollet", "Pierre", "pie jf", "a012");
        gameController.getGame().addPlayerToGame(p);

    }
}