package controllers;

import models.Player;
import models.User;
import models.UserList;
import utils.CheckerRegex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class GameAuthentificator implements  GameAuthentificatorInterface {

    private UserList listUser;
    private int id = 1;

    public GameAuthentificator() {
        this.listUser = new UserList();
    }

    @Override
    public User register() {
        String lastName;
        String firstName;
        String uniqId;
        String email;
        String password;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("lastname : ");
            lastName = br.readLine();

            System.out.print("firstname : ");
            firstName = br.readLine();

            System.out.print("email : ");
            email = br.readLine();
            CheckerRegex.isEmail(email);

            System.out.print("password : ");
            password = br.readLine();

            uniqId = String.format("p_%02d", id);
            User user = new User(lastName, firstName, email, password, uniqId);

            this.listUser.addUserToUserList(user);
            this.id += 1;
            System.out.println("Vous êtes enregistré !, votre id est :" + user.getUniqId());
            user.login();
            return user;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Une erreur est survenue lors de l'enregistrement, veuillez  ressayer !");
            return null;
        }
    }

    @Override
    public User login() {

        String id;
        String pwd;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Please enter your username : ");
            id = br.readLine();
            System.out.print("Please type your password : ");
            pwd = br.readLine();
            return this.listUser.checkIfUserExist(pwd, id);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Une erreur est survenue lors de la connexion, veuillez ressayer");
            return null;
        }
    }
    @Override
    public void logout(User user) {
        user.logout();
    }
}
