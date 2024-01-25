package birdgame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import birdgame.controller.HighscoreController;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class HighscoreControllerTest {

    @Test
    @DisabledOnOs({OS.WINDOWS, OS.MAC})
    void getUserHighscoreOtherTest() throws IOException {
        String dir = System.getProperty("user.home") + "/.local/share/birdgame/";
        String path = System.getProperty("user.home") + "/.local/share/birdgame/birdgame.json";
        
        File f = new File(path);
        
        if(f.exists()){
            f.delete();
        }
        
        new File(dir).mkdirs();
        f.createNewFile();
        FileWriter writer = new FileWriter(f);
        writer.write("{\"Axel Muster\":{\"scoreLevel1\":100,\"password\":\"$2a$10$C6F9NwYdz60f0AQE\\/WWOCOVMkcdDYjAZcjXsoAL5XCXxgXl2xS2uK\",\"email\":\"axel@muster.com\"},\"Kim Beispiel\":{\"scoreLevel1\":1,\"password\":\"$2a$10$oDrX2AOBxWl9qeqj6S966uSTctOsvofy0j0gLNuK94qowm4dC7awa\",\"email\":\"kim@beispiel.com\"}}");
        writer.flush();
        writer.close();

        
        assertEquals(1, HighscoreController.getHighscore("Kim Beispiel", 1));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 1));
        assertEquals(0, HighscoreController.getHighscore("Kim Beispiel", 5));
        assertEquals(0, HighscoreController.getHighscore("Kim Beispiel", 0));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 0));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 5));
        
    }
    
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void getUserHighscoreWindowsTest() throws IOException {
        String dir = System.getProperty("user.home") + "\\AppData\\Roaming\\birdgame";
        String path = System.getProperty("user.home") + "\\AppData\\Roaming\\birdgame\\birdgame.json";
        
        File f = new File(path);

        if(f.exists()){
            f.delete();
        }
        
        new File(dir).mkdirs();
        f.createNewFile();
        FileWriter writer = new FileWriter(f);
        writer.write("{\"Axel Muster\":{\"scoreLevel1\":100,\"password\":\"$2a$10$C6F9NwYdz60f0AQE\\/WWOCOVMkcdDYjAZcjXsoAL5XCXxgXl2xS2uK\",\"email\":\"axel@muster.com\"},\"Kim Beispiel\":{\"scoreLevel1\":1,\"password\":\"$2a$10$oDrX2AOBxWl9qeqj6S966uSTctOsvofy0j0gLNuK94qowm4dC7awa\",\"email\":\"kim@beispiel.com\"}}");
        writer.flush();
        writer.close();

        
        assertEquals(1, HighscoreController.getHighscore("Kim Beispiel", 1));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 1));
        assertEquals(0, HighscoreController.getHighscore("Kim Beispiel", 5));
        assertEquals(0, HighscoreController.getHighscore("Kim Beispiel", 0));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 0));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 5));
        
    }
    
    @Test
    @EnabledOnOs(OS.MAC)
    void getUserHighscoreMacTest() throws IOException {
        String dir = System.getProperty("user.home") + "/Library/Preferences/birdgame/";
        String path = System.getProperty("user.home") + "/Library/Preferences/birdgame/birdgame.json";
        
        File f = new File(path);
        
        if(f.exists()){
            f.delete();
        }
        
        new File(dir).mkdirs();
        f.createNewFile();
        FileWriter writer = new FileWriter(f);
        writer.write("{\"Axel Muster\":{\"scoreLevel1\":100,\"password\":\"$2a$10$C6F9NwYdz60f0AQE\\/WWOCOVMkcdDYjAZcjXsoAL5XCXxgXl2xS2uK\",\"email\":\"axel@muster.com\"},\"Kim Beispiel\":{\"scoreLevel1\":1,\"password\":\"$2a$10$oDrX2AOBxWl9qeqj6S966uSTctOsvofy0j0gLNuK94qowm4dC7awa\",\"email\":\"kim@beispiel.com\"}}");
        writer.flush();
        writer.close();

        
        assertEquals(1, HighscoreController.getHighscore("Kim Beispiel", 1));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 1));
        assertEquals(0, HighscoreController.getHighscore("Kim Beispiel", 5));
        assertEquals(0, HighscoreController.getHighscore("Kim Beispiel", 0));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 0));
        assertEquals(0, HighscoreController.getHighscore("Kim Muster", 5));
        
    }
}
