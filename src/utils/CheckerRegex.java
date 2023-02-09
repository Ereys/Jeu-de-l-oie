package utils;

public class CheckerRegex {
    public static boolean isEmail(String email){
        String regex = "^[A-Za-z0-9+_._]+@(.+)$";
        if(email.matches(regex)) return true;
        throw new IllegalArgumentException("Must be an email");
    }
    
}
