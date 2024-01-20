package birdgame.controller;

import birdgame.model.Bird;
import birdgame.model.BirdFlock;

import java.util.Iterator;
import birdgame.utils.Vec2;

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
        Bird birdInPhoto = findBirdInPhoto(x, y);
        if (birdInPhoto != null){
            birdInPhoto.setIsHit(true);
            scoreController.increaseScore(25);
        }
    }

    private Bird findBirdInPhoto(int x, int y){
           Iterator<Bird> birdIterator = birdFlock.getBirds().iterator();
            while (birdIterator.hasNext()) {
                Bird bird = birdIterator.next();
                if (isInPhotoBounds(x, y, bird) && !bird.getIsHit() && bird.getIsAllowedMove()){
                    return bird; 
                }
            }
            return null;
        }

    private boolean isInPhotoBounds(int x, int y, Bird bird) {
        Vec2 birdPos = bird.getPos();
        int birdWidth = bird.getWidth();
        int birdHeight = bird.getHeight();
        return x >= birdPos.x && x <= birdPos.x + birdWidth &&
                y >= birdPos.y && y <= birdPos.y + birdHeight;
    }
}

    


