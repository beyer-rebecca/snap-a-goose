package birdgame.controller;

import birdgame.model.WindowModel;
import birdgame.ui.WindowView;

import javax.swing.JPanel;

public class WindowController {
    private WindowView windowView;
    private WindowModel windowModel;

    public WindowController(){
        this.windowView  = new WindowView();
        this.windowModel = new WindowModel(this);
        windowView.setSize(windowModel.getWINDOW_WIDHT(), windowModel.getWINDOW_HEIGHT());
        //windowView.setPanel(windowModel.getLoginPanel());
        windowView.setPanel(windowModel.getGameOverPanel());
    }

    public void setWindowView(WindowView windowView) {
        this.windowView = windowView;
    }

    public void navTo(JPanel panel){
        windowView.setContentPane(panel);
        windowView.repaint();
        windowView.revalidate();
    }

    public WindowModel getWindowModel(){
        return this.windowModel;
    }

}
