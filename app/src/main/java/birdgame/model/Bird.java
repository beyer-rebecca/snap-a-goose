
package birdgame.model;

import birdgame.controller.Entity;
import birdgame.utils.Vec2;

import java.util.Random;

public class Bird extends Entity {
    private static final int MIN_MOVEMENT_TIME = 5;
    private static final int MAX_MOVEMENT_TIME = 20;
    private static final int BIRD_MOVEMENT_LIMIT = 50;
    
    private float birdSpeed = .2f;
    private String birdImage = "goose.png";
    private boolean isAllowedMove = false;
    private float origX;
    private int moveTime;
    private int moveTimeUpdate;
    

    public Bird(float x, float y, int width, int height){
        super(x,y,width,height);
        this.origX = x;
        this.moveTime = new Random().nextInt(MAX_MOVEMENT_TIME - MIN_MOVEMENT_TIME + 1) + MIN_MOVEMENT_TIME;  
        this.moveTimeUpdate = this.moveTime;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public float getOrigX(){
        return this.origX; 
    }

    public int getMoveTime(){
        return this.moveTime;
    }

    public int getMoveTimeUpdate(){  
        return this.moveTimeUpdate;
    }

    public void setMoveTimeUpdate(int newMoveTimeUpdate){  
        this.moveTimeUpdate = newMoveTimeUpdate ;
    }

    public Vec2 getPos(){
        return new Vec2((int)x, (int)y); 
    }

    public void setPosX(float newX){
        // also input parametertype float oder int?
        this.x = (float)newX;
    }

    public boolean getIsMoving(){
        return this.isAllowedMove;
    }

    public int getBIRD_MOVEMENT_LIMIT(){
        return BIRD_MOVEMENT_LIMIT;
    }

    public boolean getIsAllowedMove(){
        // selber output wie ist getIsMOving, sicher dass das beide notwendig sind, vlt nur getIsMoving? dann muss aber auch set (naächste Fkt geändert werden)
        return this.isAllowedMove;
    }

    public void setIsAllowedMove(boolean bool){
        this.isAllowedMove = bool;
    }

    public float getBirdSpeed(){
        return this.birdSpeed;
    }

    public void setBirdSpeed(float newSpeed){
        this.birdSpeed = newSpeed;
    }

    public String getImage(){
        return birdImage;
    }
    
}
