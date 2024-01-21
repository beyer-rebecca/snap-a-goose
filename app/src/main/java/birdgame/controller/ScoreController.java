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

    /**
     * Retrieves the current score.
     *
     * @return The current score as an integer.
     */
    public int getCurrentScore(){
        return score.getCurrentScore();
    }

    /**
     * Sets the current score to a specified integer value.
     *
     * @param newScore The new score to be set.
     */
    public void setCurrentScore(int newScore){
        score.setCurrentScore(newScore);
    }

    /**
     * Increases the current score by a specified number of points.
     *
     * @param points The number of points to add to the current score.
     */
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
