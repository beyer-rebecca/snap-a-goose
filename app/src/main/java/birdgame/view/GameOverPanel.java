package birdgame.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;

import birdgame.controller.HighscoreController;
import birdgame.controller.ScoreController;
import birdgame.controller.WindowController;
import birdgame.model.Constants;
import birdgame.model.WindowModel;
import birdgame.utils.CButton;

/**
 * Panel to display the game over screen in the Bird Game.
 * This panel shows the player's score of the played level, the high score for the level, and provides
 * an option to return to the main menu.
 */
public class GameOverPanel extends JPanel{
    private Image backgroundImage;

    private static final String BACKGROUND_IMAGE_PATH = "appBackgroundBlurred.jpg";

    /**
     * Constructs a GameOverPanel with references to the window model, window controller,
     * and score controller. It initializes the panel layout, loads the background image,
     * and sets up the user interface components including labels and buttons.
     *
     * @param windowModel The model of the application window.
     * @param windowController The controller for managing the application window.
     * @param scoreController The controller for managing the game score.
     */
    public GameOverPanel(WindowModel windowModel, WindowController windowController, ScoreController scoreController){

        // load background image
        try {
            this.backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(BACKGROUND_IMAGE_PATH));
        } catch (IOException e){
            e.printStackTrace();
        }

        // set Layout 
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.RELATIVE;

        // creates and configures Labels for game over, score and highscore
        JLabel gameOverLabel = new JLabel ("Thank you for Playing!");
        gameOverLabel.setFont(Constants.TITLE_FONT);
        JLabel scoreLabel = new JLabel("Score:   " + scoreController.getScoreModel().getCurrentScore());  
        scoreLabel.setFont(Constants.NORMAL_FONT);
        JLabel highscoreLabel = new JLabel("Highscore:   " + HighscoreController.getUserHighscore(windowModel.getUserName(), windowModel.getLevel()));  
        highscoreLabel.setFont(Constants.NORMAL_FONT);
        CButton menuButton = new CButton("Menu");

        // Set action Listener  for Menu Button
        menuButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navigateToPanel(windowModel.getMenuPanel());
            } 
        });

        // Add components to the panel
        c.insets = new Insets(5, 0, 40, 0);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        add(gameOverLabel, c);
        c.gridx = 0;
        c.gridy = 2;
        add(scoreLabel, c);
        c.gridx = 0;
        c.gridy = 3;
        add(highscoreLabel, c);
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(10, 20,20,0);
        add(menuButton, c);
    }

    /**
     * Paints the background image for this panel.
     *
     * @param arg0 The Graphics object used for drawing.
     */
    @Override
    protected void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);
        if (this.backgroundImage != null) {
            arg0.drawImage(this.backgroundImage, 0, 0, WindowModel.WINDOW_WIDTH, WindowModel.WINDOW_HEIGHT, this);
           }
    }
}
