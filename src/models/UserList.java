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
}
