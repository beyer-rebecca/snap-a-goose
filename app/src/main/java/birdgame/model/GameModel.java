package birdgame.model;

/**
 * The Game class represents the overall state of the "Snap a Bird" Game.  It includes settings for game rendering, 
 * the game timer, and level-specific resources such as background images and masks.
 * (The masks (representing elements like trees) are in other classes placed in front of the backgrounds,
 * allowing birds to hide behind them.)
 */
public class GameModel {
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    private final int MAX_TIME = 60;

    private final String level1Image = "level1.jpg";
    private final String level1Mask ="level1_mask.png";
    private final String level2Image="level2.jpg";
    private final String level2Mask= "level2_mask.png";
    private final String level3Image="level3.jpg";
    private final String level3Mask ="level3_mask.png";

    private int time; // Current game time

    /**
     * Constructs a new Game object with the maximum time set.
     */
    public GameModel(){
        this.time = MAX_TIME;
    }

    /**
     * Retrieves the current game time.
     * The game time counts down from MAX_TIME to 0 during gameplay.
     *
     * @return The current game time in seconds.
     */
    public int getTime(){
        return this.time;
    }

    /**
     * Sets the current game time.
     * This can be used to update the countdown timer during gameplay.
     *
     * @param newTime The new game time in seconds.
     */
    public void setTime(int newTime){
        this.time = newTime;
    }

    /**
     * Resets the game time to the maximum time (MAX_TIME).
     * This can be used to restart the game.
     */
    public void resetTime(){
        this.time = MAX_TIME;
    }

    /**
     * Retrieves the image path for level 1 background image.
     * 
     * @return The file path of level 1's image.
     */
    public String getLevel1Image() {
        return level1Image;
    }

     /**
     * Retrieves the mask path for level 1.
     * The mask represents elements (like trees) in the level where birds can hide.
     * 
     * @return The file path of level 1's mask.
     */
    public String getLevel1Mask() {
        return level1Mask;
    }

    
    /**
     * Retrieves the image path for level 2.
     * 
     * @return The file path of level 2's image.
     */
    public String getLevel2Image() {
        return level2Image;
    }

    /**
     * Retrieves the mask path for level 2.
     * 
     * @return The file path of level 2's mask.
     */
    public String getLevel2Mask() {
        return level2Mask;
    }

    /**
     * Retrieves the image path for level 3.
     * 
     * @return The file path of level 3's image.
     */
    public String getLevel3Image() {
        return level3Image;
    }

    /**
     * Retrieves the mask path for level 3.
     * 
     * @return The file path of level 3's mask.
     */
    public String getLevel3Mask() {
        return level3Mask;
    }
}
