package birdgame.game;

import java.awt.Dimension;
import java.util.Iterator;

public class PlayerController {

    private Game game;
    private ScoreController scoreController;

    public PlayerController(Game game, ScoreController scoreController){
        this.game = game;
        this.scoreController = scoreController;

    }

    
    public void takePhoto(int x, int y){
        Bird birdInPhoto = isBirdInPhoto(x, y);
        if (birdInPhoto != null){
            game.removeBird(birdInPhoto);
            scoreController.increaseScore(1);
            game.getLevelPanel().repaint();
        }
    }

 private Bird isBirdInPhoto(int x, int y){
        //alle Vögel durchgehen
        Iterator<Bird> it = game.getBirds().iterator();
        while (it.hasNext()) {
            Bird bird = it.next();
            Dimension birdPos = bird.getPos();
            int birdWidth = bird.getWidth();
            int birdHeight = bird.getHeight();

            // Prüfen, ob der Klick innerhalb der Grenzen von Vogels 
            if (x >= birdPos.width && x <= birdPos.width + birdWidth &&
                y >= birdPos.height && y <= birdPos.height + birdHeight) {
                    return bird;   
            }
        }
        return null;
    }
}
