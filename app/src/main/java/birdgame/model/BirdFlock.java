package birdgame.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The BirdFlock class represents a collection of Bird objects.
 * It allows for the addition, removal, and retrieval of birds within the game.
 */
public class BirdFlock {
    private List<Bird> birds = new ArrayList<Bird>();

    /**
     * Adds a bird to the flock.
     * 
     * @param bird The Bird object to be added to the flock.
     */
    public void addBird(Bird bird) {
        this.birds.add(bird);
    }

    /**
     * Removes a bird from the flock.
     * 
     * @param bird The Bird object to be removed from the flock.
     */
    public void removeBird(Bird bird) {
        this.birds.remove(bird);
    }

    /**
     * Retrieves a list of all birds in the flock.
     * 
     * @return An ArrayList containing all the Bird objects in the flock.
     */
    public ArrayList<Bird> getBirds() {
        return new ArrayList<Bird>(this.birds);
    }


}
