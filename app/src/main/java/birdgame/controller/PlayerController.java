package birdgame.controller;

import birdgame.model.Bird;

import java.util.Iterator;
import birdgame.utils.Vec2;


public class PlayerController {

    private ScoreController scoreController;
    private BirdFlockController birdFlockController;


    public PlayerController(ScoreController scoreController, BirdFlockController birdFlockController){
        this.scoreController = scoreController;
        this.birdFlockController = birdFlockController;
    }

    
    public void takePhoto(int x, int y){
        Bird birdInPhoto = isBirdInPhoto(x, y);
        if (birdInPhoto != null){
            birdFlockController.removeBird(birdInPhoto);
            scoreController.increaseScore(1);
        }
    }

    public boolean isBirdinFrontofMask(int x, int y){
        // hier noch Logik einbauen 
        return true;
    }

    private Bird isBirdInPhoto(int x, int y){
            Iterator<Bird> it = birdFlockController.getBirds().iterator();
            while (it.hasNext()) {
                Bird bird = it.next();
                Vec2 birdPos = bird.getPos();
                int birdWidth = bird.getWidth();
                int birdHeight = bird.getHeight();

                // Prüfen, ob der Klick innerhalb der Grenzen von Vogels 
                if (x >= birdPos.x && x <= birdPos.x + birdWidth &&
                    y >= birdPos.y && y <= birdPos.y + birdHeight &&
                    bird.getIsAllowedMove()) {
                        return bird;   
                }
            }
            return null;
        }
    }
