package birdgame.controller;

import birdgame.model.WindowModel;
import birdgame.ui.WindowView;

import javax.swing.JPanel;

public class WindowController {
    private WindowView windowView;
    private WindowModel windowModel;

    public WindowController(WindowView windowView,WindowModel windowModel){
        this.windowView  = windowView;
        this.windowModel = windowModel;
    }

    public void setWindowView(WindowView windowView) {
        this.windowView = windowView;
    }

    public void navTo(JPanel panel){
        windowModel.setCurrentPanel(panel);
        windowView.setPanel(panel);
    }
}
