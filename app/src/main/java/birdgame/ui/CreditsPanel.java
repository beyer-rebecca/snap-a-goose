package birdgame.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.Box;
import javax.imageio.ImageIO;

public class CreditsPanel extends JPanel{

    private Font titleFont = new Font("TimesRoman", Font.BOLD, 30);
    private Font smallFont = new Font("TimesRoman", Font.PLAIN, 15);  
    private Font normalFont = new Font("TimesRoman", Font.BOLD, 20);

    public CreditsPanel(Window window){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Erstellung Backbutton
        CButton backButton = new CButton("<--");
        c.insets = new Insets(10, 10, 0, 10); // Abstand von den Rändern
        c.gridx = 0; // Erste Spalte
        c.gridy = 0; // Erste Zeile
        c.gridwidth = 1; // Nur eine Zelle breit
        c.weightx = 0; // Extra horizontalen Platz nicht ausdehnen
        c.anchor = GridBagConstraints.NORTHWEST;
        this.add(backButton, c);

        backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                window.navTo(window.getMenuPanel());
            } 
        });


        // create headline Credits
        JLabel creditsTitle = new JLabel("Credits");
        creditsTitle.setFont(titleFont);
        c.insets = new Insets(30, 10, 35, 10);
        c.gridx = 0; 
        c.gridy = 0; 
        c.gridwidth = GridBagConstraints.REMAINDER; 
        c.weightx = 1; // Extra horizontalen Platz ausdehnen
        c.anchor = GridBagConstraints.NORTH; // Oben ausrichten
        this.add(creditsTitle, c);

        // create individual Credits

        // credits for programming
        JLabel programLabel = new JLabel("Programming");
        programLabel.setFont(smallFont);
        c.gridx = 0; // Start in der ersten Spalte
        c.gridy++; // Zweite Zeile (unterhalb der Überschrift)
        //c.gridwidth = GridBagConstraints.REMAINDER; // Über die ganze Breite
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.CENTER; // Zentrieren
        c.insets = new Insets(35, 0, 5, 0); // Abstände oben und unten
        this.add(programLabel,c);

        // names for programming
        JLabel programName1Label = new JLabel("Nils Wiemer");
        c.gridy++; // Nächste Zeile
        c.insets = new Insets(0, 0, 5, 0);
        c.anchor = GridBagConstraints.CENTER; // Zentrieren
        programName1Label.setFont(normalFont);
        this.add(programName1Label,c);

        JLabel programName2Label = new JLabel("Rebecca Beyer");
        c.gridy++; // Nächste Zeile
        programName2Label.setFont(normalFont);
        this.add(programName2Label,c);

        // credits for art
        JLabel artLabel = new JLabel("Art");
        artLabel.setFont(smallFont);
        c.gridy++;
        c.insets = new Insets(35, 0, 5, 0); 
        this.add(artLabel,c);

        // names for art
        JLabel artName1Label = new JLabel("Artist1");
        artName1Label.setFont(normalFont);
        c.gridy++; 
        c.insets = new Insets(0, 0, 5, 0);
        this.add(artName1Label,c);

        JLabel artName2Label = new JLabel("Artist2");
        artName2Label.setFont(normalFont);
        c.gridy++; 
        this.add(artName2Label,c);

        // credits for audio
        JLabel audioLabel = new JLabel("Audio and Music");
        audioLabel.setFont(smallFont);
        c.gridy++; 
        c.insets = new Insets(35, 0, 5, 0); 
        this.add(audioLabel,c);

        // names for audio
        JLabel audioName1Label = new JLabel("Musicianname1");
        audioName1Label.setFont(normalFont);
        c.gridy++; 
        c.insets = new Insets(0, 0, 5, 0);
        this.add(audioName1Label,c);

        JLabel audioName2Label = new JLabel("Musicianname2");
        audioName2Label.setFont(normalFont);
        c.gridy++; 
        c.insets = new Insets(0, 0, 50, 0);
        this.add(audioName2Label,c);

        JComponent glue = (JComponent) Box.createVerticalGlue();
        c.gridy++;
        c.weighty = 1; // Diese Komponente nimmt den restlichen vertikalen Raum ein
        c.fill = GridBagConstraints.VERTICAL;
        c.insets = new Insets(0, 0, 50, 0); // 50 Pixel Abstand vom unteren Rand
        this.add(glue, c);

    }
}