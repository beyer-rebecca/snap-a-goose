package birdgame.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame{

    public MenuPanel menu = new MenuPanel(this);
    // public LevelSelectPanel levelSelect = new LevelSelectPanel(this, menu);
    // public LoginPanel login = new LoginPanel();
    // public HighscorePanel highscore = new HighscorePanel();
    // public CreditsPanel creditsPanel = new CreditsPanel();
    // public InstructionsPanel instructionsPanel = new InstructionsPanel();
    
    public Window(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
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
}
