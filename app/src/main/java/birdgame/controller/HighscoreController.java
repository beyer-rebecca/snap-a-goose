package birdgame.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.SystemUtils;

// Verwaltet Highscores (ändert highscores fügt neue users dazu, liiest highscores), wird bei Anwendungs-Start initialisiert
public class HighscoreController {

    public static int getHighscore(String username, int level){
        String path;
        if(SystemUtils.IS_OS_WINDOWS){
            path = System.getProperty("user.home") + "\\AppData\\Roaming\\birdgame\\" + "birdgame.json";
        }
        else{
            path = System.getProperty("user.home") + "/.local/share/birdgame/" + "birdgame.json";
        }

        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader(path))
        {
            Object obj = parser.parse(reader);
            JSONObject combinedObject = (JSONObject) obj;
            JSONObject innerObject = (JSONObject) combinedObject.get(username);
            if(innerObject == null || innerObject.get("scoreLevel" + level) == null) return 0;
            return Integer.valueOf(innerObject.get("scoreLevel" + level).toString());

        }catch(IOException | ParseException e){
            System.out.println(e);
        }

        return 0;
        
    }
    
    @SuppressWarnings("unchecked")
    public static void updateHighscore(String username, int level, int score){
        
        System.out.println("update score");
        String path;
        if(SystemUtils.IS_OS_WINDOWS){
            path = System.getProperty("user.home") + "\\AppData\\Roaming\\birdgame\\" + "birdgame.json";
        }
        else{
            path = System.getProperty("user.home") + "/.local/share/birdgame/" + "birdgame.json";
        }

        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader(path))
        {
            Object obj = parser.parse(reader);
            JSONObject combinedObject = (JSONObject) obj;
            JSONObject innerObject = (JSONObject) combinedObject.get(username);
            System.out.println(innerObject.toString());
            if(innerObject.get("scoreLevel" + level) != null && Integer.valueOf(innerObject.get("scoreLevel" + level).toString()) < score){
                innerObject.put("scoreLevel" + level, score);
                combinedObject.put(username, innerObject);
                System.out.println(combinedObject.toString());
                FileWriter writer = new FileWriter(path);
                writer.write(combinedObject.toString());
                writer.flush();
                writer.close();
            }else if(innerObject.get("scoreLevel" + level) == null){
                innerObject.put("scoreLevel" + level, score);
                combinedObject.put(username, innerObject);
                System.out.println(combinedObject.toString());
                FileWriter writer = new FileWriter(path);
                writer.write(combinedObject.toString());
                writer.flush();
                writer.close();
            }

        }catch(IOException | ParseException e){
            System.out.println(e);
        }
    }
}
