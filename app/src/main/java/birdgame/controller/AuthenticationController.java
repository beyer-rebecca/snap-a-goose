package birdgame.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.apache.commons.lang3.SystemUtils;

public class AuthenticationController{
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                                              "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String WINDOWS_PATH = "\\AppData\\Roaming\\birdgame\\birdgame.json";
    private static final String OTHER_OS_PATH = "/.local/share/birdgame/birdgame.json";
    private static final String WINDOWS_DIR = "\\AppData\\Roaming\\birdgame";
    private static final String OTHER_OS_DIR = "/.local/share/birdgame/";



    private static boolean verifyEmail(String email){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(email).matches();
    }

    public static boolean verifyLogin (String username, String rawPassword) {
        JSONParser parser = new JSONParser();
        JSONObject combinedObject;
        String path = getPath();
        String dir = getDir();
        
        File f = new File(path);
        if(!f.exists()) { 
            try{
                new File(dir).mkdirs();
                f.createNewFile();
                FileWriter writer = new FileWriter(f);
                writer.write("{\"Axel Muster\":{\"scoreLevel1\":100,\"password\":\"$2a$10$C6F9NwYdz60f0AQE\\/WWOCOVMkcdDYjAZcjXsoAL5XCXxgXl2xS2uK\",\"email\":\"axel@muster.com\"},\"Kim Beispiel\":{\"scoreLevel1\":1,\"password\":\"$2a$10$oDrX2AOBxWl9qeqj6S966uSTctOsvofy0j0gLNuK94qowm4dC7awa\",\"email\":\"kim@beispiel.com\"}}");
                writer.flush();
                writer.close();
            }catch(IOException e){
                System.out.println(e);
            }
        }
        
        try(FileReader reader = new FileReader(path)){
            Object obj = parser.parse(reader);
            combinedObject = (JSONObject) obj;
            JSONObject innerObject = (JSONObject) combinedObject.get(username);
            if(innerObject == null) return false;
            String password = innerObject.get("password").toString();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if(encoder.matches(rawPassword, password)){
                return true;
            }
        } catch(IOException | org.json.simple.parser.ParseException e){
            System.out.println(e);
        }
        return false;
    }

    private static String getPath() {
        if (SystemUtils.IS_OS_WINDOWS) {
            return System.getProperty("user.home") + WINDOWS_PATH;
        } else {
            return System.getProperty("user.home") + OTHER_OS_PATH;
        }
    }

    private static String getDir(){
        if(SystemUtils.IS_OS_WINDOWS){
            return System.getProperty("user.home") + WINDOWS_DIR;
        }
        else{
            return System.getProperty("user.home") + OTHER_OS_DIR;
        }
    }


    @SuppressWarnings("unchecked")
    public static boolean storeData(String username, String email, String password){
        FileWriter file;
        JSONParser parser = new JSONParser();
        JSONObject innerObject= new JSONObject();

        if(verifyEmail(email)){
            innerObject.put("email", email);
        } else {
            return false;
        }    

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pas = encoder.encode(password);
        innerObject.put("password", pas);
            
        JSONObject outerObject = new JSONObject();
        outerObject.put(username, innerObject);

        System.out.println(outerObject.toString());

        String path = getPath();
        String dir = getDir();
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
                new File(dir).mkdirs();
                f.createNewFile();
                FileWriter writer = new FileWriter(f);
                writer.write("{\"Axel Muster\":{\"scoreLevel1\":100,\"password\":\"$2a$10$C6F9NwYdz60f0AQE\\/WWOCOVMkcdDYjAZcjXsoAL5XCXxgXl2xS2uK\",\"email\":\"axel@muster.com\"},\"Kim Beispiel\":{\"scoreLevel1\":1,\"password\":\"$2a$10$oDrX2AOBxWl9qeqj6S966uSTctOsvofy0j0gLNuK94qowm4dC7awa\",\"email\":\"kim@beispiel.com\"}}");
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
            return true;
        }catch(IOException | org.json.simple.parser.ParseException e){
            System.out.println(e);
        }
        return false;
    }
}
