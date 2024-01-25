package birdgame.view;

import birdgame.controller.HighscoreController;
import birdgame.controller.WindowController;
import birdgame.model.WindowModel;
import birdgame.utils.CButton;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.Image;
import java.awt.Graphics;

/**
 * Represents a panel in the Bird Game application's user interface,
 * which displays high scores for different levels. The panel is part of the game's view
 * and interacts with the game's model and controller layers to retrieve and display user data.
 * 
 * This class manages the layout and presentation of high score information, including
 * the creation and positioning of labels and buttons. It also handles user interactions
 * for navigation within the application.
 */
public class HighscorePanel extends JPanel {
    private static final Font TITLE_FONT = new Font("TimesRoman", Font.BOLD, 30);
    private static final Font NORMAL_FONT = new Font("TimesRoman", Font.BOLD, 20);
    private static final String BACKGROUND_IMAGE_PATH = "appBackgroundBlurred.jpg";

    private WindowModel windowModel;
    private Image backgroundImage;

    private JLabel scoreLevel1Label;
    private JLabel scoreLevel2Label;
    private JLabel scoreLevel3Label;

    /**
     * Constructs a HighscorePanel which displays the high scores for different levels.
     *
     * The panel is constructed with references to the window model and window controller.
     * It initializes and sets up the layout, background image, labels for highscores of each level,
     * and the back button with its action listener. The layout is managed with GridBagLayout.
     *
     * @param windowModel The model of the application window providing access to user data and game settings.
     * @param windowController The controller for managing navigation between different panels of the application.
     */
    public HighscorePanel(WindowModel windowModel, WindowController windowController ){
        this.windowModel = windowModel;

        // Load background image
        try{
            this. backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(BACKGROUND_IMAGE_PATH));
        }catch(IOException e){
            e.printStackTrace();
        }

         // Configure layout for the panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        
        // creates and configures Labels and Buttons
        JLabel highscoreTitle = new JLabel("Highscores");
        highscoreTitle.setFont(TITLE_FONT);
        JLabel level1Label = new JLabel("Forest");
        level1Label.setFont(NORMAL_FONT);
        int highscoreLevel1 = HighscoreController.getHighscore(windowModel.getUserName(), 1);  
        scoreLevel1Label = new JLabel(Integer.toString(highscoreLevel1));
        scoreLevel1Label.setFont(NORMAL_FONT);
        JLabel level2Label = new JLabel("Winter");
        level2Label.setFont(NORMAL_FONT);
        int highscoreLevel2 = HighscoreController.getHighscore(windowModel.getUserName(), 2); 
        scoreLevel2Label = new JLabel(Integer.toString(highscoreLevel2));
        scoreLevel2Label.setFont(NORMAL_FONT);
        JLabel level3Label = new JLabel("Night");
        level3Label.setFont(NORMAL_FONT);
        int highscoreLevel3 = HighscoreController.getHighscore(windowModel.getUserName(), 3);
        scoreLevel3Label = new JLabel(Integer.toString(highscoreLevel3));
        scoreLevel3Label.setFont(NORMAL_FONT);
        CButton backButton = new CButton("Back");

        // Implementation of component Listener and Performer for Back Button
        backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navigateToPanel(windowModel.getMenuPanel());
            } 
        });

        // Add components to the panel using GridBagLayout
        c.insets = new Insets(30, 10, 170, 10);
        c.gridx = 0; 
        c.gridy = 0; 
        c.gridwidth = GridBagConstraints.REMAINDER; 
        c.weightx = 1; 
        c.anchor = GridBagConstraints.NORTH; 
        this.add(highscoreTitle, c);
        c.insets = new Insets(35,20,0,20);
        c.gridx = 1; 
        c.gridy = 1; 
        c.gridwidth = 1;
        this.add(level1Label,c);
        c.gridx = 1; 
        c.gridy = 2 ; 
        this.add(level2Label,c);
        c.gridx = 1; 
        c.gridy = 3; 
        this.add(level3Label,c);
        c.gridx = 2; 
        c.gridy = 1;
        this.add(scoreLevel1Label,c);
        c.gridx = 2; 
        c.gridy = 2; 
        this.add(scoreLevel2Label,c);
        c.gridx = 2; 
        c.gridy = 3;
        this.add(scoreLevel3Label,c); 
        JComponent glueLeft = (JComponent) Box.createVerticalGlue();
        c.gridx = 0;
        c.gridwidth = 1;
        c.weightx = 4; 
        c.insets = new Insets(0, 50, 0, 0); 
        this.add(glueLeft, c);
        JComponent glueRight = (JComponent) Box.createVerticalGlue();
        c.gridx = 4;
        c.gridwidth = 1; 
        c.weightx = 4;
        c.insets = new Insets(0, 0, 0, 50); 
        this.add(glueRight, c);
        JComponent glueBottom = (JComponent) Box.createVerticalGlue();
        c.gridy= 4;
        c.weighty = 1; 
        c.insets = new Insets(0, 0, 0, 0); 
        this.add(glueBottom, c);
        c.insets = new Insets(0, 35, 30, 10); 
        c.gridx = 0; 
        c.gridy++; 
        c.weighty = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.SOUTHWEST;
        this.add(backButton, c);
    }

     /**
     * Paints the background image for this panel and gets the Highscores for each level.
     *
     * @param arg0 The Graphics object used for drawing.
     */
    @Override
    protected void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);
        if (this.backgroundImage != null) {
            arg0.drawImage(this.backgroundImage, 0, 0, WindowModel.WINDOW_WIDTH, WindowModel.WINDOW_HEIGHT, this);
           }
        scoreLevel1Label.setText(Integer.toString(HighscoreController.getHighscore(windowModel.getUserName(), 1)));
        scoreLevel2Label.setText(Integer.toString(HighscoreController.getHighscore(windowModel.getUserName(), 2)));
        scoreLevel3Label.setText(Integer.toString(HighscoreController.getHighscore(windowModel.getUserName(), 3)));
    }
}
