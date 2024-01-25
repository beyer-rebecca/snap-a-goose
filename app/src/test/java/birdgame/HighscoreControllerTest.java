package birdgame;

import org.junit.jupiter.api.Test;

import birdgame.controller.HighscoreController;

import static org.junit.jupiter.api.Assertions.*;

class HighscoreControllerTest {

    @Test
    void getUserHighscoreTest() {
        assertEquals(1, HighscoreController.getHighscore("Kim Beispiel", 1));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 1));
        assertEquals(0, HighscoreController.getHighscore("Kim Beispiel", 5));
        assertEquals(0, HighscoreController.getHighscore("Kim Beispiel", 0));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 0));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 5));
        
    }
}
