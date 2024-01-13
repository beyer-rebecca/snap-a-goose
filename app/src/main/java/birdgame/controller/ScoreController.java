package birdgame.controller;

import birdgame.model.Score;

public class ScoreController {
    private Score score;

    public ScoreController(Score score){
        this.score = score;
    }

    public int getCurrentScore(){
        return score.getCurrentScore();
    }

    public void setCurrentScore(int newScore){
        score.setCurrentScore(newScore);
    }


    public void increaseScore(int points){
        int newScore = score.getCurrentScore() + points;
        score.setCurrentScore(newScore);
    }

    public void resetScore(){
        score.setCurrentScore(0);
    }
}
