package birdgame.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.Box;
import javax.imageio.ImageIO;
import java.io.IOException;

import birdgame.controller.WindowController;
import birdgame.model.Constants;
import birdgame.model.WindowModel;
import birdgame.utils.CButton;

/**
 * Represents the credits panel in the Bird Game application.
 * This class extends JPanel and displays the credits for the game, including the names of contributors and a back Button.
 */
public class CreditsPanel extends JPanel{
    private static final String BACKGROUND_IMAGE_PATH = "appBackgroundBlurred.jpg";

    private Image backgroundImage;

    /**
     * Constructs a CreditsPanel with specified WindowModel and WindowController.
     * Initializes the panel with a background image, sets the layout,
     * and adds labels and a back button.
     * Action listeners are assigned to handle user interactions with the back button.
     * The layout of components is managed using GridBagLayout.
     *
     * @param windowModel The model of the application's window, containing necessary data.
     * @param windowController The controller of the application's window, used for event handling.
     */
    public CreditsPanel(WindowModel windowModel, WindowController windowController){

        try{
            this. backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(BACKGROUND_IMAGE_PATH));
        }catch(IOException e){
            e.printStackTrace();
        }

        // Initialization and layout setup
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Implementation of components
        CButton backButton = new CButton("Back");
        JLabel titleLabel = new JLabel("Credits");
        titleLabel.setFont(Constants.TITLE_FONT);
        JLabel programLabel = new JLabel("Programming");
        programLabel.setFont(Constants.SMALL_FONT);
        JLabel programName1Label = new JLabel("Nils Wiemer");
        programName1Label.setFont(Constants.NORMAL_FONT);
        JLabel programName2Label = new JLabel("Rebecca Beyer");
        programName2Label.setFont(Constants.NORMAL_FONT);
        JLabel artLabel = new JLabel("Art");
        artLabel.setFont(Constants.SMALL_FONT);
        JLabel artName1Label = new JLabel("CraiZenCreations");
        artName1Label.setFont(Constants.NORMAL_FONT);
        JLabel artName2Label = new JLabel("Vectorbox Studio");
        artName2Label.setFont(Constants.NORMAL_FONT);
        JLabel artName3Label = new JLabel("Srabon Arafat");
        artName3Label.setFont(Constants.NORMAL_FONT);
        JLabel artName4Label = new JLabel("joan12345");
        artName4Label.setFont(Constants.NORMAL_FONT);
        JLabel artName5Label = new JLabel("SignalFadingTransmission91881");
        artName5Label.setFont(Constants.NORMAL_FONT);
        JLabel artName6Label = new JLabel("DALEE3");
        artName6Label.setFont(Constants.NORMAL_FONT);
        JComponent glue = (JComponent) Box.createVerticalGlue();

        // Set action listeners for back button
        backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navigateToPanel(windowModel.getMenuPanel());
            } 
        });

        // Positioning of the components
        c.insets = new Insets(40, 10, 35, 10);
        c.gridx = 0; 
        c.gridy = 0; 
        c.gridwidth = GridBagConstraints.REMAINDER; 
        c.weightx = 1; 
        c.anchor = GridBagConstraints.NORTH; 
        this.add(titleLabel, c);
        c.gridx = 0; 
        c.gridy++; 
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.CENTER; 
        c.insets = new Insets(35, 0, 5, 0); 
        this.add(programLabel,c);
        c.gridy++; 
        c.insets = new Insets(0, 0, 5, 0);
        c.anchor = GridBagConstraints.CENTER; 
        this.add(programName1Label,c);
        c.gridy++; 
        this.add(programName2Label,c);
        c.gridy++;
        c.insets = new Insets(35, 0, 5, 0); 
        this.add(artLabel,c);
        c.gridy++; 
        c.insets = new Insets(0, 0, 5, 0);
        this.add(artName1Label,c);
        c.gridy++; 
        this.add(artName2Label,c);
        c.gridy++; 
        this.add(artName3Label,c);
        c.gridy++; 
        this.add(artName4Label,c);
        c.gridy++; 
        this.add(artName5Label,c);
        c.gridy++; 
        c.insets = new Insets(0, 0, 50, 0);
        this.add(artName6Label,c);
        c.gridy++; 
        c.insets = new Insets(0, 0, 50, 0);
        c.fill = GridBagConstraints.VERTICAL;
        c.insets = new Insets(0, 0, 10, 0); 
        this.add(glue, c);
        c.insets = new Insets(0, 35, 30, 10); 
        c.gridx = 0; 
        c.gridy++; 
        c.gridwidth = 1; 
        c.weightx = 0; 
        c.anchor = GridBagConstraints.SOUTHWEST;
        this.add(backButton, c);
    }

    /**
     * Paints the background image of the panel.
     * @param g The Graphics object to paint on.
     */
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
      if (this.backgroundImage != null) {
         g.drawImage(this.backgroundImage, 0, 0, WindowModel.WINDOW_WIDTH, WindowModel.WINDOW_HEIGHT, this);
        }
    }
}
