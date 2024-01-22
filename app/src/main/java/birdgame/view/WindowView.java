package birdgame.view;

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
