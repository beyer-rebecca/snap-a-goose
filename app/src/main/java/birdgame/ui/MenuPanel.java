package birdgame.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MenuPanel extends JPanel{
    private Window window;
    private LevelSelectPanel level;
    public MenuPanel(Window window){
        this.window = window;
        this.level = new LevelSelectPanel(window, this);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        

        // CButton buttonlevel = new CButton("Level");
        CButton buttonlevel = new CButton("Level");
        buttonlevel.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // leave it be until level and game are implemented
                // cause thats how game(loop) and level setup should be done
                // Level1 level1 = new Level1();
                // Game game = new Game(level1);
                window.navTo(level);

            } 
        });
        CButton manuel = new CButton("Manuel");
        CButton highscore = new CButton("Highscore");
        CButton credits = new CButton("Credits");
        CButton sound = new CButton("Sound");
        CButton music = new CButton("Music");
        CButton logout = new CButton("Logout");
        try {
            BufferedImage img = ImageIO.read(getClass().getClassLoader().getResource("sound.png"));
            sound = new CButton(img);
            img = ImageIO.read(getClass().getClassLoader().getResource("musik.png"));
            music = new CButton(img, 50, 50);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        c.insets = new Insets(5, 100, 5, 5);
        c.fill = GridBagConstraints.RELATIVE;
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 2;
        add(buttonlevel, c);
        c.gridx = 0;
        c.gridy = 3;
        add(manuel, c);
        c.gridx = 0;
        c.gridy = 4;
        add(highscore, c);
        c.gridx = 0;
        c.gridy = 5;
        add(credits, c);
        c.anchor = GridBagConstraints.SOUTHEAST;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 6;
        add(logout, c);
        c.weighty = 0;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.gridx = 1;
        c.gridy = 0;
        add(sound, c);
        c.weighty = .75;
        c.gridx = 1;
        c.gridy = 1;
        add(music, c);
        
    }
}
