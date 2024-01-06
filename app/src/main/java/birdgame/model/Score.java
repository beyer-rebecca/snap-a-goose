package birdgame.model;

public class Score {
    private int currentScore;

    public Score(){
        this.currentScore = 0;
    }

    public int getCurrentScore(){
        return currentScore;
    }

    public void setCurrentScore(int score){
        this.currentScore = score;
    }

}
