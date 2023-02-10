package utils;

public class Dice {


    /**
     * Method which represent a throw of a dice
     * @return int between [1-6]
     */
    public static int rollDice() {
        int min = 1;
        int max = 6;
        int randomDice = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return randomDice;
    }




}
