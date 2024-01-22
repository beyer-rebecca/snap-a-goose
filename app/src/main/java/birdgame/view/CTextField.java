package birdgame.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

/**
 * The class CTextField is a class that extends JtextField to provide a customized text field
 * with a specific font, color and other properties.
 */
public class CTextField extends JTextField {
    private Font font = new Font("TimesRoman", Font.BOLD, 50);

    /**
     * Constructs a CTextField with specified foreground color.
     * The text field is set to be non-editable, with no border,
     * and with a predefined font and opacity.
     *
     * @param fgColor The foreground color of the text field.
     */
    CTextField(Color fgColor){
        setBorder(null); // Remove the border
        setOpaque(false);  // Make it transparent
        setFont(font);
        setForeground(fgColor);
        setEditable(false);
    }
}
