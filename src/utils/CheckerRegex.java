package utils;

public class CheckerRegex {
    public static boolean isEmail(String email){
        String regex = "^[A-Za-z0-9+_._]+@[A-Za-z0-9+_._]+[.][fr,com]+$";
        if(email.matches(regex)) return true;
        throw new IllegalArgumentException("Must be an email");
    }
    public static boolean choiceNumber(String choice){
        String regex = "[1-3]";
        if(choice.matches(regex)) return true;
        throw new IllegalArgumentException("Your choice must be one of the numbers  1, 2 or 3");
    }
}
