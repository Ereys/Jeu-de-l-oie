package controllers;

import models.User;

public interface GameAuthentificatorInterface {


    public User register();

    public User login();

    public void logout(User user);



}
