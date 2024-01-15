package birdgame.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.apache.commons.lang3.SystemUtils;

public class AuthenticationController{


    public static boolean verifyPassword (String username, String rawPassword) {

        JSONParser parser = new JSONParser();
        JSONObject combinedObject;
        
        String path;
        if(SystemUtils.IS_OS_WINDOWS){
            path = System.getProperty("user.home") + "\\AppData\\Roaming\\birdgame\\" + "birdgame.json";
        }
        else{
            path = System.getProperty("user.home") + "/.local/share/birdgame/" + "birdgame.json";
        }
        
        try(FileReader reader = new FileReader(path))
        {
            Object obj = parser.parse(reader);
            combinedObject = (JSONObject) obj;
            JSONObject innerObject = (JSONObject) combinedObject.get(username);
            String password = innerObject.get("password").toString();

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if(encoder.matches(rawPassword, password)){
                return true;
            }

        }catch(IOException | org.json.simple.parser.ParseException e){
            System.out.println(e);
        }
        return false;

    }

    @SuppressWarnings("unchecked")
    public static void storeData(String username, String email, String password){
        FileWriter file;
        JSONParser parser = new JSONParser();
        
        JSONObject innerObject= new JSONObject();
        innerObject.put("email", email);
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pas = encoder.encode(password);
        innerObject.put("password", pas);
            
        JSONObject outerObject = new JSONObject();
        outerObject.put(username, innerObject);

        System.out.println(outerObject.toString());

        String path;
        if(SystemUtils.IS_OS_WINDOWS){
            path = System.getProperty("user.home") + "\\AppData\\Roaming\\birdgame\\" + "birdgame.json";
            new File(System.getProperty("user.home") + "\\AppData\\Roaming\\birdgame").mkdirs();
        }
        else{
            path = System.getProperty("user.home") + "/.local/share/birdgame/" + "birdgame.json";
            new File(System.getProperty("user.home") + "/.local/share/birdgame").mkdirs();
        }

        File f = new File(path);
        if(!f.exists()) { 
            try{
                f.createNewFile();
                FileWriter writer = new FileWriter(f);
                writer.write("{}");
                writer.flush();
                writer.close();
            }catch(IOException e){
                System.out.println(e);
            }
        }

        try(FileReader reader = new FileReader(path))
        {
            Object obj = parser.parse(reader);
            JSONObject combinedObject = (JSONObject) obj;
            combinedObject.put(username, innerObject);
            file = new FileWriter(path);
            file.write(combinedObject.toString());

            file.flush();
            file.close();
        }catch(IOException | org.json.simple.parser.ParseException e){
            System.out.println(e);
        }
    }
}
