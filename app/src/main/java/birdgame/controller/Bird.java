package birdgame.controller;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

import birdgame.utils.Vec2;

public class Bird extends Entity {

    private float birdSpeed = .2f;

    private Image img;

    private boolean isAllowedMove = false;

    private float origX;

    private int moveTime;

    private int moveTimeUpdate;

    public Bird(float x, float y, int width, int height){
        super(x,y,width,height);
        this.origX = x;
        this.moveTime =  new Random().nextInt(20-5+1)+5;
        this.moveTimeUpdate = this.moveTime;
        
    }

    public Vec2 getPos(){
        return new Vec2((int)x, (int)y);
        
    }

    public void render(Graphics g){
        try{
            BufferedImage _img = ImageIO.read(getClass().getClassLoader().getResource("goose.png"));
            img = _img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        }catch(Exception e){
            System.out.println(e);
        }
        g.drawImage(img, (int) x,(int) y, null);
        
    }

    public void updateSec(){
        if(moveTimeUpdate != 0){
            moveTimeUpdate --;
        }else{
            isAllowedMove = true;
            moveTimeUpdate = moveTime;
        }
    }

    public boolean getIsMoving(){
        return isAllowedMove;
    }

    public void update(){

        if(isAllowedMove){
            x += birdSpeed;
            
            if(origX + 50 < x){
                birdSpeed *= -1;
            }
            if(origX - 50 > x){
                birdSpeed *= -1;
            }
            if(origX == x){
                isAllowedMove = false;
            }
        }
        
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }


}
