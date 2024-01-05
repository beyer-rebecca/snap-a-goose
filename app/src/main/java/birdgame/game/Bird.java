package birdgame.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bird extends Entity {

    private float birdSpeed = 1f;

    private Image img;

    public boolean isActive = true;

    public Bird(float x, float y, int width, int height){
        super(x,y,width,height);
        
    }

    public Dimension getPos(){
        return new Dimension((int)x, (int)y);
        
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

    public void update(){
        // x += birdSpeed;
        // if (x > 1280/2){
        //     isActive = false;
        // }
    }
}
