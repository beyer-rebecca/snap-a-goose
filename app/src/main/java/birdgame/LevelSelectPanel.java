package birdgame;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.imageio.ImageIO;


public class LevelSelectPanel extends JPanel{
    public LevelSelectPanel(Window window, MenuPanel menu){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        

        CButton level1 = new CButton();
        CButton level2 = new CButton();
        CButton level3 = new CButton();
        CButton back = new CButton("<--");
        try {
            BufferedImage img = ImageIO.read(getClass().getClassLoader().getResource("pol.png"));
            level1 = new CButton(img);
            level2 = new CButton(img);
            level3 = new CButton(img);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        back.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                // leave it be until level and game are implemented
                // cause thats how game(loop) and level setup should be done
                // Level1 level1 = new Level1();
                // Game game = new Game(level1);
                window.navTo(menu);

            } 
        });

        c.insets = new Insets(0, 0, 0, 0);
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
        c.insets = new Insets(10,10,10,10);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridy=0;
        c.gridx = 1;
        add(back, c);
       
        
    }
}
