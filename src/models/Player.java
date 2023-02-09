package models;

public class Player {
    private String lastName;
    private String firstName;
    private String email;
    private String uniqId;

    private boolean finished = false;
    private int score;
    private int currentCase;

    public Player(String lastName, String firstName, String email, String uniqId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.uniqId = uniqId;

        this.score = 0;
    }
    public void incrScore(){
        this.score++;
    }

    public String getUniqId(){
        return this.uniqId;
    }

    public void switchFinished(){
        this.finished = !finished;
    }

    public boolean hasFinished(){
        return this.finished;
    }
    public void setCurrentCase(int currentCase){
        this.currentCase = currentCase;
    }
    public int getCurrentCase(){
        return this.currentCase;
    }
    @Override
    public String toString() {
        return this.uniqId + " / case : " + this.currentCase +  " / score : " + this.score;
    }
}
