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
import birdgame.model.WindowModel;

public class ManualPanel extends JPanel {
    private final static Font TITLE_FONT = new Font("TimesRoman", Font.BOLD, 30);
    private final static Font NORMAL_FONT = new Font("TimesRoman", Font.BOLD, 20);
    private static final String BACKGROUND_IMAGE_PATH = "appBackgroundBlurred.jpg";

    private WindowModel windowModel;
    private WindowController windowController;

    private final int backgroundWidth;
    private final int backgroundHeight;
    private Image backgroundImage;

    public ManualPanel(WindowModel windowModel, WindowController windowController){
        this.windowModel = windowModel;
        this.windowController = windowController;
        this.backgroundWidth = WindowModel.WINDOW_WIDTH;  
        this.backgroundHeight = WindowModel.WINDOW_HEIGHT;
        
        try {
            this.backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(BACKGROUND_IMAGE_PATH));
        } catch(IOException e){
            e.printStackTrace();
        }

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        CButton backButton = new CButton("Back");
        backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navigateToPanel(windowModel.getMenuPanel());
            } 
        });


        JLabel titleLabel = new JLabel("Manual");
        titleLabel.setFont(TITLE_FONT);
        JLabel instructionsLabel = new JLabel("here enter instructions");
        instructionsLabel.setFont(NORMAL_FONT);


        c.insets = new Insets(40, 10, 35, 10);
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

     @Override
     protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       if (this.backgroundImage != null) {
          g.drawImage(this.backgroundImage, 0, 0, backgroundWidth, backgroundHeight, this);
         }
     }
}
