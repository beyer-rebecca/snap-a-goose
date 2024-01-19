package birdgame;

import birdgame.model.WindowModel;
import birdgame.view.WindowView;
import birdgame.controller.WindowController;

public class App {
    public String getGreeting() {
        return "Game starting...";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        
        new WindowController();
    }
}
