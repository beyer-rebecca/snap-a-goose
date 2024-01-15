package birdgame.controller;

import birdgame.model.Bird;
import birdgame.model.Score;
import birdgame.model.BirdFlock;
import birdgame.model.Game;
import birdgame.ui.LevelPanel;
import birdgame.utils.Constants;
import birdgame.utils.Vec2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.imageio.ImageIO;

// class manages the game loop
public class GameController implements Runnable{
    private Thread gameThread;
    private LevelPanel levelPanel;
    private BirdController birdController;
    private BirdFlock birdFlock;
    private WindowController windowController;
    private Score score;
    private ScoreController scoreController;
    private Game game;

    private Image backgroundImage;
    private Image levelMask;
    
    public GameController(WindowController windowController, Game game){
        this.game = game;
        this.score = new Score();
        this.scoreController = new ScoreController(this.score);
        this.birdFlock = new BirdFlock();
        this.birdController = new BirdController(this.birdFlock);
        this.windowController = windowController;
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
                loadImages(game.getLevel1Image(),game.getLevel1Mask());
                break;
            case 2:
                loadImages(game.getLevel2Image(),game.getLevel2Mask());
                break;
            case 3:
                loadImages(game.getLevel3Image(),game.getLevel3Mask());
                break;
        }
        spawnBirds(level);
        levelPanel = new LevelPanel(this.windowController, this, level, 
                this.backgroundImage, this.levelMask, this.scoreController, 
                this.birdFlock, this.score, this.game);
    }

    private void loadImages(String imagePath, String maskPath){
        try{
            backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(imagePath));
            levelMask = ImageIO.read(getClass().getClassLoader().getResource(maskPath));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void spawnBirds(int level){
        switch(level){
            case 1:
                for(Vec2 pos : Constants.Level1.birdsPos){
                    birdFlock.addBird(new Bird(pos.x, pos.y, Constants.Level1.BIRD_WIDTH, Constants.Level1.BIRD_HEIGHT));
                }
                break;
        }
    }
    
    public void update(){
        birdController.update();
    }

    public void render(Graphics g){
        birdController.render(g);
        levelPanel.render();
    }

    public void updateTimer(){
        int newTime = game.getTime() -1; 
        game.setTime(newTime);
    }

    public int getTime(){
        return game.getTime();
    }

    public void setTime(int time){
        game.setTime(time);
    }
    
    public void updateSec(){
        updateTimer(); 
        birdController.updateSec();
    }


    // gameLoop
    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / game.getFPS_SET();
        double timePerUpdate = 1000000000.0 / game.getUPS_SET();

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
