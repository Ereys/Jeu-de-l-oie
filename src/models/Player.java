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
    public void setScore(int score){
        this.score = score;
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
