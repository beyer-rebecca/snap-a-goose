package birdgame.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.SystemUtils;

/**
 * The HighscoreController class manages the highscores for the Bird Game application. This controller is responsible for
 * reading and updating highscores, adding new users, and initializing highscores at application start.
 */
public class HighscoreController {
    private static final String WINDOWS_PATH = "\\AppData\\Roaming\\birdgame\\birdgame.json";
    private static final String OTHER_OS_PATH = "/.local/share/birdgame/birdgame.json";
    private static final String MACOS_PATH = "/Library/Preferences/birdgame/birdgame.json";
    
    /**
     * Retrieves the file path for storing highscore data based on the operating system.
     *
     * @return The file path as a string.
     */
    private static String getFilePath() {
        if (SystemUtils.IS_OS_WINDOWS) {
            return System.getProperty("user.home") + WINDOWS_PATH;
        } else if(SystemUtils.IS_OS_MAC){
            return System.getProperty("user.home") + MACOS_PATH;
        } else {
            return System.getProperty("user.home") + OTHER_OS_PATH;
        }
    }

    /**
     * Retrieves the highscore for a specific user and level.
     *
     * @param username The username for which to retrieve the highscore.
     * @param level The game level for which to retrieve the highscore.
     * @return The highscore as an integer, or 0 if not found or on error.
     */
    public static int getHighscore(String username, int level){
        String path = getFilePath();

        try(FileReader reader = new FileReader(path))
        {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONObject combinedObject = (JSONObject) obj;
            JSONObject innerObject = (JSONObject) combinedObject.get(username);
            if(innerObject == null || innerObject.get("scoreLevel" + level) == null) return 0;
            return Integer.valueOf(innerObject.get("scoreLevel" + level).toString());
        } catch(IOException | ParseException e){
            System.out.println(e);
        }

        return -1;
    }
    
    /**
     * Updates bzw. sets the highscore for a specific user and level.
     *
     * @param username The username for which to update the highscore.
     * @param level The game level for which to update the highscore.
     * @param score The new highscore to set.
     */
    
    @SuppressWarnings("unchecked")
    public static void updateHighscore(String username, int level, int score){
        String path = getFilePath();
        try (FileReader reader = new FileReader(path))
        {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONObject combinedObject = (JSONObject) obj;
            JSONObject innerObject = (JSONObject) combinedObject.get(username);
            if(innerObject.get("scoreLevel" + level) != null && Integer.valueOf(innerObject.get("scoreLevel" + level).toString()) < score){
                innerObject.put("scoreLevel" + level, score);
                combinedObject.put(username, innerObject);
                FileWriter writer = new FileWriter(path);
                writer.write(combinedObject.toString());
                writer.flush();
                writer.close();
            } else if(innerObject.get("scoreLevel" + level) == null){
                innerObject.put("scoreLevel" + level, score);
                combinedObject.put(username, innerObject);
                FileWriter writer = new FileWriter(path);
                writer.write(combinedObject.toString());
                writer.flush();
                writer.close();
            }
        } catch(IOException | ParseException e){
            System.out.println(e);
        }
    }
}
