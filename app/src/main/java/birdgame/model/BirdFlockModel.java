package birdgame.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The BirdFlock class represents a collection of Bird objects.
 * It allows for the addition, removal, and retrieval of birds within the game.
 */
public class BirdFlockModel {
    private List<BirdModel> birds = new ArrayList<BirdModel>();

    /**
     * Adds a bird to the flock.
     * 
     * @param bird The Bird object to be added to the flock.
     */
    public void addBird(BirdModel bird) {
        this.birds.add(bird);
    }

    /**
     * Removes a bird from the flock.
     * 
     * @param bird The Bird object to be removed from the flock.
     */
    public void removeBird(BirdModel bird) {
        this.birds.remove(bird);
    }

    /**
     * Retrieves a list of all birds in the flock.
     * 
     * @return An ArrayList containing all the Bird objects in the flock.
     */
    public ArrayList<BirdModel> getBirds() {
        return new ArrayList<BirdModel>(this.birds);
    }


}
