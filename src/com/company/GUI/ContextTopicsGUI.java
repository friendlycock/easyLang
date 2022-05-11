package com.company.GUI;

import com.company.logger.LoginTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.company.GUI.GUI.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class ContextTopicsGUI extends JFrame {

    public static void startContextTopics() {
        JFrame contextTopicsScreen = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //if (LoginTracker.getCurrentUser().getUserLevel().equals("A1")) { //TO EDIT
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
        scrollPane.getVerticalScrollBar().setUnitIncrement(1);
        scrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(25, 117, 314, 460);
        JPanel contentPane = new JPanel(null);
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
}
