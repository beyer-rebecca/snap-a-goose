package birdgame.ui;

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
import birdgame.controller.AuthenticationController;

public class LoginPanel extends JPanel {
    private WindowView windowView;
    private WindowController windowController;
    private Font font = new Font("TimesRoman", Font.PLAIN, 30);

    
    public LoginPanel(WindowView windowView, WindowController windowController){
        this.windowView = windowView;
        this.windowController = windowController;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        loginView(c);
        
    }

    private void loginView(GridBagConstraints c){

        
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
                remove(name);
                remove(nameInput);
                remove(password);
                remove(passwordInput);
                remove(login);
                remove(register);
                revalidate();
                repaint();
                registerView(c);

            }

        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(AuthenticationController.verifyPassword(nameInput.getText(), new String(passwordInput.getPassword()))){
                    windowController.navTo(windowView.getMenuPanel());
                }else{
                    System.out.println("Login not woring");
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

    private void registerView(GridBagConstraints c){
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
                remove(name);
                remove(nameInput);
                remove(email);
                remove(emailInput);
                remove(password);
                remove(passwordInput);
                remove(login);
                remove(register);
                revalidate();
                repaint();
                loginView(c);

            }

        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AuthenticationController.storeData(nameInput.getText(), emailInput.getText(), new String(passwordInput.getPassword()));
                windowController.navTo(windowView.getMenuPanel());

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
    
}
