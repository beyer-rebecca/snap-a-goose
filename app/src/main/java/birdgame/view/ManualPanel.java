package birdgame.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Graphics;

import birdgame.controller.WindowController;
import birdgame.model.Constants;
import birdgame.model.WindowModel;
import birdgame.utils.CButton;

/**
 * Represents the game manual screen to the user. 
 * It displays the game instructions and a back button
 * for navigation. The panel's graphical user interface is designed with {@link java.awt.GridBagLayout}.
 */
public class ManualPanel extends JPanel {
    private static final String BACKGROUND_IMAGE_PATH = "appBackgroundBlurred.jpg";

    private final String INSTRUCTIONS_TEXT = """
        <html> Your mission: capture as many geese on camera as you can before time runs out. <br>
        These geese are tricky, hiding behind trees and appearing briefly. <br>
        Be quick to aim and snap a photo when they show themselves.<br> <br>

        Here's how to play: direct your cursor to aim at the geese and left-click to take a photo. <br>
        Each goose you photograph scores you 25 points. <br>
        Keep an eye on your score at the top right of the screen, <br> and watch the remaining time at the top left. 
        The game ends when the timer hits zero. <br> <br> Good luck and Happy Snapping! </html>
        """;



    private final int backgroundWidth;
    private final int backgroundHeight;
    private Image backgroundImage;

    /**
     * Constructs a new MenualPanel.
     * This constructor initializes the panel, sets up the background image, sets the layout and adds labels and a back button to the menu.
     * Action listeners are assigned to handle user interactions with the back button.
     * The layout of components is managed using GridBagLayout.
     * 
     * @param windowModel The model containing window properties.
     * @param windowController The controller responsible for navigation between panels.
     */
    public ManualPanel(WindowModel windowModel, WindowController windowController){
        this.backgroundWidth = WindowModel.WINDOW_WIDTH;  
        this.backgroundHeight = WindowModel.WINDOW_HEIGHT;
        
        // load background images
        try {
            this.backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(BACKGROUND_IMAGE_PATH));
        } catch(IOException e){
            e.printStackTrace();
        }

        // set layout
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Intiate and Set action Listener for back Button 
        CButton backButton = new CButton("Back");
        backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navigateToPanel(windowModel.getMenuPanel());
            } 
        });

        // Initalize Lables
        JLabel titleLabel = new JLabel("Manual");
        titleLabel.setFont(Constants.TITLE_FONT);
        JLabel instructionsLabel = new JLabel(INSTRUCTIONS_TEXT);
        instructionsLabel.setFont(Constants.NORMAL_FONT);

        // Add components to the panel
        c.insets = new Insets(40, 10, 50, 10);
        c.gridx = 0; 
        c.gridy = 0; 
        c.gridwidth = GridBagConstraints.REMAINDER; 
        c.weightx = 1; 
        c.anchor = GridBagConstraints.NORTH; 
        add(titleLabel, c);
        c.weighty = 1;
        c.gridx = 0; 
        c.gridy = 1; 
        add(instructionsLabel, c);
        c.insets = new Insets(0, 35, 30, 10); 
        c.gridx = 0; 
        c.gridy++; 
        c.gridwidth = 1; 
        c.weightx = 0; 
        c.anchor = GridBagConstraints.SOUTHWEST;
        this.add(backButton, c);
    }

     
     /** 
      * @param g
      */
     @Override
     protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       if (this.backgroundImage != null) {
          g.drawImage(this.backgroundImage, 0, 0, backgroundWidth, backgroundHeight, this);
         }
     }
}
