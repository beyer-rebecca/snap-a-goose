package birdgame.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The HighscoreController class manages the highscores for the Bird Game application. This controller is responsible for
 * reading and updating highscores, adding new users, and initializing highscores at application start.
 */
public class HighscoreController {
    /**
     * Retrieves the highscore for a specific user and level.
     *
     * @param username The username for which to retrieve the highscore.
     * @param level The game level for which to retrieve the highscore.
     * @return The highscore as an integer, or 0 if not found or on error.
     */
    public static int getHighscore(String username, int level){
        String path = AuthenticationController.getPath();

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
        String path = AuthenticationController.getPath();
        try (FileReader reader = new FileReader(path))
        {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONObject combinedObject = (JSONObject) obj;
            JSONObject innerObject = (JSONObject) combinedObject.get(username);
            if(innerObject.get("scoreLevel" + level) == null || 
                    innerObject.get("scoreLevel" + level) != null && 
                    Integer.valueOf(innerObject.get("scoreLevel" + level).toString()) < score){
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
