package birdgame.view;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import javax.imageio.ImageIO;

import birdgame.controller.GameController;
import birdgame.controller.WindowController;
import birdgame.model.WindowModel;

/**
 * Displays the level selection screen in the Bird Game.
 * It allows players to choose between different game levels.
 * This class handles the layout and event handling for the level selection buttons and the back button and the background.
 */
public class LevelSelectPanel extends JPanel{
    private static final String BACKGROUND_IMAGE_PATH = "appBackgroundBlurred.jpg";
    private final int backgroundWidth;
    private final int backgroundHeight;
    private Image backgroundImage;

    /**
     * Constructs a new LevelSelectPanel.
     * This constructor initializes the panel, loads the background image, and sets up the level selection buttons and the back button.
     *
     * @param windowModel The model containing window properties.
     * @param windowController The controller responsible for navigating between panels.
     */
    public LevelSelectPanel(WindowModel windowModel, WindowController windowController){
        this.backgroundWidth = WindowModel.WINDOW_WIDTH;  
        this.backgroundHeight = WindowModel.WINDOW_HEIGHT;

        // Load background image for panel
        try{
            this.backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(BACKGROUND_IMAGE_PATH));
        }catch(IOException e){
            e.printStackTrace();
        }
        
        // Set up layout for the panel using GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Initialize the level selection buttons 
        CButton level1 = new CButton();
        CButton level2 = new CButton();
        CButton level3 = new CButton();
        CButton backButton = new CButton("Back");

        // Load the button images and set up the buttons
        try {
            BufferedImage img = ImageIO.read(getClass().getClassLoader().getResource("pol.png"));
            level1 = new CButton(img);
            level2 = new CButton(img);
            level3 = new CButton(img);
        } catch (Exception ex) {
            System.out.println("Error loading button image: "+ex);
        }

        // Set action listeners for each level button to load the respective level
        level1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameController gameController = new GameController(windowController);  
                windowModel.setLevel(1);
                gameController.loadLevel();
                windowController.navigateToPanel(gameController.getLevelPanel());
            }
        });

        level2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameController gameController = new GameController(windowController);
                windowModel.setLevel(2);
                gameController.loadLevel();
                windowController.navigateToPanel(gameController.getLevelPanel());
            }
        });

        level3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameController gameController = new GameController(windowController);
                windowModel.setLevel(3);
                gameController.loadLevel();
                windowController.navigateToPanel(gameController.getLevelPanel());
            }
        });

        // Set action listener for the back button to return to the main menu
        backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navigateToPanel(windowModel.getMenuPanel());

            } 
        });

        // Add components to the panel
        c.insets = new Insets(200, 0, 0, 0);
        c.gridy=1;
        c.gridx = 1;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.ipady = 75;
        add(level1,c);
        c.gridy=1;
        c.gridx = 2;
        c.anchor = GridBagConstraints.NORTH;
        add(level2,c);
        c.gridy=1;
        c.gridx = 3;
        c.anchor = GridBagConstraints.NORTHWEST;
        add(level3,c); 
        c.ipady = 0;
        c.gridx = 0; 
        c.gridy = 2; 
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.SOUTHWEST;
        c.insets = new Insets(0, 35, 30, 0); 
        add(backButton, c);
    }

    /**
     * Paints the background image on this panel.
     * This method is called automatically by the Swing framework whenever the panel needs to be redrawn.
     *
     * @param g The Graphics object to protect.
     */
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
      if (this.backgroundImage != null) {
         g.drawImage(this.backgroundImage, 0, 0, backgroundWidth, backgroundHeight, this);
        }
    }
}
