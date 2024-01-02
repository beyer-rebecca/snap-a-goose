package birdgame.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class LevelPanel extends JPanel {
    LevelPanel(Window window){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        CTextField score = new CTextField();
        CTextField time = new CTextField();

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
    }
}
