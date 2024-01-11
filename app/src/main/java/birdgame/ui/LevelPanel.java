package birdgame.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

// import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper; //wofür ist das?

import birdgame.controller.GameController;
import birdgame.controller.PlayerController;
import birdgame.controller.ScoreController;
import birdgame.controller.BirdFlockController;
import birdgame.model.Score;


public class LevelPanel extends JPanel {
    private PlayerController playerController;
    private ScoreController scoreController;
    private Score score;

    private int time = 120;
    private GameController gameController;
    private Image background;
    private Image mask;
    private JLabel scoreDisplay;
    private JLabel timeField;
    public int size = 0;
    private Font titleFont = new Font("TimesRoman", Font.BOLD, 30);

    public LevelPanel(GameController gameController, int level, Image background,Image mask, ScoreController scoreController, BirdFlockController birdFlockController, Score score){
        this.gameController = gameController;
        this.playerController = new PlayerController(scoreController, birdFlockController);
        this.scoreController = scoreController;
        this.score = score;


        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        this.background = background;
        this.mask = mask;



        scoreDisplay = new JLabel("0");
        scoreDisplay.setFont(titleFont);
        scoreDisplay.setForeground(Color.WHITE);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.weighty = 1;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(scoreDisplay, c);
        
        timeField = new JLabel(String.valueOf(time));
        timeField.setFont(titleFont);
        timeField.setForeground(Color.WHITE); 
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weighty = 1;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(timeField, c);

        addMouseListener(new MouseAdapter(){
            @Override 
            public void mousePressed(MouseEvent e){
                playerController.takePhoto(e.getX(),e.getY());
            }
        });

        gameController.startGameLoop();
    
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // drawBackground
        g.drawImage(this.background, 0,0, 1280, 720, null);

        gameController.render(g);
        // drawMask
        g.drawImage(this.mask, 0,0, 1280, 720, null);
    }

    public void updateSec(){
        time -= 1;
        timeField.setText(String.valueOf(time));
    }

    public void update(){
        scoreDisplay.setText(String.valueOf(score.getCurrentScore()));
    }

}
