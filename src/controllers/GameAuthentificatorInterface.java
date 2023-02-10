package controllers;

import exceptions.LoginFailedException;
import exceptions.RegisterFailedException;
import models.User;

import java.io.IOException;

public interface GameAuthentificatorInterface {


    public User register() throws RegisterFailedException;

    public User login() throws LoginFailedException;

    public void logout(User user);



}
