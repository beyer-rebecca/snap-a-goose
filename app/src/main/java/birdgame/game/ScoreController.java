package birdgame.game;

import birdgame.model.Score;

public class ScoreController {
    private Score score;

    public ScoreController(Score score){
        this.score = score;
    }

    
    public void increaseScore(int points){
        int newScore = score.getCurrentScore() + points;
        score.setCurrentScore(newScore);
    }

    public void resetScore(){
        score.setCurrentScore(0);
    }
}