package birdgame.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bird extends Entity {

    private float birdSpeed = 1f;

    private Image img;

    public Bird(float x, float y, int width, int height){
        super(x,y,height,width);
        
    }

    public Dimension getPos(){
        return new Dimension((int)x, (int)y);
        
    }

    public void render(Graphics g){
        try{
            BufferedImage _img = ImageIO.read(getClass().getClassLoader().getResource("goose.png"));
            img = _img.getScaledInstance(50, 100, Image.SCALE_SMOOTH);
        }catch(Exception e){
            System.out.println(e);
        }
        g.drawImage(img, (int) x,(int) y, null);
        System.out.println("render");
        
    }

    public void update(){
        x += birdSpeed;
        System.out.println("Bird x: " + x);
        
    }
}
