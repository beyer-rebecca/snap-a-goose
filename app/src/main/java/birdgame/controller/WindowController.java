package birdgame.controller;

import birdgame.model.WindowModel;
import birdgame.view.WindowView;

import javax.swing.JPanel;

/**
 * The WindowCntroller class controls the main application window, managing the display of different panels within the window.
 * This controller is responsible for initializing the window view and model, and navigating between
 * various panels in the application.
 */
public class WindowController {
    private WindowView windowView;
    private WindowModel windowModel;

    /**
     * Constructs a WindowController, initializing the window view and model.
     * Sets the initial size and panel of the window view based on the model.
     */
    public WindowController(){
        this.windowView  = new WindowView();
        this.windowModel = new WindowModel(this);
        windowView.setSize(windowModel.WINDOW_WIDTH, windowModel.WINDOW_HEIGHT);
        windowView.setPanel(windowModel.getLoginPanel());
    }

    /**
     * Sets the window view for this controller.
     *
     * @param windowView The WindowView to be used by this controller.
     */
    public void setWindowView(WindowView windowView) {
        this.windowView = windowView;
    }

    /**
     * Navigates to a specified panel within the application window.
     * This method updates the content pane of the window view to display the specified panel.
     *
     * @param panel The JPanel to display in the application window.
     */
    public void navigateToPanel(JPanel panel){
        windowView.setContentPane(panel);
        windowView.repaint();
        windowView.revalidate();
    }

    /**
     * Retrieves the window model associated with this controller.
     *
     * @return The WindowModel instance.
     */
    public WindowModel getWindowModel(){
        return this.windowModel;
    }

}
