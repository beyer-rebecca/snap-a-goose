package birdgame.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import birdgame.ui.LevelPanel;
import birdgame.ui.Window;

public class Game implements Runnable{
    private Window window;
    private Thread gameThread;
    private LevelPanel levelPanel;

    private final int FPS_SET = 120;
    private final int UPS_SET = 200;


	public int WINDOW_WIDHT = 1280;
	public int WINDOW_HEIGHT = 720;



    private Image img;
    private Image mask;
    
    public Game(){
        this.window = new Window(this);
        System.out.println("Window: " + this.window);
        try{
            img = ImageIO.read(getClass().getClassLoader().getResource("level1.jpg"));
            mask = ImageIO.read(getClass().getClassLoader().getResource("level1_mask.png"));
        }catch(Exception e){
            
        }
        
    }

    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    //Temp
    public void startGame(){
        levelPanel = new LevelPanel(this, img, mask);
    }

    //Temp
    public LevelPanel getLevelPanel(){
        return levelPanel;
    }

    public void loadLevel(int level, Image background){
        // TODO: write Level Loading
    }

    public void update(){
        for (Bird bird : levelPanel.birds){
            if(bird.isActive)
                bird.update();
        }
    }

    public void render(Graphics g){
        for (Bird bird : levelPanel.birds){
            if(bird.isActive)
                bird.render(g);
        }
    }
    
    public void updateSec(){
        levelPanel.update(); 
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while(true){
            long currentTime = System.nanoTime();


            deltaU += (currentTime - previousTime)/timePerUpdate;
            deltaF += (currentTime - previousTime)/timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }

            if(deltaF >= 1){
                levelPanel.repaint();
                Toolkit.getDefaultToolkit().sync();
                frames++;
                deltaF--;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                updateSec();
                System.out.println("Fps: " + frames + "UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
}
