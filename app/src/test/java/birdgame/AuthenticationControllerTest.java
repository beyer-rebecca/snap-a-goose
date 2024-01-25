package birdgame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import birdgame.controller.AuthenticationController;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AuthenticationControllerTest {
    @Test
    void emailVerificationTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<AuthenticationController> classToTest = AuthenticationController.class;
        Method methodToTest = classToTest.getDeclaredMethod("verifyEmail", String.class);
        methodToTest.setAccessible(true);
        
        assertEquals(true, methodToTest.invoke(null, "kimbeispiel@example.com"));
        assertEquals(false, methodToTest.invoke(null, "kimbeispiel.example.com"));
    }
    
    @Test
    @DisabledOnOs({OS.WINDOWS, OS.MAC})
    void getDirOtherTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        Class<AuthenticationController> classToTest = AuthenticationController.class;
        Method methodToTest = classToTest.getDeclaredMethod("getDir", (Class<?>[]) null);
        methodToTest.setAccessible(true);
    
        assertEquals(System.getProperty("user.home")+"/.local/share/birdgame/",
                methodToTest.invoke(null));
    }
    
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void getDirWindowsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        Class<AuthenticationController> classToTest = AuthenticationController.class;
        Method methodToTest = classToTest.getDeclaredMethod("getDir", (Class<?>[]) null);
        methodToTest.setAccessible(true);
    
        assertEquals(System.getProperty("user.home")+"/.local/share/birdgame/",
                methodToTest.invoke(null));
    }
    
    @Test
    @EnabledOnOs(OS.MAC)
    void getDirMacTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        Class<AuthenticationController> classToTest = AuthenticationController.class;
        Method methodToTest = classToTest.getDeclaredMethod("getDir", (Class<?>[]) null);
        methodToTest.setAccessible(true);
    
        assertEquals(System.getProperty("user.home")+"/.local/share/birdgame/",
                methodToTest.invoke(null));
    }
}
