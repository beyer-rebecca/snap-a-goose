package birdgame.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.Box;
import javax.imageio.ImageIO;

public class HighscorePanel extends JPanel {

    private Font titleFont = new Font("TimesRoman", Font.BOLD, 30);
    private Font normalFont = new Font("TimesRoman", Font.BOLD, 20);

    public HighscorePanel(Window window){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;

        // Create Backbutton
        CButton backButton = new CButton("<--");
        backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                window.navTo(window.getMenuPanel());
            } 
        });


        // show headline Highscore
        JLabel highscoreTitle = new JLabel("Highscores");
        highscoreTitle.setFont(titleFont);
        
        // show Level1 name
        JLabel level1Label = new JLabel("Forest");
        level1Label.setFont(normalFont);
        

        // show level1 highscore
        int highscoreLevel1 = 1;  //nachdem highscoreController,userController eingebaut: =highscoreController.getHighscore(level1, user.getUsername)
        JLabel scoreLevel1Label = new JLabel(Integer.toString(highscoreLevel1));
        scoreLevel1Label.setFont(normalFont);
        

        //show lebel2 name
        JLabel level2Label = new JLabel("Sea");
        level2Label.setFont(normalFont);
        

        // show level2 Highscore
        int highscoreLevel2 = 22;  //nachdem highscoreController, userController eingebaut: =highscoreController.getHighscore(level2, user.getUsername)
        JLabel scoreLevel2Label = new JLabel(Integer.toString(highscoreLevel2));
        scoreLevel2Label.setFont(normalFont);
        
        //show lebel3 name
        JLabel level3Label = new JLabel("Mountains");
        level3Label.setFont(normalFont);

        // show level3 Highscore
        int highscoreLevel3 = 333333;  //nachdem highscoreController, userController eingebaut: =highscoreController.getHighscore(level3, user.getUsername)
        JLabel scoreLevel3Label = new JLabel(Integer.toString(highscoreLevel3));
        scoreLevel3Label.setFont(normalFont);


        c.insets = new Insets(10, 10, 5, 10);
        c.gridx = 0; c.gridy = 0; 
        c.gridwidth = 1; 
        c.weightx = 0; 
        c.anchor = GridBagConstraints.NORTHWEST;
        this.add(backButton, c);

        c.insets = new Insets(0, 10, 150, 10);
        c.gridx = 0; c.gridy = 0; 
        c.gridwidth = GridBagConstraints.REMAINDER; 
        c.weightx = 1; 
        c.anchor = GridBagConstraints.NORTH; 
        this.add(highscoreTitle, c);

        c.insets = new Insets(35,35,0,35);
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        this.add(level1Label,c);

        c.gridx = 1; c.gridy = 2 ; 
        this.add(level2Label,c);

        c.gridx = 1; c.gridy = 3; 
        this.add(level3Label,c);

        c.gridx = 2; c.gridy = 1;
        this.add(scoreLevel1Label,c);

        c.gridx = 2; c.gridy = 2; 
        this.add(scoreLevel2Label,c);

        c.gridx = 2; c.gridy = 3;
        this.add(scoreLevel3Label,c); 

        JComponent glueLeft = (JComponent) Box.createVerticalGlue();
        c.gridx = 0;
        c.gridwidth = 1; 
        c.insets = new Insets(0, 50, 0, 0); 
        this.add(glueLeft, c);

        JComponent glueRight = (JComponent) Box.createVerticalGlue();
        c.gridx = 4;
        c.gridwidth = 1; 
        c.insets = new Insets(0, 0, 0, 50); 
        this.add(glueRight, c);

        JComponent glueBottom = (JComponent) Box.createVerticalGlue();
        c.gridy= 4;
        c.weighty = 1; 
        c.insets = new Insets(0, 0, 0, 0); 
        this.add(glueBottom, c);


    }
    
}
