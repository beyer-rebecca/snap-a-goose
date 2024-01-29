package birdgame.view;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Represents the main window of the Bird Game application. 
 * This class extends JFrame and manages the different panels (views) that are displayed.
 */
public class WindowView extends JFrame{
    
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
}
