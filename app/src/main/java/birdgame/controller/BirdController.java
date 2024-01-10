package birdgame.controller;

import birdgame.model.Bird;
import birdgame.utils.Vec2;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;


public class BirdController{
    private BirdFlockController birdFlockController;

    public BirdController(BirdFlockController birdFlockController){
        this.birdFlockController = birdFlockController;
    }
 
    public void render(Graphics g){
        for (Bird bird : birdFlockController.getBirds()){
            if(bird.getIsMoving()){
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
        for (Bird bird : birdFlockController.getBirds()){
            if (bird.getMoveTimeUpdate() != 0){
                int moveTimeUpdate = bird.getMoveTimeUpdate();
                bird.setMoveTimeUpdate( moveTimeUpdate--);
            } else{
                bird.setIsAllowedMove(true);
                bird.setMoveTimeUpdate(bird.getMoveTime());
            }
        }
    }


    public void update(){
        for (Bird bird : birdFlockController.getBirds()){
            if(bird.getIsAllowedMove()&& bird.getIsMoving()){ //kam aus game so weiß nicht ob beide bool wichtig
                Vec2 birdPos = bird.getPos();
                float newPosX = birdPos.x + bird.getBirdSpeed(); //wusste nicht ob float oder int
                bird.setPosX(newPosX);

                Vec2 newbirdPos = bird.getPos();
            
                if(bird.getOrigX() + bird.getBIRD_MOVEMENT_LIMIT() <  newbirdPos.x){
                    float newSpeed = bird.getBirdSpeed() * -1;
                    bird.setBirdSpeed(newSpeed);
                }   
                if(bird.getOrigX() - bird.getBIRD_MOVEMENT_LIMIT() > newbirdPos.x){
                    float newSpeed = bird.getBirdSpeed() * -1;
                    bird.setBirdSpeed(newSpeed);
                }
                if(bird.getOrigX() == newbirdPos.x){
                    bird.setIsAllowedMove(false);
                }
            } 
        }
    }
}
