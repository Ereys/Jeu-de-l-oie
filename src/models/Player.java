package models;

public class Player {
    private String uniqId;
    private boolean finished = false;
    private int score;
    private int currentCase;

    public Player(String uniqId) {
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
        return this.uniqId  +  " / score : " + this.score + " / case : " + this.currentCase;
    }
}
