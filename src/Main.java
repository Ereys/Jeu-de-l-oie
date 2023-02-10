import controllers.GameAuthentificator;
import controllers.GameController;
import controllers.Menu;
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

        User user;
        Menu menu = new Menu();
        user = menu.authentificationMenu();
        menu.gameSelectionMenu(user);
    }
}