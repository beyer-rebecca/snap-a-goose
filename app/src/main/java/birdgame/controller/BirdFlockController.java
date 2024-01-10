package birdgame.controller;

import birdgame.model.Bird;
import birdgame.model.BirdFlock;

import java.util.ArrayList;

public class BirdFlockController {
    private BirdFlock birdFlock;

    public BirdFlockController(BirdFlock birdFlock) {
        this.birdFlock = birdFlock;
    }

    public void addBird(Bird bird) {
        birdFlock.addBird(bird);
    }

    public void removeBird(Bird bird) {
        birdFlock.removeBird(bird);
    }

    public ArrayList<Bird> getBirds() {
        return birdFlock.getBirds();
    }
}