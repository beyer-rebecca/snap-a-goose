package birdgame.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

import birdgame.game.Game;
import birdgame.game.PlayerController;
import birdgame.game.ScoreController;
import birdgame.model.Score;


public class LevelPanel extends JPanel {
    private PlayerController playerController;
    private ScoreController scoreController;
    private Score score;

    private int time = 120;
    private Game game;
    private Image background;
    private Image mask;
    private JLabel scoreDisplay;
    private JLabel timeField;
    public int size = 0;
    private Font titleFont = new Font("TimesRoman", Font.BOLD, 30);

    public LevelPanel(Game game, int level, Image background,Image mask, ScoreController scoreController, Score score){
        this.game = game;
        this.playerController = new PlayerController(game, scoreController);
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

        game.startGameLoop();
    
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // drawBackground
        g.drawImage(this.background, 0,0, 1280, 720, null);

        game.render(g);
        // drawMask
        g.drawImage(this.mask, 0,0, 1280, 720, null);
    }

    public void update(){
        time -= 1;
        timeField.setText(String.valueOf(time));
        scoreDisplay.setText(String.valueOf(score.getCurrentScore()));
    }

}
