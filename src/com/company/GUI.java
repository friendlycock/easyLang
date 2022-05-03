package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

//Code author - Pavels Kuznecovs w1807574

public class GUI extends JFrame {

    public static String[] quoteArray = //array of quotes for the first screen
            {"\"A different language is a different vision of life.\"",
            "\"The limits of my language mean the limits of my world.\"",
            "\"Change your language and you change your thoughts.\"",
            "\"Knowledge of languages is the doorway to wisdom.\"",
            "\"Learning is a treasure that will follow its owner everywhere.\"",
            "\"Learn a new language and get a new soul.\""};

    public void startGUI() {
        JFrame firstScreen = new JFrame();

        //setting logo
        JLabel panel = new JLabel();
        panel.setBounds(-15, 46, 396, 244);
        panel.setIcon(new ImageIcon(new ImageIcon("src/resources/logo.png").getImage().getScaledInstance(396, 244, Image.SCALE_SMOOTH)));
        firstScreen.add(panel);

        //"I have an account" Button
        ImageIcon haveAccountImage = new ImageIcon("src/resources/haveAccountButton.png");
        JLabel haveAccountButton = new JLabel(haveAccountImage);
        haveAccountButton.setFont(new Font("Comfortaa", Font.PLAIN, 8));
        haveAccountButton.setBounds(125,570,122,27);
        haveAccountButton.setHorizontalTextPosition(JButton.CENTER);
        haveAccountButton.setVerticalTextPosition(JButton.CENTER);
        haveAccountButton.setText("I HAVE AN ACCOUNT");
        firstScreen.add(haveAccountButton);

        haveAccountButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                firstScreen.dispose();
                loginGUI();
            }
        });

        //"Get Started" Button
        ImageIcon getStartedImage = new ImageIcon("src/resources/getStartedButton.png");
        JLabel getStartedButton = new JLabel(getStartedImage);
        getStartedButton.setFont(new Font("Comfortaa", Font.PLAIN, 12));
        getStartedButton.setBounds(111,508,152,42);
        getStartedButton.setHorizontalTextPosition(JButton.CENTER);
        getStartedButton.setVerticalTextPosition(JButton.CENTER);
        getStartedButton.setForeground(Color.white);
        getStartedButton.setText("GET STARTED");
        firstScreen.add(getStartedButton);

        getStartedButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                firstScreen.dispose();
                registrationGUI();
            }
        });

        //label for quotes
        JLabel quoteLabel = new JLabel();
        Random random = new Random();
        int randomQuote = random.nextInt(quoteArray.length);
        quoteLabel.setFont(new Font("Gabriola", Font.PLAIN, 16));
        quoteLabel.setForeground(Color.black);
        quoteLabel.setBackground(Color.getColor("#c280ff17"));
        quoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quoteLabel.setVerticalAlignment(SwingConstants.CENTER);
        quoteLabel.setOpaque(true);
        quoteLabel.setText("<html>" + quoteArray[randomQuote] + "</html>");
        quoteLabel.setBounds(36, 325, 303, 77);
        firstScreen.add(quoteLabel);


        //initializing GUI
        initGUI(firstScreen);
    }

    public static void registrationGUI() {
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
                loginGUI();
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
                if (createUsernameEditText.getText().isBlank() || createPasswordEditText.getText().isBlank() || createEmailEditText.getText().isBlank() ) {
                    showMessageDialog(null, "Please fill all the fields");
                }
                else if (!User.emailIsValid(createEmailEditText.getText())) {
                showMessageDialog(null, "Please enter valid email");
            }
                else if (!User.passwordIsValid(createPasswordEditText.getText())) {
                    showMessageDialog(null, "Password must have at least one numeric character, uppercase letter, " +
                            "and its length should be from 8 to 20 characters");
                }
            else {
                registrationGUI.dispose();
                levelChoiceGUI();
            }
            }
        });

        //initializing GUI
        initGUI(registrationGUI);

    }

    public static void loginGUI() {
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
        enterEmailTextView.setText("E-mail or username:");
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
                registrationGUI();
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
                    loginGUI.dispose();
                    mainMenuGUI();
                }
            }
        });


        //initializing GUI
        initGUI(loginGUI);
    }

    public static void levelChoiceGUI() {
        JFrame levelChoiceGUI = new JFrame();

        String[] languageChoice = {"English", "Russian", "French", "Spanish", "Chinese"};
        String[] langLevel = {"A1", "A2", "B1", "B2", "C1", "C2"};

        //"My language is.." TextView
        JLabel langChoiceTextView = new JLabel();
        langChoiceTextView.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        langChoiceTextView.setForeground(Color.black);
        langChoiceTextView.setText("My language is..");
        langChoiceTextView.setHorizontalAlignment(SwingConstants.LEFT);
        langChoiceTextView.setVerticalAlignment(SwingConstants.CENTER);
        langChoiceTextView.setBounds(37, 84, 130, 23);
        levelChoiceGUI.add(langChoiceTextView);

        //Language dropbox
        JComboBox<String> langChoiceBox = new JComboBox<>(languageChoice);
        langChoiceBox.setBounds(37, 124, 300, 25);
        langChoiceBox.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        levelChoiceGUI.add(langChoiceBox);

        //"I want to practice.." TextView
        JLabel practiceLangTextView = new JLabel();
        practiceLangTextView.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        practiceLangTextView.setForeground(Color.black);
        practiceLangTextView.setText("I want to practice..");
        practiceLangTextView.setHorizontalAlignment(SwingConstants.LEFT);
        practiceLangTextView.setVerticalAlignment(SwingConstants.CENTER);
        practiceLangTextView.setBounds(37, 199, 160, 23);
        levelChoiceGUI.add(practiceLangTextView);

        //Practice Language dropbox
        JComboBox<String> practiceLangChoiceBox = new JComboBox<>(languageChoice);
        practiceLangChoiceBox.setBounds(37, 254, 300, 25);
        practiceLangChoiceBox.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        levelChoiceGUI.add(practiceLangChoiceBox);

        //"My level of language.." TextView
        JLabel langLevelTextView = new JLabel();
        langLevelTextView.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        langLevelTextView.setForeground(Color.black);
        langLevelTextView.setText("My level of language..");
        langLevelTextView.setHorizontalAlignment(SwingConstants.LEFT);
        langLevelTextView.setVerticalAlignment(SwingConstants.CENTER);
        langLevelTextView.setBounds(37, 329, 180, 23);
        levelChoiceGUI.add(langLevelTextView);

        //Language dropbox
        JComboBox<String> langLevelBox = new JComboBox<>(langLevel);
        langLevelBox.setBounds(37, 384, 300, 25);
        langLevelBox.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        levelChoiceGUI.add(langLevelBox);

        //"Start my journey" Button
        ImageIcon startMyJourneyImage = new ImageIcon("src/resources/startMyJourneyButton.png");
        JLabel startMyJourneyButton = new JLabel(startMyJourneyImage);
        startMyJourneyButton.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        startMyJourneyButton.setForeground(Color.white);
        startMyJourneyButton.setBounds(105,497,164,42);
        startMyJourneyButton.setHorizontalTextPosition(JButton.CENTER);
        startMyJourneyButton.setVerticalTextPosition(JButton.CENTER);
        startMyJourneyButton.setText("Start my journey");
        levelChoiceGUI.add(startMyJourneyButton);

        startMyJourneyButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                levelChoiceGUI.dispose();
                mainMenuGUI();
            }
        });

        //initializing GUI
        initGUI(levelChoiceGUI);
    }

    public static void topicsChoiceGUI() {
        JFrame topicsChoiceGUI = new JFrame();

        //"Choose role plays by:" TextView
        JLabel chooseRoleplayTextView = new JLabel();
        chooseRoleplayTextView.setFont(new Font("Comfortaa", Font.PLAIN, 22));
        chooseRoleplayTextView.setForeground(Color.black);
        chooseRoleplayTextView.setText("Choose roleplays by:");
        chooseRoleplayTextView.setHorizontalAlignment(SwingConstants.LEFT);
        chooseRoleplayTextView.setVerticalAlignment(SwingConstants.CENTER);
        chooseRoleplayTextView.setBounds(18, 41, 258, 27);
        topicsChoiceGUI.add(chooseRoleplayTextView);

        //Purple line under "Choose role plays by:"
        ImageIcon purpleLine = new ImageIcon("src/resources/createProfileLine.png");
        JLabel chooseRoleplayProfileLine = new JLabel(purpleLine);
        chooseRoleplayProfileLine.setBounds(0, 76, 253, 3);
        topicsChoiceGUI.add(chooseRoleplayProfileLine);

        //"Context" Button
        ImageIcon contextImage = new ImageIcon("src/resources/contextChoiceButton.png");
        JLabel contextButton = new JLabel(contextImage);
        contextButton.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        contextButton.setForeground(Color.white);
        contextButton.setBounds(30,180,306,107);
        contextButton.setHorizontalTextPosition(JButton.CENTER);
        contextButton.setVerticalTextPosition(JButton.CENTER);
        contextButton.setText("Context");
        topicsChoiceGUI.add(contextButton);

        contextButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                topicsChoiceGUI.dispose();
                contextTopicsScreen();
            }
        });

        //"Language function" Button
        ImageIcon langFunctionImage = new ImageIcon("src/resources/langChoiceButton.png");
        JLabel langFuncButton = new JLabel(langFunctionImage);
        langFuncButton.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        langFuncButton.setForeground(Color.white);
        langFuncButton.setBounds(30,310,306,107);
        langFuncButton.setHorizontalTextPosition(JButton.CENTER);
        langFuncButton.setVerticalTextPosition(JButton.CENTER);
        langFuncButton.setText("Language function");
        topicsChoiceGUI.add(langFuncButton);

        langFuncButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                topicsChoiceGUI.dispose();
                //langFuncGUI();
            }
        });

        //"Grammar" Button
        ImageIcon grammarImage = new ImageIcon("src/resources/grammarChoiceButton.png");
        JLabel grammarButton = new JLabel(grammarImage);
        grammarButton.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        grammarButton.setForeground(Color.white);
        grammarButton.setBounds(30,440,306,107);
        grammarButton.setHorizontalTextPosition(JButton.CENTER);
        grammarButton.setVerticalTextPosition(JButton.CENTER);
        grammarButton.setText("Grammar");
        topicsChoiceGUI.add(grammarButton);

        grammarButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                topicsChoiceGUI.dispose();
                //grammarGUI();
            }
        });


        //initializing GUI
        initGUI(topicsChoiceGUI);
    }

    public static void preferencesGUI() {
        JFrame preferencesGUI = new JFrame();

        String[] languageChoice = {"English", "Russian", "French", "Spanish", "Chinese"};
        String[] langLevel = {"A1", "A2", "B1", "B2", "C1", "C2"};

        //"My language is.." TextView
        JLabel langChoiceTextView = new JLabel();
        langChoiceTextView.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        langChoiceTextView.setForeground(Color.black);
        langChoiceTextView.setText("My language is..");
        langChoiceTextView.setHorizontalAlignment(SwingConstants.LEFT);
        langChoiceTextView.setVerticalAlignment(SwingConstants.CENTER);
        langChoiceTextView.setBounds(37, 84, 130, 23);
        preferencesGUI.add(langChoiceTextView);

        //Language dropbox
        JComboBox<String> langChoiceBox = new JComboBox<>(languageChoice);
        langChoiceBox.setBounds(37, 124, 300, 25);
        langChoiceBox.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        preferencesGUI.add(langChoiceBox);

        //"I want to practice.." TextView
        JLabel practiceLangTextView = new JLabel();
        practiceLangTextView.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        practiceLangTextView.setForeground(Color.black);
        practiceLangTextView.setText("I want to practice..");
        practiceLangTextView.setHorizontalAlignment(SwingConstants.LEFT);
        practiceLangTextView.setVerticalAlignment(SwingConstants.CENTER);
        practiceLangTextView.setBounds(37, 199, 160, 23);
        preferencesGUI.add(practiceLangTextView);

        //Practice Language dropbox
        JComboBox<String> practiceLangChoiceBox = new JComboBox<>(languageChoice);
        practiceLangChoiceBox.setBounds(37, 254, 300, 25);
        practiceLangChoiceBox.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        preferencesGUI.add(practiceLangChoiceBox);

        //"My level of language.." TextView
        JLabel langLevelTextView = new JLabel();
        langLevelTextView.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        langLevelTextView.setForeground(Color.black);
        langLevelTextView.setText("My level of language..");
        langLevelTextView.setHorizontalAlignment(SwingConstants.LEFT);
        langLevelTextView.setVerticalAlignment(SwingConstants.CENTER);
        langLevelTextView.setBounds(37, 329, 180, 23);
        preferencesGUI.add(langLevelTextView);

        //Language dropbox
        JComboBox<String> langLevelBox = new JComboBox<>(langLevel);
        langLevelBox.setBounds(37, 384, 300, 25);
        langLevelBox.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        preferencesGUI.add(langLevelBox);

        //"Show key vocabulary" checkbox
        final JLabel keyVocabTextView = new JLabel();
        keyVocabTextView.setHorizontalAlignment(JLabel.LEFT);
        keyVocabTextView.setSize(400,100);
        JCheckBox keyVocabCheckBox = new JCheckBox("Show key vocabulary");
        keyVocabTextView.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        keyVocabCheckBox.setOpaque(false);
        keyVocabCheckBox.setBounds(37,451, 300,18);
        keyVocabCheckBox.addItemListener(e -> Main.keyVocab = e.getStateChange() == ItemEvent.SELECTED);
        preferencesGUI.add(keyVocabCheckBox);

        //"Save" Button
        ImageIcon saveImage = new ImageIcon("src/resources/getStartedButton.png");
        JLabel saveButton = new JLabel(saveImage);
        saveButton.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        saveButton.setForeground(Color.white);
        saveButton.setBounds(110,534,152,42);
        saveButton.setHorizontalTextPosition(JButton.CENTER);
        saveButton.setVerticalTextPosition(JButton.CENTER);
        saveButton.setText("Save");
        preferencesGUI.add(saveButton);

        saveButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                    //User.setLangLevel, setUserLang, setPracticeLang
                    preferencesGUI.dispose();
                    mainMenuGUI();
            }
        });

        //initializing GUI
        initGUI(preferencesGUI);
    }

    public static void contextTopicsScreen() {
        JFrame contextTopicsScreen = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //if (User.getUserLevel == "A1") { getting user language level and setting existing topics
            //if A1
            JLabel button = new JLabel("Ordering food and drink");
            addButton(panel, button);
            JLabel button1 = new JLabel("Exchanging personal information");
            addButton(panel, button1);
            JLabel button2 = new JLabel("Going shopping and asking for prices");
            addButton(panel, button2);
            JLabel button3 = new JLabel("Making Appointments");
            addButton(panel, button3);
            JLabel button4 = new JLabel("Introductions");
            addButton(panel, button4);
            JLabel button5 = new JLabel("Basic employment issues");
            addButton(panel, button5);
            JLabel button6 = new JLabel("Going shopping and asking for prices");
            addButton(panel, button6);
            JLabel button7 = new JLabel("Socialising in the country");
            addButton(panel, button7);
            JLabel button8 = new JLabel("Asking and giving directions");
            addButton(panel, button8);
            JLabel button9 = new JLabel("Making invitations");
            addButton(panel, button9);
            JLabel button10 = new JLabel("University life");
            addButton(panel, button10);
            JLabel button11 = new JLabel("Cross-cultural experiences");
            addButton(panel, button11);
            JLabel button12 = new JLabel("Asking and giving directions");
            addButton(panel, button12);
            JLabel button13 = new JLabel("Making invitations");
            addButton(panel, button13);
            JLabel button14 = new JLabel("University life");
            addButton(panel, button14);
        //}
        panel.setBackground(new Color(30,152,215, 0));
        panel.setBorder(null);
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.getVerticalScrollBar().setUnitIncrement(1);
        scrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(25, 117, 314, 460);
        JPanel contentPane = new JPanel(null);
        //contentPane.setPreferredSize(new Dimension(500, 400));
        contentPane.add(scrollPane);
        contextTopicsScreen.setContentPane(contentPane);
        contextTopicsScreen.pack();

        //"Choose topic you want to practise" TextView
        JLabel chooseTopicTextView = new JLabel();
        chooseTopicTextView.setFont(new Font("Comfortaa", Font.PLAIN, 18));
        chooseTopicTextView.setForeground(Color.black);
        chooseTopicTextView.setText("Choose topic you want to practise:");
        chooseTopicTextView.setHorizontalAlignment(SwingConstants.LEFT);
        chooseTopicTextView.setVerticalAlignment(SwingConstants.CENTER);
        chooseTopicTextView.setBounds(18, 41, 310, 27);
        contextTopicsScreen.add(chooseTopicTextView);

        //Purple line under "Choose topic you want to practise"
        ImageIcon purpleLine = new ImageIcon("src/resources/purpleLineTopic.png");
        JLabel chooseTopicLine = new JLabel(purpleLine);
        chooseTopicLine.setBounds(0, 76, 324, 3);
        contextTopicsScreen.add(chooseTopicLine);

        //initializing GUI
        initGUI(contextTopicsScreen);
    }

    public static void addButton(JPanel panel, JLabel buttonName) {
        buttonName.setFont(new Font("Comfortaa", Font.PLAIN, 15));
        buttonName.setBorder(new EmptyBorder(10,0,10,0));//padding: top,left,bottom,right
        buttonName.setOpaque(false);
        buttonName.setBackground(new Color(30,152,215, 0));
        panel.add(buttonName);
    }

    public static void initGUI(JFrame screen) {
        //initializing GUI
        screen.setSize(375, 667); //Iphone 8
        screen.setLayout(null);
        screen.getContentPane().setBackground(new Color(129,211,248, 80) ); // set background color
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public static void mainMenuGUI() {
        JFrame mainMenuGUI = new JFrame();

        //setting logo
        JLabel panel = new JLabel();
        panel.setBounds(-15, 46, 396, 244);
        panel.setIcon(new ImageIcon(new ImageIcon("src/resources/logo.png").getImage().getScaledInstance(396, 244, Image.SCALE_SMOOTH)));
        mainMenuGUI.add(panel);

        //"Practice" Button
        ImageIcon mainMenuButtonsImage = new ImageIcon("src/resources/mainMenuButtons.png");
        JLabel practiceButton = new JLabel(mainMenuButtonsImage);
        practiceButton.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        practiceButton.setForeground(Color.white);
        practiceButton.setBounds(117,358,140,40);
        practiceButton.setHorizontalTextPosition(JButton.CENTER);
        practiceButton.setVerticalTextPosition(JButton.CENTER);
        practiceButton.setText("Practice");
        mainMenuGUI.add(practiceButton);

        practiceButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                mainMenuGUI.dispose();
                topicsChoiceGUI();
            }
        });

        //"Statistics" Button
        JLabel statisticsButton = new JLabel(mainMenuButtonsImage);
        statisticsButton.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        statisticsButton.setForeground(Color.white);
        statisticsButton.setBounds(117,425,140,40);
        statisticsButton.setHorizontalTextPosition(JButton.CENTER);
        statisticsButton.setVerticalTextPosition(JButton.CENTER);
        statisticsButton.setText("Statistics");
        mainMenuGUI.add(statisticsButton);

        statisticsButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                mainMenuGUI.dispose();
                //statisticsGUI();
            }
        });

        //"Preferences" Button
        JLabel preferencesButton = new JLabel(mainMenuButtonsImage);
        preferencesButton.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        preferencesButton.setForeground(Color.white);
        preferencesButton.setBounds(117,492,140,40);
        preferencesButton.setHorizontalTextPosition(JButton.CENTER);
        preferencesButton.setVerticalTextPosition(JButton.CENTER);
        preferencesButton.setText("Preferences");
        mainMenuGUI.add(preferencesButton);

        preferencesButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                mainMenuGUI.dispose();
                preferencesGUI();
            }
        });

        //"Quit" Button
        JLabel quitButton = new JLabel(mainMenuButtonsImage);
        quitButton.setFont(new Font("Comfortaa", Font.PLAIN, 13));
        quitButton.setForeground(Color.white);
        quitButton.setBounds(117,559,140,40);
        quitButton.setHorizontalTextPosition(JButton.CENTER);
        quitButton.setVerticalTextPosition(JButton.CENTER);
        quitButton.setText("Quit");
        mainMenuGUI.add(quitButton);

        quitButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                System.exit(1);
            }
        });

        //initializing GUI
        initGUI(mainMenuGUI);
    }

}

