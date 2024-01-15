package birdgame.model;

import birdgame.ui.MenuPanel;
import birdgame.controller.WindowController;
import birdgame.ui.*;


public class WindowModel {
    public static int WINDOW_WIDHT = 1280;
    public static int WINDOW_HEIGHT = 720;

    private MenuPanel menuPanel;
    private LevelSelectPanel levelSelectPanel;
    private LoginPanel loginPanel;
    private HighscorePanel highscorePanel;
    private CreditsPanel creditsPanel;
    
    public WindowModel(WindowController windowController){
        this.menuPanel = new MenuPanel(this, windowController);
        this.levelSelectPanel = new LevelSelectPanel(this, windowController);
        this.loginPanel = new LoginPanel(this, windowController);
        this.highscorePanel = new HighscorePanel(this, windowController);
        this.creditsPanel = new CreditsPanel(this, windowController);
    }

    public int getWINDOW_WIDHT(){
        return WINDOW_WIDHT;
    }

    public int getWINDOW_HEIGHT(){
        return WINDOW_HEIGHT;
    }
    
    public LoginPanel getLoginPanel(){
        return this.loginPanel;
    }

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
}
