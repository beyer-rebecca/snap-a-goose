package birdgame.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import birdgame.game.Game;

public class Window extends JFrame{

    private Game game;

    private MenuPanel menu = new MenuPanel(this);
    private LevelSelectPanel levelSelect = new LevelSelectPanel(this);
    // public LoginPanel login = new LoginPanel();
    // public HighscorePanel highscore = new HighscorePanel();
    // public CreditsPanel creditsPanel = new CreditsPanel();
    // public InstructionsPanel instructionsPanel = new InstructionsPanel();
    private LevelPanel levelPanel = new LevelPanel(this);
    
    public Window(Game game){
        this.game = game;
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(game.WINDOW_WIDHT, game.WINDOW_HEIGHT);
        setResizable(false);
        setTitle("Bird Game");
        setContentPane(menu);
        // navTo(menu);
        

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
    public LevelPanel getLevelPanel(){
        return this.levelPanel;
    }
}
