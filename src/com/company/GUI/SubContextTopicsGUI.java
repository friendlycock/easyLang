package com.company.GUI;

import com.company.database.TopicDAO;
import com.company.database.entities.Topic;
import com.company.logger.LoginTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static com.company.GUI.GUI.addButton;
import static com.company.GUI.GUI.initGUI;

public class SubContextTopicsGUI {
    public static void startSubTopics() {
        JFrame subContextTopicsScreen = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        ArrayList<Topic> topicsForUserLevel = TopicDAO.getTopicsByLevel(LoginTracker.getCurrentUser().getUserLevel());
        ArrayList<String> usedSubContexts = new ArrayList<>();
        topicsForUserLevel.forEach( topic -> {
            String subContext = topic.getSubContext();
            if (usedSubContexts.contains(subContext))  return;
            usedSubContexts.add(subContext);
            JLabel button = new JLabel(subContext);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int topicId = usedSubContexts.indexOf(subContext);
                    Topic chosenTopic = topicsForUserLevel.get(topicId);
                    LoginTracker.getCurrentUser().addAccessedTopic(chosenTopic.getId());
                    subContextTopicsScreen.dispose();
                    RolePlayGUI.startRolePlay(chosenTopic);
                }
            });
            addButton(panel, button);
        });
        
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
        subContextTopicsScreen.setContentPane(contentPane);
        subContextTopicsScreen.pack();

        //"Choose topic you want to practise" TextView
        JLabel chooseTopicTextView = new JLabel();
        chooseTopicTextView.setFont(new Font("Comfortaa", Font.PLAIN, 18));
        chooseTopicTextView.setForeground(Color.black);
        chooseTopicTextView.setText("Choose topic you want to practise:");
        chooseTopicTextView.setHorizontalAlignment(SwingConstants.LEFT);
        chooseTopicTextView.setVerticalAlignment(SwingConstants.CENTER);
        chooseTopicTextView.setBounds(18, 41, 310, 27);
        subContextTopicsScreen.add(chooseTopicTextView);

        //Purple line under "Choose topic you want to practise"
        ImageIcon purpleLine = new ImageIcon("src/resources/purpleLineTopic.png");
        JLabel chooseTopicLine = new JLabel(purpleLine);
        chooseTopicLine.setBounds(0, 76, 324, 3);
        subContextTopicsScreen.add(chooseTopicLine);

        //initializing GUI
        initGUI(subContextTopicsScreen);
    }
}
