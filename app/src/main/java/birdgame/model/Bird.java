
package birdgame.model;

import birdgame.utils.Vec2;

import java.util.Random;

public class Bird extends Entity {
    private static final int MIN_MOVEMENT_TIME = 5;
    private static final int MAX_MOVEMENT_TIME = 20;
    private static final int BIRD_MOVEMENT_LIMIT = 50;
    
    private float birdSpeed = .2f;
    private String birdImage = "goose.png";
    private boolean isAllowedMove = false;
    private boolean isHit = false;
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
        return new Vec2((int) x, (int) y);
    }

    public float getPosX(){
        return this.x;
    }

    public void setPosX(float newX){
        this.x = newX;
    }

    public boolean getIsMoving(){
        return this.isAllowedMove;
    }

    public int getBIRD_MOVEMENT_LIMIT(){
        return BIRD_MOVEMENT_LIMIT;
    }

    public boolean getIsAllowedMove(){
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

    public void setIsHit(Boolean isHit){
        this.isHit = isHit;
    }
    
    public boolean getIsHit(){
        return this.isHit;
    }
    
}
