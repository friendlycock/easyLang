package com.company;

import com.company.database.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.company.GUI.*;
public class PreferencesGUI extends JFrame {

    public static void startPreferences() {
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
                User currentUser = LoginTracker.getCurrentUser();
                LoggerHelper.log(currentUser.getUsername() + " changed his preferences.");
                currentUser.setUserPracticeLanguage((String)practiceLangChoiceBox.getSelectedItem());
                currentUser.setUserLevel((String)langLevelBox.getSelectedItem());
                currentUser.setUserLanguage((String)langChoiceBox.getSelectedItem());
                UserDAO.getInstance().insertUpdateUser(currentUser);

                preferencesGUI.dispose();
                mainMenuGUI();
            }
        });

        //initializing GUI
        initGUI(preferencesGUI);
    }
}
