package birdgame.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import birdgame.game.Bird;
import birdgame.game.Game;

public class LevelPanel extends JPanel {
    private int time = 120;
    public Bird bird;
    private Game game;
    private Image background;
    CTextField score = new CTextField();
    CTextField timeField = new CTextField();
    public ArrayList<Bird> birds = new ArrayList<Bird>();
    private Random rand = new Random();
    public int size = 0;
    public LevelPanel(Game game, Image background){
        this.game = game;

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        this.background = background;



        score.setText("0");
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.weighty = 1;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(score, c);
        timeField.setText("120");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weighty = 1;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(timeField, c);

        game.startGameLoop();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //drawBackground
        g.drawImage(this.background, 0,0, 1280, 720, null);

        game.render(g);
    }
    public void update(){
        time -= 1;
        timeField.setText(String.valueOf(time));
        // spawn();
    }
    public void spawn(){
        birds.add(new Bird(rand.nextInt(100)*(-1), rand.nextInt(620), 50, 100));

    }
}
