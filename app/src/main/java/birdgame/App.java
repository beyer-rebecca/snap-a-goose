package birdgame;

import birdgame.controller.Game;
import birdgame.ui.Window;

public class App {
    public String getGreeting() {
        return "Game starting...";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        
        new Window();
        
    }
}
