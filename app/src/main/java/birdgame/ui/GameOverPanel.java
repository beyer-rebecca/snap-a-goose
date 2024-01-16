package birdgame.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import birdgame.controller.HighscoreController;
import birdgame.controller.ScoreController;
import birdgame.controller.WindowController;
import birdgame.model.WindowModel;


public class GameOverPanel extends JPanel{
    private WindowModel windowModel;
    private WindowController windowController;
    private ScoreController scoreController;

    private Font titleFont = new Font("TimesRoman", Font.BOLD, 30);
    private Font normalFont = new Font("TimesRoman", Font.BOLD, 20);


    public GameOverPanel(WindowModel windowModel, WindowController windowController, ScoreController scoreController){
        this.windowModel = windowModel;
        this.windowController = windowController;
        this.scoreController = scoreController;


        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.RELATIVE;


        JLabel gameOverLabel = new JLabel ("Thank you for Playing!");
        gameOverLabel.setFont(titleFont);


        JLabel scoreLabel = new JLabel("Score:" + scoreController.getScoreModel().getCurrentScore());  //+ scoreController.getCurrentSCore()
        scoreLabel.setFont(normalFont);

        JLabel highscoreLabel = new JLabel("Highscore:" + HighscoreController.getHighscore(windowModel.getUserName(), windowModel.getLevel()));  //+ highscoreController.int getHighscore(String username, int level)
        highscoreLabel.setFont(normalFont);

        //CButton replayButton = new CButton("Replay");
        //replayButton.addActionListener(new ActionListener(){
        //    public void actionPerformed(ActionEvent e){
        //        //int levelNumber = gamecontroller.getLevelNumber() 
        //        //GameController gameController = new GameController(windowController);
        //        //gameController.loadLevel(levelNumber);
        //        //windowController.navTo(gameController.getLevelPanel());
        //    }
        //});

        CButton menuButton = new CButton("Menu");
        menuButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                windowController.navTo(windowModel.getMenuPanel());
            } 
        });


        c.insets = new Insets(5, 0, 40, 0);
        c.fill = GridBagConstraints.NONE;
        //c.weightx = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        add(gameOverLabel, c);
        // c.gridx = 0;
        // c.gridy = 1;
        // c.insets = new Insets(0, 5,20,0);
        // add(levelLabel, c);
        c.gridx = 0;
        c.gridy = 2;
        add(scoreLabel, c);
        c.gridx = 0;
        c.gridy = 3;

        add(highscoreLabel, c);
        // c.gridx = 0;
        // c.gridy = 4;
        // c.anchor = GridBagConstraints.CENTER;
        // c.insets = new Insets(50, 20,5,0);
        // add(replayButton, c);
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(10, 20,20,0);
        add(menuButton, c);








    }

}
