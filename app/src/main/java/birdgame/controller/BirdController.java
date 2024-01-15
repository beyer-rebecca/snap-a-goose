package birdgame.controller;

import birdgame.model.Bird;
import birdgame.utils.Vec2;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import birdgame.model.BirdFlock;

public class BirdController{
    private BirdFlock birdFlock;

    public BirdController(BirdFlock birdFlock){
        this.birdFlock = birdFlock;
    }
 
    public void render(Graphics g){
        for (Bird bird : birdFlock.getBirds()){
            if(bird.getIsMoving() && !bird.getIsHit()){
                try {
                    String birdImage = bird.getImage();
                    BufferedImage _img = ImageIO.read(getClass().getClassLoader().getResource(birdImage));
                    Image img = _img.getScaledInstance(bird.getWidth(), bird.getHeight(), Image.SCALE_SMOOTH);
                    Vec2 birdPos = bird.getPos();
                    g.drawImage(img, birdPos.x, birdPos.y, null);
                } catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public void updateSec() {
        for (Bird bird : birdFlock.getBirds()){
            if (bird.getMoveTimeUpdate() != 0){
                bird.setMoveTimeUpdate(bird.getMoveTimeUpdate()-1);
            } else{
                bird.setIsAllowedMove(true);
                bird.setMoveTimeUpdate(bird.getMoveTime());
            }
        }
    }

    public void update(){
        for (Bird bird : birdFlock.getBirds()){
            if(bird.getIsAllowedMove()){
                bird.setPosX(bird.getPosX() + bird.getBirdSpeed());

            
                if(bird.getOrigX() + bird.getBIRD_MOVEMENT_LIMIT() <  bird.getPosX()){
                    float newSpeed = bird.getBirdSpeed() * -1;
                    bird.setBirdSpeed(newSpeed);
                }   
                if(bird.getOrigX() - bird.getBIRD_MOVEMENT_LIMIT() > bird.getPosX()){
                    float newSpeed = bird.getBirdSpeed() * -1;
                    bird.setBirdSpeed(newSpeed);
                }
                if(bird.getOrigX() == bird.getPosX()){
                    bird.setIsAllowedMove(false);
                }
            } 
        }
    }
}
