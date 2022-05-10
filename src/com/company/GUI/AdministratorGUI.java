package com.company.GUI;

import javax.swing.*;
import java.awt.*;

import static com.company.GUI.GUI.addButton;
import static com.company.GUI.GUI.initGUI;

public class AdministratorGUI {
    public static void startAdministrator() {
        JFrame administratorScreen = new JFrame();
        JTextField userSearch = new JTextField();
        userSearch.setBounds(27,60,250,25);
        administratorScreen.add(userSearch);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(290,60,62,24);
        searchButton.setFont(new Font("Comfortaa", Font.PLAIN, 8));
        administratorScreen.add(searchButton);

        //label to get User info
        JLabel userPanel = new JLabel();
        userPanel.setBounds(27, 124, 250, 460);
        userPanel.setOpaque(false);
        administratorScreen.add(userPanel);

        //initializing GUI
        initGUI(administratorScreen);
    }
}
