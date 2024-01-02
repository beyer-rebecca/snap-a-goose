package birdgame.ui;

import java.awt.Font;

import javax.swing.JTextField;

public class CTextField extends JTextField {
    private Font font = new Font("TimesRoman", Font.BOLD, 20);
    CTextField(){
        setBorder(null);
        setBackground(null);
        setFont(font);
    }
}
