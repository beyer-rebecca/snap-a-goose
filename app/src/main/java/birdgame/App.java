package birdgame;

import birdgame.controller.WindowController;

/**
 * The {@code App} class serves as the entry point for the Bird Game application.
 * It initializes the game and starts the user interface.
 */
public class App {
    public String getGreeting() {
        return "Game starting...";
    }

    /**
     * The main method that serves as the entry point of the application.
     * It prints the greeting message to the console and initializes the
     * {@link birdgame.controller.WindowController} to start the user interface.
     *
     * @param args An array of command-line arguments for the application.
     */
    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        
        // Initialize the window controller which sets up the game UI
        new WindowController();
    }
}
