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
        windowView.setPanel(panel);
    }

    public int getWINDOW_WIDHT(){
        return windowModel.getWINDOW_WIDHT();
    }

    public int getWINDOW_HEIGHT(){
        return windowModel.getWINDOW_HEIGHT();
    }


}
