package com.company;

import com.company.database.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.JOptionPane.showMessageDialog;
import static com.company.GUI.*;
public class LoginGUI extends JFrame {

    public static void startLogin() {
        JFrame loginGUI = new JFrame();

        //"Log In" TextView
        JLabel logInTextView = new JLabel();
        logInTextView.setFont(new Font("Comfortaa", Font.PLAIN, 22));
        logInTextView.setForeground(Color.black);
        logInTextView.setText("Log In");
        logInTextView.setHorizontalAlignment(SwingConstants.LEFT);
        logInTextView.setVerticalAlignment(SwingConstants.CENTER);
        logInTextView.setBounds(28, 59, 65, 30);
        loginGUI.add(logInTextView);

        //Purple line under "Log In"
        ImageIcon purpleLine = new ImageIcon("src/resources/createProfileLine.png");
        JLabel logInLine = new JLabel(purpleLine);
        logInLine.setBounds(0, 95, 124, 4);
        loginGUI.add(logInLine);

        //"Email or Username" TextView
        JLabel enterEmailTextView = new JLabel();
        enterEmailTextView.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        enterEmailTextView.setForeground(Color.black);
        enterEmailTextView.setText("E-mail");
        enterEmailTextView.setHorizontalAlignment(SwingConstants.LEFT);
        enterEmailTextView.setVerticalAlignment(SwingConstants.CENTER);
        enterEmailTextView.setBounds(37, 162, 168, 23);
        loginGUI.add(enterEmailTextView);

        //"Email/Username" EditText
        JTextField enterEmailEditText = new JTextField();
        enterEmailEditText.setFont(new Font("Comfortaa", Font.PLAIN, 12));
        enterEmailEditText.setForeground(Color.black);
        enterEmailEditText.setBounds(37, 185, 300, 25);
        loginGUI.add(enterEmailEditText);

        //"Password" TextView
        JLabel enterPasswordTextView = new JLabel();
        enterPasswordTextView.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        enterPasswordTextView.setForeground(Color.black);
        enterPasswordTextView.setText("Password:");
        enterPasswordTextView.setHorizontalAlignment(SwingConstants.LEFT);
        enterPasswordTextView.setVerticalAlignment(SwingConstants.CENTER);
        enterPasswordTextView.setBounds(37, 242, 75, 19);
        loginGUI.add(enterPasswordTextView);

        //"Password" EditText
        JPasswordField enterPasswordEditText = new JPasswordField();
        enterPasswordEditText.setFont(new Font("Comfortaa", Font.PLAIN, 12));
        enterPasswordEditText.setForeground(Color.black);
        enterPasswordEditText.setBounds(37, 263, 300, 25);
        loginGUI.add(enterPasswordEditText);

        //"Forgot my password" link
        JLabel forgotPass = new JLabel();
        forgotPass.setFont(new Font("Comfortaa", Font.PLAIN, 11));
        forgotPass.setForeground(new Color(30,152,215));
        forgotPass.setOpaque(false);
        forgotPass.setText("I forgot my password");
        forgotPass.setBounds(219, 288, 118, 19);
        loginGUI.add(forgotPass);

        forgotPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginGUI.dispose();
                //forgotPassGUI();                   /////////////////////////////////////////////////////////
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                forgotPass.setForeground(Color.blue);
            }
            public void mouseExited(MouseEvent evt) {
                forgotPass.setForeground(new Color(30,152,215));
            }
        });

        //"Don't have an account?"
        JLabel NotHaveAnAccountTextView = new JLabel();
        NotHaveAnAccountTextView.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        NotHaveAnAccountTextView.setForeground(Color.black);
        NotHaveAnAccountTextView.setOpaque(false);
        NotHaveAnAccountTextView.setText("Don't have an account?");
        NotHaveAnAccountTextView.setBounds(114, 360, 149, 18);
        loginGUI.add(NotHaveAnAccountTextView);

        //Underline under "Don't have an account?"
        ImageIcon NotHaveAccountLineImage = new ImageIcon("src/resources/haveAnAccountUnderline.png");
        JLabel NotHaveAccountUnderLine = new JLabel(NotHaveAccountLineImage);
        NotHaveAccountUnderLine.setBounds(125, 378, 115, 2);
        loginGUI.add(NotHaveAccountUnderLine);

        //"Sign up!" link
        JLabel signUpLink = new JLabel();
        signUpLink.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        signUpLink.setForeground(new Color(30,152,215));
        signUpLink.setOpaque(false);
        signUpLink.setText("Sign up!");
        signUpLink.setBounds(156, 384, 52, 22);
        loginGUI.add(signUpLink);

        signUpLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginGUI.dispose();
                RegistrationGUI.startRegistration();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                signUpLink.setForeground(Color.blue);
            }
            public void mouseExited(MouseEvent evt) {
                signUpLink.setForeground(new Color(30,152,215));
            }
        });

        //Underline under "Sign Up!"
        JLabel signUpUnderLine = new JLabel(NotHaveAccountLineImage);
        signUpUnderLine.setBounds(159, 405, 47, 2);
        loginGUI.add(signUpUnderLine);

        //"Sign in" Button
        ImageIcon signInImage = new ImageIcon("src/resources/getStartedButton.png");
        JLabel signInButton = new JLabel(signInImage);
        signInButton.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        signInButton.setForeground(Color.white);
        signInButton.setBounds(105,482,152,42);
        signInButton.setHorizontalTextPosition(JButton.CENTER);
        signInButton.setVerticalTextPosition(JButton.CENTER);
        signInButton.setText("Sign in");
        loginGUI.add(signInButton);

        signInButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                User user = UserDAO.getInstance().getUserByEmail(enterEmailEditText.getText());

                if (enterEmailEditText.getText().isBlank() || enterPasswordEditText.getText().isBlank()) {
                    showMessageDialog(null, "Please fill all the fields");
                }
                else if (!User.emailIsValid(enterEmailEditText.getText())) {
                    showMessageDialog(null, "Please enter valid email");

                }
                else if (!User.passwordIsValid(enterPasswordEditText.getText())) {
                    showMessageDialog(null, "Password must have at least one numeric character, uppercase letter, " +
                            "and its length should be from 8 to 20 characters");
                }
                else {
                    if (user.getPassword() != null && user.getPassword().equals(enterPasswordEditText.getText())) {
                        // successful login
                        LoginTracker.setCurrentUser(user);
                        loginGUI.dispose();
                        mainMenuGUI();
                    } else {
                        showMessageDialog(null, "Wrong email or password. Check your details and try again.");
                    }
                }
            }
        });


        //initializing GUI
        initGUI(loginGUI);
    }
}
