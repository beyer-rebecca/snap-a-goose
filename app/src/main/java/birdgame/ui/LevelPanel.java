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

import birdgame.controller.WindowController;
import birdgame.controller.GameController;
import birdgame.controller.PlayerController;
import birdgame.controller.ScoreController;
import birdgame.controller.BirdFlockController;
import birdgame.model.Game;
import birdgame.model.Score;


public class LevelPanel extends JPanel {
    private static final Font TITLE_FONT = new Font("TimesRoman", Font.BOLD, 30);

    private PlayerController playerController;
    private ScoreController scoreController;
    private Score score;
    private WindowController windowController;
    private GameController gameController;
    private Game game;

    private Image background;
    private Image mask;
    public int size = 0;

    private final int backgroundWidth;
    private final int backgroundHeight;

    private JLabel scoreDisplay;
    private JLabel timeField;

    private int time;
    

    public LevelPanel(WindowController windowController, GameController gameController, int level, Image background,Image mask, 
                      ScoreController scoreController, BirdFlockController birdFlockController, Score score, Game game){
        this.gameController = gameController;
        this.playerController = new PlayerController(scoreController, birdFlockController);
        this.scoreController = scoreController;
        this.score = score;
        this.time = gameController.getTime();
        this.backgroundWidth = windowController.getWINDOW_WIDHT();
        this.backgroundHeight = windowController.getWINDOW_HEIGHT();
        this.background = background;
        this.mask = mask;
        this.game = game;

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        scoreDisplay = new JLabel("0");
        scoreDisplay.setFont(TITLE_FONT);
        scoreDisplay.setForeground(Color.WHITE);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.weighty = 1;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(scoreDisplay, c);
        
        timeField = new JLabel(String.valueOf(time));
        timeField.setFont(TITLE_FONT);
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
        g.drawImage(this.background, 0,0,backgroundWidth,backgroundHeight, null);

        gameController.render(g);
        // drawMask
        g.drawImage(this.mask, 0,0,backgroundWidth, backgroundHeight, null);
    }


    public void render(){
        scoreDisplay.setText(String.valueOf(score.getCurrentScore()));
        timeField.setText(String.valueOf(game.getTime()));
    }

}
