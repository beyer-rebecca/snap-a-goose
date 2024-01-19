package birdgame.controller;

import birdgame.view.LoginPanel;

public class LoginController {
    public static void loadRegister(LoginPanel loginPanel){
        loginPanel.removeAll();
        loginPanel.revalidate();
        loginPanel.repaint();
        loginPanel.registerView();
    }
    
    public static void loadLogin(LoginPanel loginPanel){
        loginPanel.removeAll();
        loginPanel.revalidate();
        loginPanel.repaint();
        loginPanel.loginView();
    }

    public static void loadLoginFail(LoginPanel loginPanel){
        loginPanel.removeAll();
        loginPanel.revalidate();
        loginPanel.repaint();
        loginPanel.loginFailView();
        
    }
    public static void loadRegisterFail(LoginPanel loginPanel){
        loginPanel.removeAll();
        loginPanel.revalidate();
        loginPanel.repaint();
        loginPanel.registerFailView();
    }
        
}
