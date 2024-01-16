package birdgame.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import birdgame.controller.WindowController;


public class WindowView extends JFrame{
    private WindowController windowController;
    
    private MenuPanel menuPanel;
    private LevelSelectPanel levelSelectPanel;
    private LoginPanel loginPanel;
    private HighscorePanel highscorePanel;
    private CreditsPanel creditsPanel;
    private GameOverPanel gameOverPanel;

    private JPanel currentPanel;

    public WindowView(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bird Game");
        
        // needs to be last
        setVisible(true);
    }

    
    // public void setController(WindowController windowController) {
        // needs to be called after initializing the Class
        
        // menuPanel = new MenuPanel(this, windowController);
        // levelSelectPanel = new LevelSelectPanel(this, windowController);
        // loginPanel = new LoginPanel(this, windowController);
        // highscorePanel = new HighscorePanel(this, windowController);
        // creditsPanel = new CreditsPanel(this, windowController);
        // this.windowController = windowController;
        // setSize(windowController.getWINDOW_WIDHT(), windowController.getWINDOW_HEIGHT());  //windowView soll auf bestimmtes windowModel object zugreife nicht alggemein
        // setPanel(loginPanel);
    // }

    public void setPanel(JPanel panel){
        this.currentPanel = panel;
        setContentPane(currentPanel);
        repaint();
        revalidate();
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

    public GameOverPanel getgameOverPanel(){
        return this.gameOverPanel;
    }

}
