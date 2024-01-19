package birdgame.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;

import birdgame.controller.LoginController;
import birdgame.controller.WindowController;
import birdgame.model.WindowModel;




public class MenuPanel extends JPanel{
    private WindowModel windowModel;
    private WindowController windowController;
    private final int backgroundWidth;
    private final int backgroundHeight;
    private Image backgroundImage;

    private Font gameTitleFont = new Font("TimesRoman", Font.BOLD, 40);


    public MenuPanel(WindowModel windowModel, WindowController windowController){
        this.windowModel = windowModel;
        this.windowController = windowController;
        this.backgroundWidth = WindowModel.WINDOW_WIDTH;  
        this.backgroundHeight = WindowModel.WINDOW_HEIGHT;

        System.out.println(backgroundWidth+ ", "+backgroundHeight);

        try{
            this. backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("appBackground.jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.RELATIVE;


        JLabel gameTitle = new JLabel("SNAP A GOOSE");
        gameTitle.setFont(gameTitleFont);

        // CButton buttonlevel = new CButton("Level");
        CButton buttonlevel = new CButton("Play");
        buttonlevel.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // leave it be until level and game are implemented
                // cause thats how game(loop) and level setup should be done
                // Level1 level1 = new Level1();
                // Game game = new Game(level1);
                windowController.navTo(windowModel.getLevelSelectPanel());

            } 
        });


        CButton creditsButton = new CButton("Credits");
        creditsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                windowController.navTo(windowModel.getCreditsPanel());
            }
        });

        CButton highscoreButton = new CButton("Highscores");
        highscoreButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                windowController.navTo(windowModel.getHighscorePanel());
            }
        });


        CButton manuel = new CButton("Manuel");
        //CButton sound = new CButton("Sound");
        //CButton music = new CButton("Music");
        CButton logout = new CButton("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MenuPanel.this.windowController.navTo(windowModel.getLoginPanel());
                LoginController.loadLogin(windowModel.getLoginPanel());
            }
        });
        
        //try {
        //    BufferedImage img = ImageIO.read(getClass().getClassLoader().getResource("sound.png"));
        //    sound = new CButton(img);
         //   img = ImageIO.read(getClass().getClassLoader().getResource("musik.png"));
         //   music = new CButton(img, 50, 50);
        //} catch (Exception ex) {
         //   System.out.println(ex);
        //}

        

        c.insets = new Insets(50, 10, 50, 10);
        c.gridx = 0; 
        c.gridy = 0; 
        c.gridwidth = GridBagConstraints.REMAINDER; 
        c.weightx = 1; 
        c.weighty = 7;
        c.anchor = GridBagConstraints.NORTH; 
        this.add(gameTitle, c);

        c.insets = new Insets(5, 100, 20, 5);
        c.fill = GridBagConstraints.RELATIVE;
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(buttonlevel, c);
        c.gridx = 0;
        c.gridy = 3;
        add(manuel, c);
        c.gridx = 0;
        c.gridy = 4;
        add(highscoreButton, c);
        c.gridx = 0;
        c.gridy = 5;
        add(creditsButton, c);
        c.anchor = GridBagConstraints.SOUTHEAST;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(0, 100, 30, 30);
        add(logout, c);
        //c.weighty = 0;
        //c.anchor = GridBagConstraints.NORTHEAST;
        //c.gridx = 1;
        //c.gridy = 0;
        //add(sound, c);
        //c.weighty = .75;
        //c.gridx = 1;
        //c.gridy = 1;
        //add(music, c);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
      if (this.backgroundImage != null) {
         g.drawImage(this.backgroundImage, 0, 0, backgroundWidth, backgroundHeight, this);
        }
    }
}
