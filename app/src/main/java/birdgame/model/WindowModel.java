package birdgame.model;

import org.checkerframework.common.returnsreceiver.qual.This;

import birdgame.controller.WindowController;
import birdgame.view.*;

/**
 * The WindowModel class represents the data model for the game's main window.
 * It maintains references to different panels used in the game, along with properties such as the current level and username.
 */
public class WindowModel {
    public static int WINDOW_WIDTH = 1280;
    public static int WINDOW_HEIGHT = 720;

    private MenuPanel menuPanel;
    private LevelSelectPanel levelSelectPanel;
    private LoginPanel loginPanel;
    private HighscorePanel highscorePanel;
    private CreditsPanel creditsPanel;
    private ManualPanel manualPanel;
    private String username;
    private int level;
    
    /**
     * Constructs a WindowModel with references to all main panels used in the game.
     *
     * @param windowController The WindowController that manages the interactions between the view and this model.
     */
    public WindowModel(WindowController windowController){
        this.menuPanel = new MenuPanel(this, windowController);
        this.levelSelectPanel = new LevelSelectPanel(this, windowController);
        this.loginPanel = new LoginPanel(this, windowController);
        this.highscorePanel = new HighscorePanel(this, windowController);
        this.creditsPanel = new CreditsPanel(this, windowController);
        this.manualPanel = new ManualPanel(this, windowController);
    }

    /**
     * Sets the current level of the game.
     *
     * @param level The level number to be set.
     */
    public void setLevel(int level){
        this.level = level;
    }

    /**
     * Retrieves the current level of the game.
     *
     * @return The current level number.
     */
    public int getLevel(){
        return this.level;
    }

    /**
     * Sets the username of the player.
     *
     * @param username The username to be set.
     */
    public void setUserName(String username){
        this.username = username;
    }

    
    /** 
     * @return String
     */
    public String getUserName(){
        return this.username;
    }
    
    
    /** 
     * @return LoginPanel
     */
    public LoginPanel getLoginPanel(){
        return this.loginPanel;
    }

    
    /** 
     * @return MenuPanel
     */
    public MenuPanel getMenuPanel(){
        return this.menuPanel;
    }

    public LevelSelectPanel getLevelSelectPanel(){
        return this.levelSelectPanel;
    }

    public CreditsPanel getCreditsPanel(){
        return this.creditsPanel;
    }

    public HighscorePanel getHighscorePanel(){
        return this.highscorePanel;
    }

    public ManualPanel getManualPanel(){
        return this.manualPanel;
    }
}
