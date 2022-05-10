package com.company.GUI;

import com.company.logger.ActivityTracker;
import com.company.logger.LoggerHelper;
import com.company.logger.LoginTracker;
import com.company.database.User;

import com.company.database.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.JOptionPane.showMessageDialog;
import static com.company.GUI.GUI.*;

public class RegistrationGUI extends JFrame {

    private UserDAO dao = UserDAO.getInstance();

    public static void startRegistration() {
        JFrame registrationGUI = new JFrame();

        //"Create your profile" TextView
        JLabel createProfileTextView = new JLabel();
        createProfileTextView.setFont(new Font("Comfortaa", Font.PLAIN, 22));
        createProfileTextView.setForeground(Color.black);
        createProfileTextView.setText("Create your profile");
        createProfileTextView.setHorizontalAlignment(SwingConstants.LEFT);
        createProfileTextView.setVerticalAlignment(SwingConstants.CENTER);
        createProfileTextView.setBounds(18, 41, 208, 27);
        registrationGUI.add(createProfileTextView);

        //Purple line under "Create your profile"
        ImageIcon purpleLine = new ImageIcon("src/resources/createProfileLine.png");
        JLabel createProfileLine = new JLabel(purpleLine);
        createProfileLine.setBounds(0, 76, 253, 3);
        registrationGUI.add(createProfileLine);

        //"Create your username" TextView
        JLabel createUsernameTextView = new JLabel();
        createUsernameTextView.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        createUsernameTextView.setForeground(Color.black);
        createUsernameTextView.setText("Create your username:");
        createUsernameTextView.setHorizontalAlignment(SwingConstants.LEFT);
        createUsernameTextView.setVerticalAlignment(SwingConstants.CENTER);
        createUsernameTextView.setBounds(30, 136, 168, 23);
        registrationGUI.add(createUsernameTextView);

        //"Create your username" EditText
        JTextField createUsernameEditText = new JTextField();
        createUsernameEditText.setFont(new Font("Comfortaa", Font.PLAIN, 12));
        createUsernameEditText.setForeground(Color.black);
        createUsernameEditText.setBounds(30, 162, 300, 25);
        registrationGUI.add(createUsernameEditText);

        //"Enter your email" TextView
        JLabel createEmailTextView = new JLabel();
        createEmailTextView.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        createEmailTextView.setForeground(Color.black);
        createEmailTextView.setText("Enter your email:");
        createEmailTextView.setHorizontalAlignment(SwingConstants.LEFT);
        createEmailTextView.setVerticalAlignment(SwingConstants.CENTER);
        createEmailTextView.setBounds(30, 219, 168, 23);
        registrationGUI.add(createEmailTextView);

        //"Enter your email" EditText
        JTextField createEmailEditText = new JTextField();
        createEmailEditText.setFont(new Font("Comfortaa", Font.PLAIN, 12));
        createEmailEditText.setForeground(Color.black);
        createEmailEditText.setBounds(30, 243, 300, 25);
        registrationGUI.add(createEmailEditText);

        //"Create your password" TextView
        JLabel createPasswordTextView = new JLabel();
        createPasswordTextView.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        createPasswordTextView.setForeground(Color.black);
        createPasswordTextView.setText("Create your password:");
        createPasswordTextView.setHorizontalAlignment(SwingConstants.LEFT);
        createPasswordTextView.setVerticalAlignment(SwingConstants.CENTER);
        createPasswordTextView.setBounds(30, 300, 168, 23);
        registrationGUI.add(createPasswordTextView);

        //"Create your password" EditText
        JPasswordField createPasswordEditText = new JPasswordField();
        createPasswordEditText.setFont(new Font("Comfortaa", Font.PLAIN, 12));
        createPasswordEditText.setForeground(Color.black);
        createPasswordEditText.setBounds(30, 324, 300, 25);
        registrationGUI.add(createPasswordEditText);

        //"Already have an account?"
        JLabel haveAnAccountTextView = new JLabel();
        haveAnAccountTextView.setFont(new Font("Comfortaa", Font.PLAIN, 10));
        haveAnAccountTextView.setForeground(Color.black);
        haveAnAccountTextView.setOpaque(false);
        haveAnAccountTextView.setText("Already have an account?");
        haveAnAccountTextView.setBounds(202, 351, 129, 14);
        registrationGUI.add(haveAnAccountTextView);

        //Underline under "Already have an account?"
        ImageIcon haveAccountLineImage = new ImageIcon("src/resources/haveAnAccountUnderline.png");
        JLabel haveAccountUnderLine = new JLabel(haveAccountLineImage);
        haveAccountUnderLine.setBounds(201, 363, 129, 2);
        registrationGUI.add(haveAccountUnderLine);

        //"Sign in" link
        JLabel signInLink = new JLabel();
        signInLink.setFont(new Font("Comfortaa", Font.PLAIN, 10));
        signInLink.setForeground(new Color(30,152,215));
        signInLink.setOpaque(false);
        signInLink.setText("Sign in");
        signInLink.setBounds(295, 364, 35, 18);
        registrationGUI.add(signInLink);

        signInLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registrationGUI.dispose();
                LoginGUI.startLogin();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                signInLink.setForeground(Color.blue);
            }
            public void mouseExited(MouseEvent evt) {
                signInLink.setForeground(new Color(30,152,215));
            }
        });

        //Underline under "Sign In"
        JLabel signInUnderLine = new JLabel(haveAccountLineImage);
        signInUnderLine.setBounds(297, 380, 33, 2);
        registrationGUI.add(signInUnderLine);

        //"Sign Up" Button
        ImageIcon signUpImage = new ImageIcon("src/resources/getStartedButton.png");
        JLabel signUpButton = new JLabel(signUpImage);
        signUpButton.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        signUpButton.setForeground(Color.white);
        signUpButton.setBounds(110,534,152,42);
        signUpButton.setHorizontalTextPosition(JButton.CENTER);
        signUpButton.setVerticalTextPosition(JButton.CENTER);
        signUpButton.setText("Sign up");
        registrationGUI.add(signUpButton);

        signUpButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                User user = UserDAO.getInstance().getUserByEmail(createEmailEditText.getText());
                if (createUsernameEditText.getText().isBlank() || createPasswordEditText.getText().isBlank() || createEmailEditText.getText().isBlank() ) {
                    showMessageDialog(null, "Please fill all the fields");
                }
                else if (!User.emailIsValid(createEmailEditText.getText())) {
                    showMessageDialog(null, "Please enter valid email");
                }
                else if (!User.passwordIsValid(createPasswordEditText.getText())) {
                    showMessageDialog(null, "Password must have at least one numeric character, uppercase letter, " +
                            "and its length should be from 8 to 20 characters");
                } else if (user.getEmail() != null) {
                    showMessageDialog(null, "Email is already used");
                }
                else {
                    User newUser = new User();
                    newUser.setEmail(createEmailEditText.getText());
                    newUser.setPassword(createPasswordEditText.getText());
                    newUser.setUsername(createUsernameEditText.getText());
                    UserDAO.getInstance().insertUpdateUser(newUser);
                    LoginTracker.setCurrentUser(newUser);
                    String log = newUser.getUsername() + " created account";
                    LoggerHelper.log(log);
                    ActivityTracker.userRegister();

                    registrationGUI.dispose();
                    LevelChoiceGUI.startLevelChoice();
                }
            }
        });

        //initializing GUI
        initGUI(registrationGUI);

    }

    private boolean checkEmailExistence(String email) {
        User user = dao.getUserByEmail(email);
        if ( user.getUsername() == null ) {
            return false;
        }
        return true;
    }
}
