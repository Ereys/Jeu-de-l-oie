package utils;

public class CheckerRegex {
    public static boolean isEmail(String email){
        String regex = "^[A-Za-z0-9+_._]+@[A-Za-z0-9+_._]+[.][fr,com]+$";
        if(email.matches(regex)) return true;
        throw new IllegalArgumentException("Doit être un email");
    }
    public static boolean choiceNumber(String choice){
        String regex = "[1-3]";
        if(choice.matches(regex)) return true;
        throw new IllegalArgumentException("Veuillez choisir entre 1 2 et 3");
    }

    public static boolean checkStringIsEmpty(String str){
        String regex = "^[A-Za-z0-9]{2,}";
        if(str.matches(regex)) return true;
        throw new IllegalArgumentException("Veuillez choisir une entrée supérieur à 2 caractères");
    }

}
