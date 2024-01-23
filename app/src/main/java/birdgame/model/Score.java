package birdgame.model;

/**
 * The Score class represents the player's score in the Bird Game.
 * It manages the current score and provides methods to retrieve and update it.
 */
public class Score {
    private int currentScore = 0;

    /**
     * Retrieves the current score of the player.
     *
     * @return The current score.
     */
    public int getCurrentScore(){
        return currentScore;
    }

    /**
     * Sets the current score of the player.
     * This method is used to update the player's score.
     *
     * @param score The new score to be set.
     */
    public void setCurrentScore(int score){
        this.currentScore = score;
    }
}
