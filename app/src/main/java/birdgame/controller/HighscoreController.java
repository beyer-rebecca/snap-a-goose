package birdgame.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Verwaltet Highscores (ändert highscores fügt neue users dazu, liiest highscores), wird bei Anwendungs-Start initialisiert
public class HighscoreController {
    private static final String FILE_PATH = "highscore.json";
    private JSONObject highscoreData;
    private static HighscoreController instance;

    private HighscoreController() {
        initializeFile();
    }

    //Singleton muster anwenden
    public static HighscoreController getInstance() {
        if (instance == null) {
            instance = new HighscoreController();
        }
        return instance;
    }

    private void initializeFile() {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            JSONParser jsonParser = new JSONParser();
            highscoreData = (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            highscoreData = new JSONObject();
            saveHighscoreData();
        }
    }

    private void saveHighscoreData() {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(highscoreData.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewUser(String user) {
        JSONObject userData = new JSONObject();
        userData.put("level1", 0);
        userData.put("level2", 0);
        userData.put("level3", 0);
        highscoreData.put(user, userData);
        saveHighscoreData();
    }

    public int getHighscore(String user, int level) {
        if (highscoreData.containsKey(user)) {
            JSONObject userData = (JSONObject) highscoreData.get(user);
            return (userData.getOrDefault("level" + level, 0)).intValue();
        }
        return 0;
    }

    public boolean isNewHighscore(String user, int level, int score) {
        return score > getHighscore(user, level);
    }

    public void updateHighscore(String user, int level, int finalScore) {
        if (isNewHighscore(user, level, finalScore)){
            if (highscoreData.containsKey(user)) {
                JSONObject userData = (JSONObject) highscoreData.get(user);
                userData.put("level" + level, finalScore);
                saveHighscoreData();
            }
        }
    }
}