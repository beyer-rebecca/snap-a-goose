package birdgame.model;

import javax.swing.JPanel;

public class WindowModel {
    public static int WINDOW_WIDHT = 1280;
    public static int WINDOW_HEIGHT = 720;
    private String currentPanel;

    public WindowModel(){
        this.currentPanel = "menuPanel";
    }


    public JPanel getCurrentPanel(){
        return this.currentPanel;
    }

    public void setCurrentPanel(String newPanel){
        this.currentPanel = newPanel;
    }
}
