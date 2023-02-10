package models;

public class Player {
    private String uniqId;
    private boolean finished = false;
    private int score;
    private int currentCase;

    private boolean isBot = false;

    public Player(String uniqId, boolean isBot) {
        this.uniqId = uniqId;
        this.isBot = isBot;
        this.score = 0;
    }

    public boolean isBot() {
        return isBot;
    }
    public String getUniqId(){
        return this.uniqId;
    }
    public void setScore(int score){
        this.score = score;
    }


    public void switchFinished(boolean finished){
        this.finished = finished;
    }
    public boolean hasFinished(){
        return this.finished;
    }

    public void setCurrentCase(int currentCase){
        if(currentCase <= 0) this.currentCase = 1;
        else this.currentCase = currentCase;
    }
    public int getCurrentCase(){
        return this.currentCase;
    }

    @Override
    public String toString() {
        return this.uniqId  +  " / score : " + this.score + " / a gagné : " + this.finished +  " / case : " + this.currentCase;
    }
}
