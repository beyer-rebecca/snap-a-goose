package birdgame.controller;

import birdgame.model.Score;

/**
 * The ScoreController class manages the scoring system for the game. This controller handles operations
 * related to the player's score, such as retrieving, updating, and resetting the score.
 */
public class ScoreController {
    private Score score;

    /**
     * Constructs a ScoreController with a new Score instance.
     */
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

    /**
     * Resets the score to zero.
     */
    public void resetScore(){
        score.setCurrentScore(0);
    }

    /**
     * Retrieves the Score model associated with this controller.
     *
     * @return The Score model.
     */
    public Score getScoreModel(){
        return this.score;
    }
}
