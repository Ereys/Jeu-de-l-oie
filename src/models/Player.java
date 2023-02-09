package models;

public class Player {
    private String lastName;
    private String firstName;
    private String email;
    private String uniqId;
    private int score;
    private Case currentCase;

    public Player(String lastName, String firstName, String email, String uniqId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.uniqId = uniqId;
    }
    public void moveTo(int moveNumber) {

    }
    @Override
    public String toString() {
        return this.uniqId + this.currentCase + this.score;
    }
}
