package birdgame.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Image;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import birdgame.controller.WindowController;
import birdgame.model.WindowModel;
import birdgame.controller.AuthenticationController;
import birdgame.controller.LoginController;

public class LoginPanel extends JPanel {
    private final static Font NORMAL_FONT = new Font("TimesRoman", Font.BOLD, 20);
    private final static Font SMALL_FONT = new Font("TimesRoman", Font.PLAIN, 15);  
    private final static Font gameTITLE_FONT = new Font("TimesRoman", Font.BOLD, 50);
    private static final String BACKGROUND_IMAGE_PATH = "appBackgroundBlurred.jpg";

    private WindowModel windowModel;
    private WindowController windowController;
    private LoginPanel loginPanel;
    private final int backgroundWidth;
    private final int backgroundHeight;
    private Image backgroundImage;
    
    public LoginPanel(WindowModel windowModel, WindowController windowController){
        this.loginPanel = this;
        this.windowModel = windowModel;
        this.windowController = windowController;
        this.backgroundWidth = WindowModel.WINDOW_WIDTH;  
        this.backgroundHeight = WindowModel.WINDOW_HEIGHT;

        try{
            this. backgroundImage = ImageIO.read(getClass().getClassLoader().getResource(BACKGROUND_IMAGE_PATH));
        }catch(IOException e){
            e.printStackTrace();
        }

        loginView();
        
    }

    public void loginView(){

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel gameLabel = new JLabel("SNAP A GOOSE");
        gameLabel.setFont(gameTITLE_FONT);
        JLabel name = new JLabel("Name");
        name.setFont(SMALL_FONT);
        JTextField nameInput = new JTextField(10);
        nameInput.setFont(NORMAL_FONT);
        JLabel password = new JLabel("Password");
        password.setFont(SMALL_FONT);
        JPasswordField passwordInput = new JPasswordField(10);
        passwordInput.setFont(NORMAL_FONT);
        JLabel newAccountLabel = new JLabel("Create new Account");
        newAccountLabel.setFont(SMALL_FONT);

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
                    windowController.navigateToPanel(windowModel.getMenuPanel());
                }else{
                    LoginController.loadLoginFail(loginPanel);
                }

            }

        });


        c.gridx = 0; 
        c.gridy = 0; 
        c.insets = new Insets(40, 10, 70, 10);
        c.anchor = GridBagConstraints.NORTH; 
        this.add(gameLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(40, 10, 0, 10);
        add(name, c);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 10, 10, 10);
        add(nameInput, c);
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 10);
        add(password, c);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 10, 10, 10);
        add(passwordInput, c);
        c.gridx = 0;
        c.gridy = 5;
        c.weighty = 1;
        c.insets = new Insets(10, 10, 50, 10);
        add(login, c);
        c.gridx = 0;
        c.gridy = 6;
        c.anchor = GridBagConstraints.SOUTH;
        c.insets = new Insets(70, 0, 0, 0); 
        add(newAccountLabel, c);
        c.insets = new Insets(0, 0 , 30, 0); 
        c.gridx = 0;
        c.gridy = 7;
        c.anchor = GridBagConstraints.SOUTH; 
        add(register,c);
        
        
        
    }

    public void loginFailView(){

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel gameLabel = new JLabel("SNAP A GOOSE");
        gameLabel.setFont(gameTITLE_FONT);
        JLabel name = new JLabel("Name");
        name.setFont(SMALL_FONT);
        JTextField nameInput = new JTextField(10);
        nameInput.setFont(NORMAL_FONT);
        JLabel password = new JLabel("Password");
        password.setFont(SMALL_FONT);
        JPasswordField passwordInput = new JPasswordField(10);
        passwordInput.setFont(NORMAL_FONT);
        JLabel newAccountLabel = new JLabel("Create new Account");
        newAccountLabel.setFont(SMALL_FONT);

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
                    windowController.navigateToPanel(windowModel.getMenuPanel());
                }else{
                    LoginController.loadLoginFail(loginPanel);
                }

            }

        });
        
        JLabel error = new JLabel("Login failed!");
        error.setFont(NORMAL_FONT);
        error.setForeground(Color.RED);

        c.gridx = 0; 
        c.gridy = 0; 
        c.insets = new Insets(40, 10, 60, 10);
        c.anchor = GridBagConstraints.NORTH; 
        this.add(gameLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 0, 10);
        add(error, c);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 10);
        add(name, c);
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0, 10, 10, 10);
        add(nameInput, c);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 0, 10);
        add(password, c);
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(0, 10, 10, 10);
        add(passwordInput, c);
        c.gridx = 0;
        c.gridy = 6;
        c.weighty = 1;
        c.insets = new Insets(10, 10, 50, 10);
        add(login, c);
        c.gridx = 0;
        c.gridy = 7;
        c.anchor = GridBagConstraints.SOUTH;
        c.insets = new Insets(70, 0, 0, 0); 
        add(newAccountLabel, c);
        c.insets = new Insets(0, 0 , 30, 0); 
        c.gridx = 0;
        c.gridy = 8;
        c.anchor = GridBagConstraints.SOUTH; 
        add(register,c);
    }

    public void registerView(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel gameLabel = new JLabel("SNAP A GOOSE");
        gameLabel.setFont(gameTITLE_FONT);
        JLabel name = new JLabel("Name");
        name.setFont(SMALL_FONT);
        JTextField nameInput = new JTextField(10);
        nameInput.setFont(NORMAL_FONT);
        JLabel email = new JLabel("E-Mail");
        email.setFont(SMALL_FONT);
        JTextField emailInput = new JTextField(10);
        emailInput.setFont(NORMAL_FONT);
        JLabel password = new JLabel("Password");
        password.setFont(SMALL_FONT);
        JPasswordField passwordInput = new JPasswordField(10);
        passwordInput.setFont(NORMAL_FONT);

        CButton register = new CButton("Register");
        CButton login = new CButton("Login");

        JLabel newAccountLabel = new JLabel("Already have an account?");
        newAccountLabel.setFont(SMALL_FONT);

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
                    windowController.navigateToPanel(windowModel.getMenuPanel());
                }else{
                    LoginController.loadRegisterFail(loginPanel);
                }

            }
        });

        c.gridx = 0; 
        c.gridy = 0; 
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(40, 10, 70, 10);
        add(gameLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(40, 10, 0, 10);
        add(name, c);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(00, 10, 10, 10);
        add(nameInput, c);
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 0, 10);
        add(password, c);
        c.gridx = 0;
        c.gridy = 4;
        c.insets =new Insets(00, 10, 10, 10);
        add(passwordInput, c);
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(10, 10, 0, 10);
        add(email, c);
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(00, 10, 10, 10);
        add(emailInput, c);
        c.gridx = 0;
        c.gridy = 7;
        c.weighty = 1;
        c.insets = new Insets(00, 10, 10, 10);
        add(register, c);
        c.gridx = 0;
        c.gridy = 8;
        c.anchor = GridBagConstraints.SOUTH;
        c.insets = new Insets(50, 0, 0, 0); 
        add(newAccountLabel, c);
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(0, 0, 30, 0); 
        c.anchor = GridBagConstraints.SOUTH; 
        add(login,c);
        
    }
    
    public void registerFailView(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel name = new JLabel("Name:");
        name.setFont(SMALL_FONT);
        JTextField nameInput = new JTextField(10);
        nameInput.setFont(NORMAL_FONT);
        JLabel email = new JLabel("E-Mail");
        email.setFont(SMALL_FONT);
        JTextField emailInput = new JTextField(10);
        emailInput.setFont(NORMAL_FONT);
        JLabel password = new JLabel("Password");
        password.setFont(SMALL_FONT);
        JPasswordField passwordInput = new JPasswordField(10);
        passwordInput.setFont(NORMAL_FONT);

        CButton register = new CButton("Register");
        CButton login = new CButton("Login");

        JLabel newAccountLabel = new JLabel("Already have an account?");
        newAccountLabel.setFont(SMALL_FONT);
        JLabel gameLabel = new JLabel("SNAP A GOOSE");
        gameLabel.setFont(gameTITLE_FONT);

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
                    windowController.navigateToPanel(windowModel.getMenuPanel());
                }else{
                    LoginController.loadRegisterFail(loginPanel);
                }

            }
        });

        JLabel error = new JLabel("Registration failed!");
        error.setFont(NORMAL_FONT);
        error.setForeground(Color.RED);

        c.gridx = 0; 
        c.gridy = 0; 
        c.insets = new Insets(40, 10, 40, 10);
        add(gameLabel, c);
        c.gridx = 0; 
        c.gridy = 1; 
        c.insets = new Insets(40, 10, 0, 10);
        add(error, c);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 0, 10);
        add(name, c);
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(00, 10, 10, 10);
        add(nameInput, c);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 0, 10);
        add(password, c);
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(00, 10, 10, 10);
        add(passwordInput, c);
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(10, 10, 0, 10);
        add(email, c);
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(00, 10, 10, 10);
        add(emailInput, c);
        c.gridx = 0;
        c.gridy = 8;
        c.weighty = 1;
        c.insets = new Insets(00, 10, 10, 10);
        add(register, c);
        c.gridx = 0;
        c.gridy = 9;
        c.anchor = GridBagConstraints.SOUTH;
        c.insets = new Insets(50, 0, 0, 0); 
        add(newAccountLabel, c);
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(0, 0, 30, 0); 
        c.anchor = GridBagConstraints.SOUTH; 
        add(login,c);
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
      if (this.backgroundImage != null) {
         g.drawImage(this.backgroundImage, 0, 0, backgroundWidth, backgroundHeight, this);
        }
    }
}
