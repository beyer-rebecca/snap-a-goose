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
     * Retrieves the username of the player.
     *
     * @return The player's username.
     */
    public String getUserName(){
        return this.username;
    }
    
    /**
     * Retrieves the LoginPanel instance.
     * This panel is used for user authentication processes.
     *
     * @return The LoginPanel instance.
     */
    public LoginPanel getLoginPanel(){
        return this.loginPanel;
    }

    /**
     * Retrieves the MenuPanel instance.
     * This panel displays the main menu options of the game.
     *
     * @return The MenuPanel instance.
     */
    public MenuPanel getMenuPanel(){
        return this.menuPanel;
    }

    /**
     * Retrieves the LevelSelectPanel instance.
     * This panel allows players to select the level they wish to play.
     *
     * @return The LevelSelectPanel instance.
     */
    public LevelSelectPanel getLevelSelectPanel(){
        return this.levelSelectPanel;
    }

    /**
     * Retrieves the CreditsPanel instance.
     * This panel displays the credits and acknowledgements for the game.
     *
     * @return The CreditsPanel instance.
     */
    public CreditsPanel getCreditsPanel(){
        return this.creditsPanel;
    }

    /**
     * Retrieves the HighscorePanel instance.
     * This panel displays the high scores achieved by the player.
     *
     * @return The HighscorePanel instance.
     */
    public HighscorePanel getHighscorePanel(){
        return this.highscorePanel;
    }

    /**
     * Retrieves the ManualPanel instance.
     * This panel provides instructions and information about how to play the game.
     *
     * @return The ManualPanel instance.
     */
    public ManualPanel getManualPanel(){
        return this.manualPanel;
    }
}
