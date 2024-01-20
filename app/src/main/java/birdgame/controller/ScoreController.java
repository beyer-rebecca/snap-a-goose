package birdgame.controller;

import birdgame.model.Score;

public class ScoreController {
    private Score score;

    public ScoreController(){
        this.score = new Score();
    }

    public int getCurrentScore(){
        return score.getCurrentScore();
    }

    public void setCurrentScore(int newScore){
        score.setCurrentScore(newScore);
    }

    public void increaseScore(int points){
        score.setCurrentScore(score.getCurrentScore() + points);
    }

    public void resetScore(){
        score.setCurrentScore(0);
    }

    public Score getScoreModel(){
        return this.score;
    }
}
