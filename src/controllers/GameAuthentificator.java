package controllers;

import models.Player;
import utils.CheckerRegex;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameAuthentificator implements  GameAuthentificatorInterface{

    @Override
    public void register() {
        String lastName;
        String firstName;
        String id;
        String email;
        String password;
        int uniqId = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("lastname");
            lastName = br.readLine();

            System.out.println("firstname");
            firstName = br.readLine();

            System.out.println("email");
            email =  br.readLine();
            CheckerRegex.isEmail(email);

            System.out.println("password");
            password = br.readLine();

            id = String.format("p%02d", uniqId);
            Player player = new Player(lastName, firstName, email, id, password);

        }catch (Exception e){
            System.out.println(e);
        }


        this.listPlayer.add(player);
        this.currentPlayer = player;
        uniqId++;

        // TO DO: Add play method


    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }
}
