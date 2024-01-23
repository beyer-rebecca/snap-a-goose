package birdgame;

import org.junit.jupiter.api.Test;

import birdgame.controller.HighscoreController;

import static org.junit.jupiter.api.Assertions.*;

class HighscoreControllerTest {

    @Test
    void getUserHighscoreTest() {
        assertEquals(1, HighscoreController.getHighscore("Kim Beispiel", 1));
        assertEquals(100, HighscoreController.getHighscore("Axel Muster", 1));
    }
}
