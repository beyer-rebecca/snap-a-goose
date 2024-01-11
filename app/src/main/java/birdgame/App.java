package birdgame;

import birdgame.ui.WindowView;
import birdgame.model.WindowModel;
import birdgame.controller.WindowController;

public class App {
    public String getGreeting() {
        return "Game starting...";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        
        WindowModel windowModel = new WindowModel();
        WindowController windowController = new WindowController(windowModel);
        WindowView windowView = new WindowView();
        windowController.setWindowView(windowView);
    }
}
