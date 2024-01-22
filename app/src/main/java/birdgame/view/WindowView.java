package birdgame.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import birdgame.controller.WindowController;

/**
 * Represents the main window of the Bird Game application.
 * It extends {@code JFrame} and serves as the primary container for the different panels 
 * corresponding to various views in the game: main menu, level selection, login, 
 * highscores, credits, manualand game over screens.
 *
 * <p>This class is responsible for managing the display and switching between different 
 * panels based on user interactions and game state changes. It initializes the main 
 * window settings such as title, non-resizability, and default close operation.
 */
public class WindowView extends JFrame{
    private WindowController windowController;
    
    private MenuPanel menuPanel;
    private LevelSelectPanel levelSelectPanel;
    private LoginPanel loginPanel;
    private HighscorePanel highscorePanel;
    private CreditsPanel creditsPanel;
    private GameOverPanel gameOverPanel;

    private JPanel currentPanel;

    /**
     * Constructs a new WindowView. Initializes the main window with the default settings 
     * for the game, including setting the title, disabling resizability, and making it visible.
     */
    public WindowView(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bird Game");
        // needs to be last
        setVisible(true);
    }

    /**
     * Sets the current panel displayed in the main window.
     * This method is used to switch between different views in the application.
     *
     * @param panel The {@code JPanel} to be displayed in the main window.
     */
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
