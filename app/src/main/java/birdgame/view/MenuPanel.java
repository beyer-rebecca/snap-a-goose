package birdgame.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Font gameTITLE_FONT = new Font("TimesRoman", Font.BOLD, 40);
    private static final String BACKGROUND_IMAGE_PATH = "appBackground.jpg";

    private WindowModel windowModel;
    private WindowController windowController;
    private final int backgroundWidth;
    private final int backgroundHeight;
    private Image backgroundImage;

    public MenuPanel(WindowModel windowModel, WindowController windowController){
        this.windowModel = windowModel;
        this.windowController = windowController;
        this.backgroundWidth = WindowModel.WINDOW_WIDTH;  
        this.backgroundHeight = WindowModel.WINDOW_HEIGHT;

        try {
            this. backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(BACKGROUND_IMAGE_PATH));
        } catch (IOException e){
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.RELATIVE;

        JLabel gameTitle = new JLabel("SNAP A GOOSE");
        gameTitle.setFont(gameTITLE_FONT);

        CButton buttonlevel = new CButton("Play");
        buttonlevel.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navigateToPanel(windowModel.getLevelSelectPanel());

            } 
        });

        CButton creditsButton = new CButton("Credits");
        creditsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                windowController.navigateToPanel(windowModel.getCreditsPanel());
            }
        });

        CButton highscoreButton = new CButton("Highscores");
        highscoreButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                windowController.navigateToPanel(windowModel.getHighscorePanel());
            }
        });


        CButton manualButton = new CButton("Manual");
        manualButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                windowController.navigateToPanel(windowModel.getManualPanel());
            }
        });

        CButton logout = new CButton("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MenuPanel.this.windowController.navigateToPanel(windowModel.getLoginPanel());
                LoginController.loadLogin(windowModel.getLoginPanel());
            }
        });

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
        add(manualButton, c);
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
    }

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
      if (this.backgroundImage != null) {
         g.drawImage(this.backgroundImage, 0, 0, backgroundWidth, backgroundHeight, this);
        }
    }
}
