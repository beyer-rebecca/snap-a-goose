package birdgame;

import org.junit.jupiter.api.Test;

import birdgame.controller.AuthenticationController;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AuthenticationControllerTest {
    @Test void emailVerificationTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<AuthenticationController> classToTest = AuthenticationController.class;
        Method methodToTest = classToTest.getDeclaredMethod("verifyEmail", String.class);
        methodToTest.setAccessible(true);
        assertEquals(true, methodToTest.invoke(null, "max.mustermann@email.com"));
        assertEquals(false, methodToTest.invoke(null, "max.mustermann.email.com"));
    }
    
    
    
    void getDirTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        Class<AuthenticationController> classToTest = AuthenticationController.class;
        Method methodToTest = classToTest.getDeclaredMethod("getDir", (Class<?>[]) null);
        methodToTest.setAccessible(true);
    
        assertEquals(System.getProperty("user.home")+"/.local/share/birdgame/",
                methodToTest.invoke(null));
    }
}
