package birdgame.controller;

import birdgame.model.Bird;
import birdgame.model.BirdFlock;

import java.util.Iterator;
import birdgame.utils.Vec2;

/**
 * The PlayerController class manages player interactions within the game.
 * It is responsible for handling player actions such as taking photos of birds and
 * managing the player's score based on these interactions.
 */
public class PlayerController {
    private ScoreController scoreController;
    private BirdFlock birdFlock;

    /**
     * Constructs a PlayerController with a reference to a BirdFlock. Initializes a ScoreController
     * to manage the player's score during the game.
     *
     * @param birdFlock The BirdFlock instance that the controller will interact with.
     */
    public PlayerController(BirdFlock birdFlock){
        this.scoreController = new ScoreController();
        this.birdFlock = birdFlock;
    }

    /**
     * Retrieves the ScoreController instance associated with this player.
     *
     * @return The ScoreController managing the player's score.
     */
    public ScoreController getScoreController(){
        return this.scoreController;
    }

    /**
     * Processes a 'take photo' action at the specified coordinates. Captures a photo at the
     * location of the mouse click. If a bird is present in the photo area, it is marked as hit
     * and the player's score is increased.
     *
     * @param posX The x-coordinate of the mouse click where the photo is taken.
     * @param posY The y-coordinate of the mouse click where the photo is taken.
     */
    public void takePhoto(int posX, int posY){
        Bird birdInPhoto = findBirdInPhoto(posX, posY);
        if (birdInPhoto != null){
            birdInPhoto.setIsHit(true);
            scoreController.increaseScore(25);
        }
    }

    /**
     * Searches for a bird within the photo bounds based on the given coordinates.
     *
     * @param posX The x-coordinate of the photo.
     * @param posY The y-coordinate of the photo.
     * @return The Bird object if found within the bounds; null otherwise.
     */
    private Bird findBirdInPhoto(int posX, int posY){
           Iterator<Bird> birdIterator = birdFlock.getBirds().iterator();
            while (birdIterator.hasNext()) {
                Bird bird = birdIterator.next();
                if (isInPhotoBounds(posX, posY, bird) && !bird.getIsHit() && bird.getIsAllowedMove()){
                    return bird; 
                }
            }
            return null;
        }

    /**
     * Checks if the given coordinates are within the bounds of a specified bird.
     *
     * @param x The x-coordinate to check against the bird's position.
     * @param y The y-coordinate to check against the bird's position.
     * @param bird The Bird object to check the coordinates against.
     * @return true if the coordinates are within the bird's bounds; false otherwise.
     */
    private boolean isInPhotoBounds(int x, int y, Bird bird) {
        Vec2 birdPos = bird.getPos();
        int birdWidth = bird.getWidth();
        int birdHeight = bird.getHeight();
        return x >= birdPos.x && x <= birdPos.x + birdWidth &&
                y >= birdPos.y && y <= birdPos.y + birdHeight;
    }
}

    


