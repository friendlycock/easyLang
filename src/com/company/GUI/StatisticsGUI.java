//Authors: Bohdan Rudenko, Pavels Kuznecovs

package com.company.GUI;

import com.company.database.TopicDAO;
import com.company.database.entities.User;
import com.company.logger.LoginTracker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

        label.setText("<html>" + getUserStatistic() +"</html>");


        JLabel statisticsTextView = new JLabel();
        statisticsTextView.setFont(new Font("Comfortaa", Font.PLAIN, 18));
        statisticsTextView.setForeground(Color.black);
        statisticsTextView.setText("Statistics");
        statisticsTextView.setHorizontalAlignment(SwingConstants.LEFT);
        statisticsTextView.setVerticalAlignment(SwingConstants.CENTER);
        statisticsTextView.setBounds(18, 41, 310, 27);
        statisticsScreen.add(statisticsTextView);



        ImageIcon purpleLine = new ImageIcon("src/resources/purpleLineTopic.png");
        JLabel statisticsLine = new JLabel(purpleLine);
        statisticsLine.setBounds(0, 76, 105, 3);
        statisticsScreen.add(statisticsLine);

        //initializing GUI
        initGUI(statisticsScreen);
    }

    private static String getUserStatistic() {
        StringBuilder result = new StringBuilder("Topics you accessed:<br>");
        User user = LoginTracker.getCurrentUser();
        int[] accessedTopics = user.getAccessedTopicsCount();
        int[] completedTopics = user.getCompletedTopicsCount();

        for (int i = 0; i < accessedTopics.length; i++) {
            if(accessedTopics[i] == 0) continue;
            result.append("Topic: ");
            ArrayList<String> context = TopicDAO.getTopicContextAndSubcontext(i);
            result.append(context.get(0)).append("<br>").append(context.get(1)).append("<br>");
            result.append("Accessed: ").append(accessedTopics[i]).append(" ").append("times").append("<br><br>");
        }
        result.append("Completed topics:<br>");
        for (int i = 0; i < completedTopics.length; i++) {
            if(completedTopics[i] == 0) continue;
            result.append("Topic: ");
            ArrayList<String> context = TopicDAO.getTopicContextAndSubcontext(i);
            result.append(context.get(0)).append("<br>").append(context.get(1)).append("<br>");
            result.append("Completed: ").append(completedTopics[i]).append(" ").append("times").append("<br><br>");
        }

        return result.toString();
    }
}
