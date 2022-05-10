package com.company.GUI;

import javax.swing.*;
import java.awt.*;

import static com.company.GUI.GUI.addButton;
import static com.company.GUI.GUI.initGUI;

public class StatisticsGUI extends JFrame {

    public static void startStatistics() {
        JFrame statisticsScreen = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("1st statistics field");
        addButton(panel, label);
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
        contentPane.add(scrollPane);
        statisticsScreen.setContentPane(contentPane);
        statisticsScreen.pack();

        //"Choose topic you want to practise" TextView
        JLabel chooseTopicTextView = new JLabel();
        chooseTopicTextView.setFont(new Font("Comfortaa", Font.PLAIN, 18));
        chooseTopicTextView.setForeground(Color.black);
        chooseTopicTextView.setText("Statistics");
        chooseTopicTextView.setHorizontalAlignment(SwingConstants.LEFT);
        chooseTopicTextView.setVerticalAlignment(SwingConstants.CENTER);
        chooseTopicTextView.setBounds(18, 41, 310, 27);
        statisticsScreen.add(chooseTopicTextView);

        //Purple line under "Choose topic you want to practise"
        ImageIcon purpleLine = new ImageIcon("src/resources/purpleLineTopic.png");
        JLabel chooseTopicLine = new JLabel(purpleLine);
        chooseTopicLine.setBounds(0, 76, 105, 3);
        statisticsScreen.add(chooseTopicLine);

        //initializing GUI
        initGUI(statisticsScreen);
    }
}
