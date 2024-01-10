package birdgame;

import birdgame.ui.Window;
import birdgame.game.Game;

public class App {
    public String getGreeting() {
        return "Game starting...";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        
        new Window();
        
    }
}
