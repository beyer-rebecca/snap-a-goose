package birdgame.controller;

import birdgame.view.LoginPanel;

/**
 * The LoginController class manages the display of different login and registration views.
 * It provides methods to load various states of the LoginPanel such as the registration view,
 * login view, and their respective failure views.
 */
public class LoginController {

    /**
     * Loads the registration view in the provided LoginPanel.
     *
     * @param loginPanel The LoginPanel where the registration view will be loaded.
     */
    public static void loadRegister(LoginPanel loginPanel){
        preparePanel(loginPanel);
        loginPanel.registerView();
    }
    
    /**
     * Loads the login view in the provided LoginPanel.
     *
     * @param loginPanel The LoginPanel where the login view will be loaded.
     */
    public static void loadLogin(LoginPanel loginPanel){
        preparePanel(loginPanel);
        loginPanel.loginView();
    }

    /**
     * Loads the login failure view in the provided LoginPanel.
     *
     * @param loginPanel The LoginPanel where the login failure view will be loaded.
     */
    public static void loadLoginFail(LoginPanel loginPanel){
        preparePanel(loginPanel);
        loginPanel.loginFailView();
        
    }

    /**
     * Loads the registration failure view in the provided LoginPanel.
     *
     * @param loginPanel The LoginPanel where the registration failure view will be loaded.
     */
    public static void loadRegisterFail(LoginPanel loginPanel){
        preparePanel(loginPanel);
        loginPanel.registerFailView();
    }

    /**
     * Prepares the LoginPanel for a new view. This includes clearing the panel and
     * revalidating its layout.
     *
     * @param loginPanel The LoginPanel to be prepared.
     */
    private static void preparePanel(LoginPanel loginPanel) {
        loginPanel.removeAll();
        loginPanel.revalidate();
        loginPanel.repaint();
    }
        
}
