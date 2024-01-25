
package birdgame.model;

import birdgame.utils.Vec2;

import java.util.Random;

/**
 * The Bird class represents a bird in the Bird Game. This class encapsulates the properties and behaviors
 * of a bird, such as its position, movement, and state (hit or not).
 */
public class BirdModel {
    private static final int MIN_MOVEMENT_TIME = 5;
    private static final int MAX_MOVEMENT_TIME = 20;
    private static final int BIRD_MOVEMENT_LIMIT = 50;
    private static final String BIRD_IMAGE = "goose.png";
    private static final String BIRD_IMAGE_HIT = "gooseHit.png";
    
    private float birdSpeed = .2f;
    private boolean isAllowedMove = false;
    private boolean isHit = false;
    private float origX;
    private int moveTime;
    private int moveTimeUpdate;
    private int width = 20;
    private int height = 40;
    private int hitWidth = 45;
    private int hitHeight = 30;
    private float posX;
    private float posY;
    private int treeLeft, treeRight;
    private boolean birdIsOutOfTree = true;


    /**
     * Constructs a Bird object with initial position and tree boundaries.
     *
     * @param posX Initial x-coordinate of the bird.
     * @param posY Initial y-coordinate of the bird.
     * @param treeLeft The x-coordinate of the left boundary of the tree.
     * @param treeRight The x-coordinate of the right boundary of the tree.
     */
    public BirdModel(float posX, float posY, int treeLeft, int treeRight){
        this.origX = posX;
        this.posX = posX;
        this.posY = posY;
        this.treeLeft = treeLeft;
        this.treeRight = treeRight;
        
        this.moveTime = new Random().nextInt(MAX_MOVEMENT_TIME - MIN_MOVEMENT_TIME + 1) + MIN_MOVEMENT_TIME;  
        this.moveTimeUpdate = this.moveTime;
    }


    /**
     * Checks if the bird is not hidden behind a tree.
     * @return true if the bird is out of the tree, false otherwise.
     */
    public boolean getBirdIsOutOfTree(){
        return this.birdIsOutOfTree;
    }

     /**
     * Sets the bird's out-of-tree status.
     * @param bool New out-of-tree status.
     */
    public void setBirdIsOutOfTree(boolean bool){
        this.birdIsOutOfTree = bool;
    }

    /**
     * Retrieves the x-coordinate of the left boundary of the tree.
     * 
     * @return The x-coordinate of the left boundary.
     */
    public int getTreeLeft(){
        return this.treeLeft;
    }

    /**
     * Retrieves the x-coordinate of the right boundary of the tree.
     * 
     * @return The x-coordinate of the right boundary.
     */
    public int getTreeRight(){
        return this.treeRight;
    }

    /**
     * Retrieves the width of the hitted bird.
     * 
     * @return The width of the hitted bird.
     */
    public int getHitWidth(){
        return this.hitWidth;
    }

    /**
     * Retrieves the height of the hitted bird.
     * 
     * @return The height of the hitted bird.
     */
    public int getHitHeight(){
        return this.hitHeight;
    }

    /**
     * Retrieves the width of the bird.
     * 
     * @return The width of the bird.
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * Retrieves the height of the bird.
     * 
     * @return The height of the bird.
     */
    public int getHeight(){
        return this.height;
    }

    /**
     * Retrieves the original x-coordinate of the bird.
     * 
     * @return The original x-coordinate.
     */
    public float getOrigX(){
        return this.origX; 
    }

    /**
     * Retrieves the total wait time before the bird is allowed to move again.
     * This is the initial movement cooldown period for the bird.
     *
     * @return The total wait time for bird movement.
     */
    public int getMoveTime(){
        return this.moveTime;
    }

    /**
     * Retrieves the remaining wait time before the bird can move again.
     * This value decreases over time until the bird is allowed to move.
     *
     * @return The current remaining wait time for bird movement.
     */
    public int getMoveTimeUpdate(){  
        return this.moveTimeUpdate;
    }

    /**
     * Sets the current remaining wait time before the bird can move again.
     * This method is used to decrement the movement cooldown timer.
     *
     * @param newMoveTimeUpdate The new remaining wait time to be set.
     */
    public void setMoveTimeUpdate(int newMoveTimeUpdate){  
        this.moveTimeUpdate = newMoveTimeUpdate ;
    }

    /**
     * Retrieves the bird's current position as a Vec2 object.
     *
     * @return The current position of the bird.
     */
    public Vec2 getPos(){
        return new Vec2((int) posX, (int) posY);
    }

    /**
     * Retrieves the current x-coordinate of the bird.
     * @return The current x-coordinate.
     */
    public float getPosX(){
        return this.posX;
    }

    /**
     * Sets the bird's current x-coordinate.
     * @param newPosX The new x-coordinate.
     */
    public void setPosX(float newPosX){
        this.posX = newPosX;
    }

    /**
     * Checks if the bird is moving.
     * @return true if the bird is allowed to move, false otherwise.
     */
    public boolean getIsMoving(){
        return this.isAllowedMove;
    }

    /**
     * Retrieves the movement limit of the bird.
     * @return The maximum distance the bird can move from its original position.
     */
    public int getBIRD_MOVEMENT_LIMIT(){
        return BIRD_MOVEMENT_LIMIT;
    }

    /**
     * Checks if the bird is allowed to move.
     * @return true if the bird is allowed to move, false otherwise.
     */
    public boolean getIsAllowedMove(){
        return this.isAllowedMove;
    }

    /**
     * Sets the bird's movement allowance status.
     * @param bool New movement allowance status.
     */
    public void setIsAllowedMove(boolean bool){
        this.isAllowedMove = bool;
    }

    /**
     * Retrieves the bird's speed.
     * @return The current speed of the bird.
     */
    public float getBirdSpeed(){
        return this.birdSpeed;
    }

     /**
     * Sets the speed of the bird.
     * @param newSpeed The new speed to be set for the bird.
     */
    public void setBirdSpeed(float newSpeed){
        this.birdSpeed = newSpeed;
    }

    /**
     * Retrieves the image path of the bird.
     * @return The file path of the bird's image.
     */
    public String getImage(){
        return BIRD_IMAGE;
    }

    /**
     * Retrieves the image path of the image with the bird when it was hit.
     * @return The file path of the bird's image when the bird was hit.
     */
    public String getImageHit(){
        return BIRD_IMAGE_HIT;
    }

     /**
     * Sets the hit status of the bird (if it was hit).
     * @param isHit The new hit status to be set, true when it was hit, false when it was not hit.
     */
    public void setIsHit(boolean isHit){
        this.isHit = isHit;
    }
    
    /**
     * Checks if the bird has been hit.
     *
     * @return true if the bird has been hit, false otherwise.
     */
    public boolean getIsHit(){
        return this.isHit;
    }
    
}
