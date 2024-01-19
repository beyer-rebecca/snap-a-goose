package birdgame.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class CTextField extends JTextField {
    private Font font = new Font("TimesRoman", Font.BOLD, 50);
    CTextField(Color fgColor){
        setBorder(null);
        setOpaque(false);
        setFont(font);
        setForeground(fgColor);
        setEditable(false);
    }
}
