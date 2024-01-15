package birdgame.controller;

import birdgame.model.Bird;

import java.util.Iterator;
import birdgame.utils.Vec2;

import birdgame.model.BirdFlock;

public class PlayerController {

    private ScoreController scoreController;
    private BirdFlock birdFlock;


    public PlayerController(BirdFlock birdFlock){
        this.scoreController = new ScoreController();
        this.birdFlock = birdFlock;
    }

    public ScoreController getScoreController(){
        return this.scoreController;
    }

    
    public void takePhoto(int x, int y){
        Bird birdInPhoto = isBirdInPhoto(x, y);
        if (birdInPhoto != null){
            birdInPhoto.setIsHit(true);
            scoreController.increaseScore(25);
        }
    }

    public boolean isBirdinFrontofMask(int x, int y){
        // hier noch Logik einbauen 
        return true;
    }

    private Bird isBirdInPhoto(int x, int y){
            Iterator<Bird> it = birdFlock.getBirds().iterator();
            while (it.hasNext()) {
                Bird bird = it.next();
                Vec2 birdPos = bird.getPos();
                int birdWidth = bird.getWidth();
                int birdHeight = bird.getHeight();

                // Prüfen, ob der Klick innerhalb der Grenzen von Vogels 
                if (x >= birdPos.x && x <= birdPos.x + birdWidth &&
                    y >= birdPos.y && y <= birdPos.y + birdHeight &&
                    !bird.getIsHit() && bird.getIsAllowedMove()) {
                        return bird;   
                }
            }
            return null;
        }
    }
