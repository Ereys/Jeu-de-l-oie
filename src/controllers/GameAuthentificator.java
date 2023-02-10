package controllers;

import exceptions.LoginFailedException;
import exceptions.RegisterFailedException;
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
    public User register() throws RegisterFailedException {
        String lastName;
        String firstName;
        String uniqId;
        String email;
        String password;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("nom : ");
            lastName = br.readLine();
            CheckerRegex.checkStringIsEmpty(lastName);

            System.out.print("prenom : ");
            firstName = br.readLine();
            CheckerRegex.checkStringIsEmpty(firstName);

            System.out.print("email : ");
            email = br.readLine();
            CheckerRegex.isEmail(email);

            System.out.print("mot de passe : ");
            password = br.readLine();
            CheckerRegex.checkStringIsEmpty(password);

            uniqId = String.format("p_%02d", id);
            User user = new User(lastName, firstName, email, password, uniqId);

            this.listUser.addUserToUserList(user);
            this.id += 1;
            System.out.println("Vous êtes enregistré !, votre id est :" + user.getUniqId());
            user.login();
            return user;
        } catch (Exception e) {
            throw new RegisterFailedException(e + " : Une erreur est survenue lors de l'enregistrement, veuillez  ressayer !");
        }
    }

    @Override
    public User login() throws LoginFailedException{

        String id;
        String pwd;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("identifiant : ");
            id = br.readLine();
            System.out.print("mot de passe: ");
            pwd = br.readLine();
            return this.listUser.checkIfUserExist(pwd, id);
        } catch (Exception e) {
            throw new LoginFailedException(e + " : Une erreur est survenue lors de la connexion, veuillez  ressayer !");
        }
    }
    @Override
    public void logout(User user) {
        user.logout();
    }
}
