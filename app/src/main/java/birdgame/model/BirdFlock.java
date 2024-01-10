package birdgame.model;

import java.util.ArrayList;
import java.util.List;

public class BirdFlock {
    private List<Bird> birds;

    public BirdFlock() {
        this.birds = new ArrayList<>();
    }

    public void addBird(Bird bird) {
        birds.add(bird);
    }

    public void removeBird(Bird bird) {
        birds.remove(bird);
    }

    public ArrayList<Bird> getBirds() {
        return new ArrayList<>(birds);
    }


}
