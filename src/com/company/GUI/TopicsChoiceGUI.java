package com.company.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.company.GUI.GUI.*;

public class TopicsChoiceGUI extends JFrame {

    public static void startTopicsChoice() {
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
                ContextTopicsScreenGUI.startContextTopics();
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
}
