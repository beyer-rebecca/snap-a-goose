package birdgame.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPanel;

import birdgame.controller.WindowController;
import birdgame.model.WindowModel;

import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.Box;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Graphics;

public class CreditsPanel extends JPanel{
    private WindowModel windowModel;
    private WindowController windowController;
    private final int backgroundWidth;
    private final int backgroundHeight;
    private Image backgroundImage;
    private Font titleFont = new Font("TimesRoman", Font.BOLD, 30);
    private Font smallFont = new Font("TimesRoman", Font.PLAIN, 15);  
    private Font normalFont = new Font("TimesRoman", Font.BOLD, 20);

    public CreditsPanel(WindowModel windowModel, WindowController windowController){
        this.windowModel = windowModel;
        this.windowController = windowController;
        this.backgroundWidth = WindowModel.WINDOW_WIDTH;  
        this.backgroundHeight = WindowModel.WINDOW_HEIGHT;
        
        try{
            this. backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("appBackgroundBlurred.jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Backbutton
        CButton backButton = new CButton("Back");
        backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navTo(windowModel.getMenuPanel());
            } 
        });


        // create headline Credits
        JLabel titleLabel = new JLabel("Credits");
        titleLabel.setFont(titleFont);
        
        // create individual Credits
        // credits for programming
        JLabel programLabel = new JLabel("Programming");
        programLabel.setFont(smallFont);

        // names for programming
        JLabel programName1Label = new JLabel("Nils Wiemer");
        programName1Label.setFont(normalFont);
        JLabel programName2Label = new JLabel("Rebecca Beyer");
        programName2Label.setFont(normalFont);
        
        // credits for art
        JLabel artLabel = new JLabel("Art");
        artLabel.setFont(smallFont);

        // names for art
        JLabel artName1Label = new JLabel("Artist1");
        artName1Label.setFont(normalFont);
        JLabel artName2Label = new JLabel("Artist2");
        artName2Label.setFont(normalFont);
        
        // credits for audio
        JLabel audioLabel = new JLabel("Audio and Music");
        audioLabel.setFont(smallFont);
        
        // names for audio
        JLabel audioName1Label = new JLabel("Musicianname1");
        audioName1Label.setFont(normalFont);
        JLabel audioName2Label = new JLabel("Musicianname2");
        audioName2Label.setFont(normalFont);

        JComponent glue = (JComponent) Box.createVerticalGlue();


        //c.insets = new Insets(10, 10, 0, 10); 
        //c.gridx = 0; 
        //c.gridy = 0; 
        //c.gridwidth = 1; 
        //c.weightx = 0; 
        //c.anchor = GridBagConstraints.NORTHWEST;
        //this.add(backButton, c);
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
        c.gridy++; // Nächste Zeile
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

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
      if (this.backgroundImage != null) {
         g.drawImage(this.backgroundImage, 0, 0, backgroundWidth, backgroundHeight, this);
        }
    }
}
