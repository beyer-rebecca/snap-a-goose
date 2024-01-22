package birdgame.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.Box;
import javax.imageio.ImageIO;
import java.io.IOException;

import birdgame.controller.WindowController;
import birdgame.model.WindowModel;

/**
 * Represents the credits panel in the Bird Game application.
 * This class extends JPanel and displays the credits for the game, including the names of contributors and a back Button.
 */
public class CreditsPanel extends JPanel{
    private static final Font TITLE_FONT = new Font("TimesRoman", Font.BOLD, 30);
    private static final Font SMALL_FONT = new Font("TimesRoman", Font.PLAIN, 15);  
    private static final Font NORMAL_FONT = new Font("TimesRoman", Font.BOLD, 20);
    private static final String BACKGROUND_IMAGE_PATH = "appBackgroundBlurred.jpg";

    private WindowModel windowModel;
    private WindowController windowController;
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
        this.windowModel = windowModel;
        this.windowController = windowController;

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
        titleLabel.setFont(TITLE_FONT);
        JLabel programLabel = new JLabel("Programming");
        programLabel.setFont(SMALL_FONT);
        JLabel programName1Label = new JLabel("Nils Wiemer");
        programName1Label.setFont(NORMAL_FONT);
        JLabel programName2Label = new JLabel("Rebecca Beyer");
        programName2Label.setFont(NORMAL_FONT);
        JLabel artLabel = new JLabel("Art");
        artLabel.setFont(SMALL_FONT);
        JLabel artName1Label = new JLabel("Artist1");
        artName1Label.setFont(NORMAL_FONT);
        JLabel artName2Label = new JLabel("Artist2");
        artName2Label.setFont(NORMAL_FONT);
        JLabel audioLabel = new JLabel("Audio and Music");
        audioLabel.setFont(SMALL_FONT);
        JLabel audioName1Label = new JLabel("Musicianname1");
        audioName1Label.setFont(NORMAL_FONT);
        JLabel audioName2Label = new JLabel("Musicianname2");
        audioName2Label.setFont(NORMAL_FONT);
        JComponent glue = (JComponent) Box.createVerticalGlue();

        // Implementation of component listeners and actions
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
        c.insets = new Insets(35, 0, 5, 0); 
        this.add(audioLabel,c);
        c.gridy++; 
        c.insets = new Insets(0, 0, 5, 0);
        this.add(audioName1Label,c);
        c.gridy++; 
        c.insets = new Insets(0, 0, 50, 0);
        this.add(audioName2Label,c);
        c.gridy++;
        c.weighty = 1; 
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
