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
import birdgame.model.Game;
import birdgame.model.WindowModel;


public class LevelSelectPanel extends JPanel{
    private WindowModel windowModel;
    private WindowController windowController;
    private final int backgroundWidth;
    private final int backgroundHeight;
    private Image backgroundImage;

    public LevelSelectPanel(WindowModel windowModel, WindowController windowController){
        this.windowModel = windowModel;
        this.windowController = windowController;
        this.backgroundWidth = WindowModel.WINDOW_WIDTH;  
        this.backgroundHeight = WindowModel.WINDOW_HEIGHT;

        try{
            this. backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("appBackgroundBlurred.jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }
        

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        

        CButton level1 = new CButton();
        CButton level2 = new CButton();
        CButton level3 = new CButton();
        CButton backButton = new CButton("Back");
        try {
            BufferedImage img = ImageIO.read(getClass().getClassLoader().getResource("pol.png"));
            level1 = new CButton(img);
            level2 = new CButton(img);
            level3 = new CButton(img);
        } catch (Exception ex) {
            System.out.println("Error loading button image: "+ex);
        }
        level1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameController gameController = new GameController(windowController);   // vlt nur 1 GameController in ganzen spiel, in App erstellen?
                windowModel.setLevel(1);
                gameController.loadLevel();
                windowController.navTo(gameController.getLevelPanel());
            }
        });
        level2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameController gameController = new GameController(windowController);
                windowModel.setLevel(2);
                gameController.loadLevel();
                windowController.navTo(gameController.getLevelPanel());
            }
        });
        level3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameController gameController = new GameController(windowController);
                windowModel.setLevel(3);
                gameController.loadLevel();
                windowController.navTo(gameController.getLevelPanel());
            }
        });
        backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navTo(windowModel.getMenuPanel());

            } 
        });

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

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
      if (this.backgroundImage != null) {
         g.drawImage(this.backgroundImage, 0, 0, backgroundWidth, backgroundHeight, this);
        }
    }
}
