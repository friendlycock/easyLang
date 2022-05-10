package com.company.GUI;

import com.company.database.LoginTracker;
import com.company.database.User;
import com.company.database.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.company.GUI.GUI.*;
public class LevelChoiceGUI extends JFrame {

    public static void startLevelChoice() {
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
                User user = LoginTracker.getCurrentUser();
                user.setUserLevel((String)langLevelBox.getSelectedItem());
                user.setUserLanguage((String)langChoiceBox.getSelectedItem());
                user.setUserPracticeLanguage((String)practiceLangChoiceBox.getSelectedItem());
                UserDAO.getInstance().insertUpdateUser(user);
                levelChoiceGUI.dispose();
                mainMenuGUI();
            }
        });

        //initializing GUI
        initGUI(levelChoiceGUI);
    }
}
