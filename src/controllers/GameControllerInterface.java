package controllers;

public interface GameControllerInterface {


    /**
     * Method to create initialize value
     */
    public void create();

    /**
     * Method to run a game
     */
    public void run();

    /**
     * Method to update game data
     */
    public void update ();

    /**
     * Method to update the render of the game
     */
    public void render ();

    /**
     * Method to pause a game
     */
    public void pause ();

    /**
     * Method to resume a game
     */
    public void resume ();
}
