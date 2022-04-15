package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {

    public static String quoteArray [] = {"\"A different language is a different vision of life.\"",
            "\"The limits of my language mean the limits of my world.\"",
            "\"One language sets you in a corridor for life. Two languages open every door along the way.\"",
            "\"Change your language and you change your thoughts.\"",
            "\"Knowledge of languages is the doorway to wisdom.\"",
            "\"Learning is a treasure that will follow its owner everywhere.\"",
            "\"Learn a new language and get a new soul.\""};

    public static void startGUI() {
        JFrame languageApp = new JFrame();

        //setting logo
        JLabel panel = new JLabel();
        panel.setBounds(-15, 46, 396, 244);
        panel.setIcon(new ImageIcon(new ImageIcon("src/resources/logo.png").getImage().getScaledInstance(396, 244, Image.SCALE_SMOOTH)));
        languageApp.add(panel);

        //"I have an account" Button
        ImageIcon haveAccountImage = new ImageIcon("src/resources/haveAccountButton.png");
        JLabel haveAccountButton = new JLabel(haveAccountImage);
        haveAccountButton.setFont(new Font("Comfortaa", Font.PLAIN, 8));
        haveAccountButton.setBounds(125,570,122,27);
        haveAccountButton.setHorizontalTextPosition(JButton.CENTER);
        haveAccountButton.setVerticalTextPosition(JButton.CENTER);
        haveAccountButton.setText("I HAVE AN ACCOUNT");
        languageApp.add(haveAccountButton);

        //"Get Started" Button
        ImageIcon getStartedImage = new ImageIcon("src/resources/getStartedButton.png");
        JLabel getStartedButton = new JLabel(getStartedImage);
        getStartedButton.setFont(new Font("Comfortaa", Font.PLAIN, 12));
        getStartedButton.setBounds(111,508,152,42);
        getStartedButton.setHorizontalTextPosition(JButton.CENTER);
        getStartedButton.setVerticalTextPosition(JButton.CENTER);
        getStartedButton.setText("GET STARTED");
        languageApp.add(getStartedButton);

        /*getStartedButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                // you can open a new frame here as
                // i have assumed you have declared "frame" as instance variable
                frame = new JFrame("new frame");
                frame.setVisible(true);

            }
        });*/

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
        languageApp.add(quoteLabel);

        //initializing GUI
        languageApp.setSize(375, 667); //Iphone 8
        languageApp.setLayout(null);
        languageApp.getContentPane().setBackground(new Color(129,211,248, 80) ); // set background color
        languageApp.setVisible(true);
        languageApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

