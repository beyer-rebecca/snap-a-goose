package birdgame.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import birdgame.ui.Window;

import javax.swing.JPanel;

import birdgame.game.Bird;
import birdgame.game.Game;

public class LevelPanel extends JPanel {
    public Bird bird;
    private Game game;
    public LevelPanel(Window window){
        bird = new Bird(500,500, 50, 100);
        this.game = window.getGame();
        System.out.println(this.game);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        CTextField score = new CTextField();
        CTextField time = new CTextField();

        setBackground(Color.GRAY);

        score.setText("0");
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.weighty = 1;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(score, c);
        time.setText("120");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weighty = 1;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(time, c);

        window.getGame().startGameLoop();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        game.render(g);
    }
}
