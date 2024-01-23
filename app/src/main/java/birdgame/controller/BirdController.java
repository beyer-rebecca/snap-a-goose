package birdgame.controller;

import birdgame.model.Bird;
import birdgame.utils.Constants;
import birdgame.utils.Vec2;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import birdgame.model.BirdFlock;

/**
 * The BirdController class is responsible for managing the rendering and updating
 * of birds within the game. It handles bird movements, animations, and interactions.
 */
public class BirdController{
    private BirdFlock birdFlock;

    /**
     * Constructs a new BirdController with a specified BirdFlock.
     *
     * @param birdFlock The flock of birds that this controller manages.
     */
    public BirdController(BirdFlock birdFlock){
        this.birdFlock = birdFlock;
    }
 
    /**
     * Renders all birds in the bird flock on the provided graphics context.
     * This method handles displaying different bird images based on their state (moving or hit).
     *
     * @param g The Graphics context on which to render the birds.
     */
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
            if(bird.getIsMoving() && bird.getIsHit()){
                try {
                    String birdImage = bird.getImageHit();
                    BufferedImage _img = ImageIO.read(getClass().getClassLoader().getResource(birdImage));
                    Image img = _img.getScaledInstance(bird.getHitWidth(), bird.getHitHeight(), Image.SCALE_SMOOTH);
                    Vec2 birdPos = bird.getPos();
                    g.drawImage(img, birdPos.x, birdPos.y, null);
                } catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }


    /**
     * Updates the state of each bird per second. This method is responsible for
     * managing the movement timers of the birds.
     */
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

     /**
     * Updates the position and state of each bird in the flock. This method handles the movement logic of birds,
     * adjusting their positions based on their speed and movement limits within the game environment.
     *
     * Key functionalities include:
     * - If a bird is allowed to move, its position is updated based on its current speed.
     * - When the bird has reached the movement limits set by the game environment its speed is reversed, and it changes direction
     * - The method also checks if the bird is within the bounds of its designated tree area.
     *    If the bird is outside these bounds, it is allowed to move until it re-enters the area.
     *    Once inside, the bird's movement is restricted, and it stays within the tree bounds
     */
    public void update(){
        for (Bird bird : birdFlock.getBirds()){
            if(bird.getIsAllowedMove()){
                bird.setPosX(bird.getPosX() + bird.getBirdSpeed());

            
                if(bird.getTreeRight() + bird.getBIRD_MOVEMENT_LIMIT() <  bird.getPosX()){
                    float newSpeed = bird.getBirdSpeed() * -1;
                    bird.setBirdSpeed(newSpeed);
                    bird.setBirdIsOutOfTree(false);
                }   
                if(bird.getTreeLeft() - bird.getBIRD_MOVEMENT_LIMIT() > bird.getPosX()){
                    float newSpeed = bird.getBirdSpeed() * -1;
                    bird.setBirdSpeed(newSpeed);
                    bird.setBirdIsOutOfTree(false);
                }
                if(!bird.getBirdIsOutOfTree() && (bird.getPosX() > bird.getTreeLeft() && 
                        bird.getPosX() + bird.getHitWidth() <
                        bird.getTreeRight() || bird.getPosX() > bird.getTreeLeft() &&
                        bird.getPosX() + bird.getWidth() < bird.getTreeRight())){
                    bird.setIsAllowedMove(false);
                    bird.setIsHit(false);
                    bird.setBirdIsOutOfTree(true);
                }
            } 
        }
    }

    /**
     * Spawns birds based on the specified level. This method determines the initial
     * positions and configurations of birds for different levels.
     *
     * @param level The game level for which birds need to be spawned.
     */
    public void spawnBirds(int level){
        switch(level){
            case 1:
                for(Vec2 vec : Constants.Level1.birdsPos){
                    birdFlock.addBird(new Bird(vec.left.x, vec.left.y, vec.right.x, vec.right.y));
                }
                break;
            case 2:
                for(Vec2 vec : Constants.Level2.birdsPos){
                    birdFlock.addBird(new Bird(vec.left.x, vec.left.y, vec.right.x, vec.right.y));
                }
                break;
            case 3:
                for(Vec2 vec : Constants.Level3.birdsPos){
                    birdFlock.addBird(new Bird(vec.left.x, vec.left.y, vec.right.x, vec.right.y));
                }
                break;
        }
    }
}
