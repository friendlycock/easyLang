package com.company.GUI;

import com.company.database.User;
import com.company.database.UserDAO;
import com.company.logger.ActivityTracker;
import com.company.logger.LoginTracker;
import jdk.swing.interop.SwingInterOpUtils;

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
                LoginGUI.startLogin(false);
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
                RegistrationGUI.startRegistration();
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
                TopicsChoiceGUI.startTopicsChoice();
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
                StatisticsGUI.startStatistics();
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
                PreferencesGUI.startPreferences();
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
                User currentUser = LoginTracker.getCurrentUser();
                ActivityTracker.userLogout();
                LoginTracker.setCurrentUser(null);
                UserDAO.getInstance().insertUpdateUser(currentUser);
                UserDAO.getInstance().closeConnection();
                System.exit(1);
            }
        });

        //initializing GUI
        initGUI(mainMenuGUI);
    }

}

