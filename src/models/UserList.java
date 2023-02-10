package models;

import java.util.ArrayList;


/**
 * Class to represent user who are authentified
 */
public class UserList {

    private ArrayList<User> userList;

    public UserList(){
        this.userList = new ArrayList<User>();
    }
    public ArrayList<User> getUserList(){

        return userList;

    }
    public void addUserToUserList(User user){
        this.userList.add(user);
    }

    public User checkIfUserExist(String pwd, String uniqid){
        for(User user : this.userList){
            if(user.checkIfRightUser(pwd, uniqid)){
                System.out.println("Bienvenue ! " + user.getUniqId());
                user.login();
                return user;
            }
        }
        System.out.println();
        System.out.println("Votre compte n'existe pas, veuillez vous enregistrer !");
        System.out.println();
        return null;
    }
}
