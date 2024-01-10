package birdgame.controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;

import birdgame.model.Bird;
import birdgame.model.Score;
import birdgame.ui.LevelPanel;
import birdgame.utils.Constants;
import birdgame.utils.Vec2;
import birdgame.model.BirdFlock;

public class Game implements Runnable{
    private Thread gameThread;
    private LevelPanel levelPanel;

    private final int FPS_SET = 120;
    private final int UPS_SET = 200;


	public int WINDOW_WIDHT = 1280;
	public int WINDOW_HEIGHT = 720;

    private Image img;
    private Image mask;

    private BirdController birdController;
    private BirdFlockController birdFlockController;

    private Score score;
    private ScoreController scoreController;
    
    public Game(){

        this.score = new Score();
        this.scoreController = new ScoreController(this.score);
        this.birdFlockController = new BirdFlockController(new BirdFlock());
        this.birdController = new BirdController(birdFlockController);
    }



    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public LevelPanel getLevelPanel(){
        return levelPanel;
    }



    public void loadLevel(int level){
        switch(level){
            case 1:
                try{
                    img = ImageIO.read(getClass().getClassLoader().getResource("level1.jpg"));
                    mask = ImageIO.read(getClass().getClassLoader().getResource("level1_mask.png"));
                }catch(IOException e){
                    System.out.println("loadImages for Level1: " + e);
                }
                break;
            case 2:
                try{
                    img = ImageIO.read(getClass().getClassLoader().getResource("level2.jpg"));
                    mask = ImageIO.read(getClass().getClassLoader().getResource("level2_mask.png"));
                }catch(IOException e){
                    System.out.println("loadImages for Level1: " + e);
                }
                break;
            case 3:
                try{
                    img = ImageIO.read(getClass().getClassLoader().getResource("level3.jpg"));
                    mask = ImageIO.read(getClass().getClassLoader().getResource("level3_mask.png"));
                }catch(IOException e){
                    System.out.println("loadImages for Level1: " + e);
                }
                break;
        }
        spawn(level);
        levelPanel = new LevelPanel(this, level, this.img, this.mask, this.scoreController, this.score);
    }

    public void spawn(int level){
        switch(level){
            case 1:
                for(Vec2 pos : Constants.Level1.birdsPos){
                    birdFlockController.addBird(new Bird(pos.x, pos.y, 20, 40));
                }
                break;
        }
    }
    
    public void update(){
        birdController.update();
    }

    public void render(Graphics g){
        birdController.render(g);
    }
    
    public void updateSec(){
        levelPanel.update(); 
        birdController.updateSec();
    }

    // gameLoop
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
