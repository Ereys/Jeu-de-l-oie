package controllers;

import utils.CheckerRegex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameMenu {

    public String hasFinishedMenu() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        System.out.println("-------------------------------------------------------------");
        System.out.println("1. Continuer a regarder");
        System.out.println("2. Quitter la partie");
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.print("Votre choix : ");
        choice = buffer.readLine();

        CheckerRegex.choiceNumber(choice);
        return choice;
    }

    public String inGameMenu() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        System.out.println("-------------------------------------------------------------");
        System.out.println("1. Jette le dé");
        System.out.println("2. Montrer le score");
        System.out.println("3. Quitter la partie (pause)");
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.print("Votre choix : ");
        choice = buffer.readLine();
        CheckerRegex.choiceNumber(choice);

        return choice;

    }



}
