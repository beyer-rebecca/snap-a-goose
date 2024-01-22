package birdgame.controller;

import birdgame.model.WindowModel;
import birdgame.view.WindowView;

import javax.swing.JPanel;

public class WindowController {
    private WindowView windowView;
    private WindowModel windowModel;

    public WindowController(){
        this.windowView  = new WindowView();
        this.windowModel = new WindowModel(this);
        windowView.setSize(windowModel.WINDOW_WIDTH, windowModel.WINDOW_HEIGHT);
        windowView.setPanel(windowModel.getLoginPanel());
    }

    public void setWindowView(WindowView windowView) {
        this.windowView = windowView;
    }

    public void navigateToPanel(JPanel panel){
        windowView.setContentPane(panel);
        windowView.repaint();
        windowView.revalidate();
    }

    public WindowModel getWindowModel(){
        return this.windowModel;
    }

}
