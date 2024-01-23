package birdgame.controller;

import birdgame.model.Bird;
import birdgame.model.BirdFlock;
import birdgame.model.Game;
import birdgame.utils.Constants;
import birdgame.utils.Vec2;
import birdgame.view.GameOverPanel;
import birdgame.view.LevelPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The GameController class manages controls the game loop and orchestrates the overall game flow. 
 * It manages the interaction between different game components such as the game model, view, 
 * and bird control. Responsible for handling level loading, updating bird movement, 
 * game timing, transitions between game states and rendering.
 */
public class GameController implements Runnable{
    private Thread gameThread;
    private LevelPanel levelPanel;
    private BirdController birdController;
    private BirdFlock birdFlock;
    private WindowController windowController;
    private PlayerController playerController;
    private Game game;
    private int level;

    private Image backgroundImage;
    private Image levelMask;
    
    /**
     * Initializes the GameController with a reference to the WindowController.
     * It sets up the game, bird flock, bird controller, and player controller.
     *
     * @param windowController The controller for managing UI windows.
     */
    public GameController(WindowController windowController){
        
        this.game = new Game();
        this.birdFlock = new BirdFlock();
        this.birdController = new BirdController(this.birdFlock);
        this.playerController = new PlayerController(this.birdFlock);
        this.windowController = windowController;
    }

    /**
     * Starts the game loop running on a separate thread.
     */
    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Retrieves the LevelPanel associated with the current game session.
     *
     * @return The current LevelPanel.
     */
    public LevelPanel getLevelPanel(){
        return levelPanel;
    }

    /**
     * Loads resources for the current level, including background images and bird
     * positions. Initializes the LevelPanel with the loaded resources and configures
     * the bird flock according to the level.
     */
    public void loadLevel(){
        this.level = windowController.getWindowModel().getLevel();
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
        birdController.spawnBirds(level);
        
        levelPanel = new LevelPanel(this.windowController, this, level, 
                this.backgroundImage, this.levelMask, 
                this.birdFlock, this.game, this.playerController);
    }


    
    /** 
     * @param imagePath
     * @param maskPath
     */
    private void loadImages(String imagePath, String maskPath){
        try{
            backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(imagePath));
            levelMask = ImageIO.read(getClass().getClassLoader().getResource(maskPath));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Updates the game state, including bird movements and game timer.
     * Checks if the game time has run out and triggers game completion if necessary.
     */
    public void update(){
        birdController.update();

        if(this.game.getTime() <= 0){
            gameFinished();
        }
    }

    /**
     * Finalizes the game session. This is called when the game timer reaches zero,
     * updating the highscore and transitioning to the GameOverPanel.
     */
    public void gameFinished(){
        gameThread.interrupt();
        HighscoreController.updateHighscore(this.windowController.getWindowModel().getUserName(), this.level, this.playerController.getScoreController().getScoreModel().getCurrentScore());
        this.windowController.getWindowModel().getHighscorePanel().repaint();
        this.windowController.navigateToPanel(new GameOverPanel(this.windowController.getWindowModel(), this.windowController, this.playerController.getScoreController()));
        
    }

    /**
     * Renders the current state of the game on the provided graphics context.
     * This includes drawing birds, background, and other game elements.
     *
     * @param g The Graphics context for drawing.
     */
    public void render(Graphics g){
        birdController.render(g);
        levelPanel.render();
    }

    /**
     * Updates the game timer every second, decreasing the remaining game time.
     */
    public void updateTimer(){
        int newTime = game.getTime() -1; 
        game.setTime(newTime);
    }


    /**
     * Returns the remaining game time.
     *
     * @return The remaining time in the game.
     */
    public int getTime(){
        return game.getTime();
    }

    /**
     * Sets the game time to a specified value.
     *
     * @param time The time value to set.
     */
    public void setTime(int time){
        game.setTime(time);
    }
    
    /**
     * Updates the game state every second. This includes updating the timer and 
     * performing necessary actions that occur on a per-second basis.
     */
    public void updateSec(){
        updateTimer(); 
        birdController.updateSec();
    }


    /**
     * The main game loop that controls update and render cycles, maintaining
     * a consistent frame rate and update rate across different systems.
     */
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

        while(!gameThread.isInterrupted()){
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
