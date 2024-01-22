package birdgame.controller;

import birdgame.view.LoginPanel;

public class LoginController {
    public static void loadRegister(LoginPanel loginPanel){
        preparePanel(loginPanel);
        loginPanel.registerView();
    }
    
    public static void loadLogin(LoginPanel loginPanel){
        preparePanel(loginPanel);
        loginPanel.loginView();
    }

    public static void loadLoginFail(LoginPanel loginPanel){
        preparePanel(loginPanel);
        loginPanel.loginFailView();
        
    }
    public static void loadRegisterFail(LoginPanel loginPanel){
        preparePanel(loginPanel);
        loginPanel.registerFailView();
    }

    private static void preparePanel(LoginPanel loginPanel) {
        loginPanel.removeAll();
        loginPanel.revalidate();
        loginPanel.repaint();
    }
        
}
