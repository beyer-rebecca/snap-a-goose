package birdgame.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;

import birdgame.controller.HighscoreController;
import birdgame.controller.ScoreController;
import birdgame.controller.WindowController;
import birdgame.model.WindowModel;

public class GameOverPanel extends JPanel{
    private WindowModel windowModel;
    private WindowController windowController;
    private ScoreController scoreController;
    private Image backgroundImage;

    private static final Font TITLE_FONT = new Font("TimesRoman", Font.BOLD, 30);
    private static final Font NORMAL_FONT = new Font("TimesRoman", Font.BOLD, 20);
    private static final String BACKGROUND_IMAGE_PATH = "appBackgroundBlurred.jpg";

    public GameOverPanel(WindowModel windowModel, WindowController windowController, ScoreController scoreController){
        this.windowModel = windowModel;
        this.windowController = windowController;
        this.scoreController = scoreController;

        try {
            this.backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(BACKGROUND_IMAGE_PATH));
        } catch (IOException e){
            e.printStackTrace();
        }

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.RELATIVE;

        JLabel gameOverLabel = new JLabel ("Thank you for Playing!");
        gameOverLabel.setFont(TITLE_FONT);
        JLabel scoreLabel = new JLabel("Score:   " + scoreController.getScoreModel().getCurrentScore());  
        scoreLabel.setFont(NORMAL_FONT);
        JLabel highscoreLabel = new JLabel("Highscore:   " + HighscoreController.getHighscore(windowModel.getUserName(), windowModel.getLevel()));  
        highscoreLabel.setFont(NORMAL_FONT);
        CButton menuButton = new CButton("Menu");

        menuButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navigateToPanel(windowModel.getMenuPanel());
            } 
        });

        c.insets = new Insets(5, 0, 40, 0);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        add(gameOverLabel, c);
        c.gridx = 0;
        c.gridy = 2;
        add(scoreLabel, c);
        c.gridx = 0;
        c.gridy = 3;
        add(highscoreLabel, c);
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(10, 20,20,0);
        add(menuButton, c);
    }

    @Override
    protected void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);
        if (this.backgroundImage != null) {
            arg0.drawImage(this.backgroundImage, 0, 0, WindowModel.WINDOW_WIDTH, WindowModel.WINDOW_HEIGHT, this);
           }
    }
}
