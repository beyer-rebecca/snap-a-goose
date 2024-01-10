package birdgame.ui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.JSONObject;


public class LoginPanel extends JPanel {

    private boolean nameHadFocus = false;

    private Font font = new Font("TimesRoman", Font.PLAIN, 30);
    
    private LoginPanel _this;
    public LoginPanel(Window window){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        _this = this;

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
                System.out.println(hashPassword(passwordInput.getPassword().toString(), generateSalt(512).get()).get());

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
    
    private static final SecureRandom RAND = new SecureRandom();

    public static Optional<String> generateSalt (final int length) {

        if (length < 1) {
            System.err.println("error in generateSalt: length must be > 0");
            return Optional.empty();
        }

        byte[] salt = new byte[length];
        RAND.nextBytes(salt);

        return Optional.of(Base64.getEncoder().encodeToString(salt));
    }
    
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 512;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

    public static Optional<String> hashPassword (String password, String salt) {

        char[] chars = password.toCharArray();
        byte[] bytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

        Arrays.fill(chars, Character.MIN_VALUE);

        try {
            SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] securePassword = fac.generateSecret(spec).getEncoded();
            return Optional.of(Base64.getEncoder().encodeToString(securePassword));

        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Exception encountered in hashPassword()");
            return Optional.empty();

        } finally {
            spec.clearPassword();
        }
    }
    
    public static boolean verifyPassword (String password, String key, String salt) {
        Optional<String> optEncrypted = hashPassword(password, salt);
        if (!optEncrypted.isPresent()) return false;
        return optEncrypted.get().equals(key);
    }
}
