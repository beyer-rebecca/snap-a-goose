package birdgame.game;

import java.awt.Toolkit;

import birdgame.ui.Window;

public class Game implements Runnable{
    private Window window;
    private Thread gameThread;

    private final int FPS_SET = 120;
    private final int UPS_SET = 200;


	public int WINDOW_WIDHT = 1280;
	public int WINDOW_HEIGHT = 720;
    
    public Game(){
        this.window = new Window(this);
        
    }

    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update(){
        // TODO add GameObject update functions
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
                // gamePanel.repaint();
                Toolkit.getDefaultToolkit().sync();
                frames++;
                deltaF--;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("Fps: " + frames + "UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
}
