package com.company.GUI;

import com.company.database.User;
import com.company.database.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.company.GUI.GUI.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class AdministratorGUI extends JFrame{
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
        JScrollPane scroller = new JScrollPane(userPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.setBounds(27, 124, 322, 430);
        administratorScreen.add(scroller);

        ImageIcon backButtonImage = new ImageIcon("src/resources/backButton.png");
        JLabel backButton = new JLabel(backButtonImage);
        backButton.setBounds(15,570,45,45);
        administratorScreen.add(backButton);

        backButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                administratorScreen.dispose();
                GUI.mainMenuGUI();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDAO dao = UserDAO.getInstance();
                User user = dao.getUserByEmail(userSearch.getText());
                if (user.getUsername() == null) {
                    showMessageDialog(null, "User not found");
                    userPanel.setText("");
                } else {
                    userPanel.setText("<html>" + user + "</html>");
                }
            }
        });

        //initializing GUI
        initGUI(administratorScreen);
    }
}
