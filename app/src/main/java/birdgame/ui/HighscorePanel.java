package birdgame.ui;

import birdgame.controller.HighscoreController;
import birdgame.controller.WindowController;
import birdgame.model.WindowModel;

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

public class HighscorePanel extends JPanel {

    private Font titleFont = new Font("TimesRoman", Font.BOLD, 30);
    private Font normalFont = new Font("TimesRoman", Font.BOLD, 20);


    private WindowModel windowModel;
    private WindowController windowController;
    private final int backgroundWidth;
    private final int backgroundHeight;
    private Image backgroundImage;

    private JLabel scoreLevel1Label;
    private JLabel scoreLevel2Label;
    private JLabel scoreLevel3Label;

    public HighscorePanel(WindowModel windowModel, WindowController windowController ){
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
        c.fill = GridBagConstraints.NONE;

        // Create Backbutton
        CButton backButton = new CButton("Back");
        backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navTo(windowModel.getMenuPanel());
            } 
        });


        // show headline Highscore
        JLabel highscoreTitle = new JLabel("Highscores");
        highscoreTitle.setFont(titleFont);
        
        // show Level1 name
        JLabel level1Label = new JLabel("Forest");
        level1Label.setFont(normalFont);
        

        // show level1 highscore
        int highscoreLevel1 = HighscoreController.getHighscore(windowModel.getUserName(), 1);  
        scoreLevel1Label = new JLabel(Integer.toString(highscoreLevel1));
        scoreLevel1Label.setFont(normalFont);
        

        //show lebel2 name
        JLabel level2Label = new JLabel("Winter");
        level2Label.setFont(normalFont);
        

        // show level2 Highscore
        int highscoreLevel2 = HighscoreController.getHighscore(windowModel.getUserName(), 2);  //nachdem highscoreController,userController eingebaut: =highscoreController.getHighscore(level1, user.getUsername)
        scoreLevel2Label = new JLabel(Integer.toString(highscoreLevel2));
        scoreLevel2Label.setFont(normalFont);
        
        //show lebel3 name
        JLabel level3Label = new JLabel("Night");
        level3Label.setFont(normalFont);

        // show level3 Highscore
        int highscoreLevel3 = HighscoreController.getHighscore(windowModel.getUserName(), 3);  //nachdem highscoreController,userController eingebaut: =highscoreController.getHighscore(level1, user.getUsername)
        scoreLevel3Label = new JLabel(Integer.toString(highscoreLevel3));
        scoreLevel3Label.setFont(normalFont);

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

    @Override
    protected void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);
        if (this.backgroundImage != null) {
            arg0.drawImage(this.backgroundImage, 0, 0, backgroundWidth, backgroundHeight, this);
           }
        scoreLevel1Label.setText(Integer.toString(HighscoreController.getHighscore(windowModel.getUserName(), 1)));
        scoreLevel2Label.setText(Integer.toString(HighscoreController.getHighscore(windowModel.getUserName(), 2)));
        scoreLevel3Label.setText(Integer.toString(HighscoreController.getHighscore(windowModel.getUserName(), 3)));
    }

    
}
