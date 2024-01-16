package birdgame.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import birdgame.controller.WindowController;
import birdgame.model.WindowModel;
import birdgame.controller.AuthenticationController;
import birdgame.controller.LoginController;

public class LoginPanel extends JPanel {
    private WindowModel windowModel;
    private WindowController windowController;
    private LoginPanel loginPanel;
    private Font font = new Font("TimesRoman", Font.PLAIN, 30);
    

    
    public LoginPanel(WindowModel windowModel, WindowController windowController){
        this.loginPanel = this;
        this.windowModel = windowModel;
        this.windowController = windowController;
        loginView();
        
    }

    public void loginView(){

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel name = new JLabel("Name:");
        name.setFont(font);
        JTextField nameInput = new JTextField(10);
        nameInput.setFont(font);
        JLabel password = new JLabel("Password:");
        password.setFont(font);
        JPasswordField passwordInput = new JPasswordField(10);
        passwordInput.setFont(font);

        CButton register = new CButton("Register");
        CButton login = new CButton("Login");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController.loadRegister(loginPanel);
            }

        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(AuthenticationController.verifyLogin(nameInput.getText(), new String(passwordInput.getPassword()))){
                    windowModel.setUserName(nameInput.getText());
                    windowController.navTo(windowModel.getMenuPanel());
                }else{
                    LoginController.loadLoginFail(loginPanel);
                }

            }

        });


        
        c.insets = new Insets(10,10,10,10);
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        add(name, c);
        c.gridx = 1;
        c.gridy = 0;
        add(nameInput, c);
        c.gridx = 0;
        c.gridy = 1;
        add(password, c);
        c.gridx = 1;
        c.gridy = 1;
        add(passwordInput, c);
        c.gridx = 0;
        c.gridy = 2;
        add(register, c);
        c.gridx = 1;
        c.gridy = 2;
        add(login, c);
        
        
    }

    public void loginFailView(){

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel name = new JLabel("Name:");
        name.setFont(font);
        JTextField nameInput = new JTextField(10);
        nameInput.setFont(font);
        JLabel password = new JLabel("Password:");
        password.setFont(font);
        JPasswordField passwordInput = new JPasswordField(10);
        passwordInput.setFont(font);

        CButton register = new CButton("Register");
        CButton login = new CButton("Login");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController.loadRegister(loginPanel);
            }

        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(AuthenticationController.verifyLogin(nameInput.getText(), new String(passwordInput.getPassword()))){
                    windowModel.setUserName(nameInput.getText());
                    windowController.navTo(windowModel.getMenuPanel());
                }else{
                    LoginController.loadRegisterFail(loginPanel);
                }

            }

        });


        
        JLabel error = new JLabel("Login failed!");
        error.setFont(font);
        error.setForeground(Color.RED);

        
        c.insets = new Insets(10,10,10,10);
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(error, c);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(name, c);
        c.gridx = 1;
        c.gridy = 1;
        add(nameInput, c);
        c.gridx = 0;
        c.gridy = 2;
        add(password, c);
        c.gridx = 1;
        c.gridy = 2;
        add(passwordInput, c);
        c.gridx = 0;
        c.gridy = 3;
        add(register, c);
        c.gridx = 1;
        c.gridy = 3;
        add(login, c);
        
        
    }
    public void registerView(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel name = new JLabel("Name:");
        name.setFont(font);
        JTextField nameInput = new JTextField(10);
        nameInput.setFont(font);
        JLabel email = new JLabel("E-Mail:");
        email.setFont(font);
        JTextField emailInput = new JTextField(10);
        emailInput.setFont(font);
        JLabel password = new JLabel("Password:");
        password.setFont(font);
        JPasswordField passwordInput = new JPasswordField(10);
        passwordInput.setFont(font);

        CButton register = new CButton("Register");
        CButton login = new CButton("Login");

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController.loadLogin(loginPanel);
            }

        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(AuthenticationController.storeData(nameInput.getText(), emailInput.getText(), new String(passwordInput.getPassword()))){
                    windowModel.setUserName(nameInput.getText());
                    windowController.navTo(windowModel.getMenuPanel());
                }else{
                    LoginController.loadRegisterFail(loginPanel);
                }

            }
        });

        
        c.insets = new Insets(10,10,10,10);
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        add(name, c);
        c.gridx = 1;
        c.gridy = 0;
        add(nameInput, c);
        c.gridx = 0;
        c.gridy = 1;
        add(email, c);
        c.gridx = 1;
        c.gridy = 1;
        add(emailInput, c);
        c.gridx = 0;
        c.gridy = 2;
        add(password, c);
        c.gridx = 1;
        c.gridy = 2;
        add(passwordInput, c);
        c.gridx = 0;
        c.gridy = 3;
        add(login, c);
        c.gridx = 1;
        c.gridy = 3;
        add(register, c);
        
    }
    
    public void registerFailView(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel name = new JLabel("Name:");
        name.setFont(font);
        JTextField nameInput = new JTextField(10);
        nameInput.setFont(font);
        JLabel email = new JLabel("E-Mail:");
        email.setFont(font);
        JTextField emailInput = new JTextField(10);
        emailInput.setFont(font);
        JLabel password = new JLabel("Password:");
        password.setFont(font);
        JPasswordField passwordInput = new JPasswordField(10);
        passwordInput.setFont(font);

        CButton register = new CButton("Register");
        CButton login = new CButton("Login");

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController.loadLogin(loginPanel);
            }

        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(AuthenticationController.storeData(nameInput.getText(),
                            emailInput.getText(),
                            new String(passwordInput.getPassword()))){
                    
                    windowModel.setUserName(nameInput.getText());
                    windowController.navTo(windowModel.getMenuPanel());
                }else{
                    LoginController.loadRegisterFail(loginPanel);
                }

            }
        });

        JLabel error = new JLabel("Registration failed!");
        error.setFont(font);
        error.setForeground(Color.RED);

        
        c.insets = new Insets(10,10,10,10);
        c.anchor = GridBagConstraints.WEST;
        c.gridy = 0;
        c.gridwidth = 2;
        add(error, c);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(name, c);
        c.gridx = 1;
        c.gridy = 1;
        add(nameInput, c);
        c.gridx = 0;
        c.gridy = 2;
        add(email, c);
        c.gridx = 1;
        c.gridy = 2;
        add(emailInput, c);
        c.gridx = 0;
        c.gridy = 3;
        add(password, c);
        c.gridx = 1;
        c.gridy = 3;
        add(passwordInput, c);
        c.gridx = 0;
        c.gridy = 4;
        add(login, c);
        c.gridx = 1;
        c.gridy = 4;
        add(register, c);
        
    }
}
