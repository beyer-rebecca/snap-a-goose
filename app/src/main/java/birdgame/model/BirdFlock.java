package birdgame.model;

import java.util.ArrayList;
import java.util.List;

public class BirdFlock {
    private List<Bird> birds;

    public BirdFlock() {
        this.birds = new ArrayList<Bird>();
    }

    public void addBird(Bird bird) {
        this.birds.add(bird);
    }

    public void removeBird(Bird bird) {
        this.birds.remove(bird);
    }

    public ArrayList<Bird> getBirds() {
        return new ArrayList<Bird>(this.birds);
    }


}
