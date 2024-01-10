package birdgame.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import birdgame.game.Game;

import birdgame.utils.Constants;

public class Window extends JFrame{


    private MenuPanel menu = new MenuPanel(this);
    private LevelSelectPanel levelSelect = new LevelSelectPanel(this);
    public LoginPanel login = new LoginPanel(this);
    public HighscorePanel highscorePanel = new HighscorePanel(this);
    public CreditsPanel creditsPanel = new CreditsPanel(this);
    // public InstructionsPanel instructionsPanel = new InstructionsPanel();
    
    public Window(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Constants.Window.WINDOW_WIDHT, Constants.Window.WINDOW_HEIGHT);
        setResizable(false);
        setTitle("Bird Game");
        setContentPane(menu);
        

        // needs to be last
        setVisible(true);
    }

    public void navTo(JPanel panel){
        this.setContentPane(panel);
        this.repaint();
        this.revalidate();
    }


    public MenuPanel getMenuPanel(){
        return this.menu;
    }
    public LevelSelectPanel getLevelSelectPanel(){
        return this.levelSelect;
    }

    public CreditsPanel getCreditsPanel(){
        return this.creditsPanel;
    }

    public HighscorePanel getHighscorePanel(){
        return this.highscorePanel;
    }
}
