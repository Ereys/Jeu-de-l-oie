package models;

public class User {
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String uniqId;

    private boolean isLogin;

    public User(String lastName, String firstName, String email, String password, String uniqId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.uniqId = uniqId;

        this.isLogin = false;
    }
    public boolean checkIfRightUser(String pwd, String uniqId){
        if(pwd.equals(password) && uniqId.equals(uniqId))return true;
        return false;
    }
    public String getUniqId() {
        return uniqId;
    }

    public boolean isLogin(){
        return this.isLogin;
    }
    public void login(){
        this.isLogin = true;
    }

    public void logout(){
        this.isLogin = false;
    }
}
