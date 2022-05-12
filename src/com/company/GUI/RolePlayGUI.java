package com.company.GUI;

import com.company.Main;
import com.company.database.UserDAO;
import com.company.database.entities.Topic;
import com.company.database.entities.User;
import com.company.logger.LoginTracker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static com.company.GUI.GUI.*;

public class RolePlayGUI extends JFrame {
    private static int iA = 0;
    private static int iB = 0;
    private static StringBuilder rolePlayTextA = new StringBuilder();
    private static StringBuilder rolePlayTextB = new StringBuilder();
    private static boolean aChosen = true;

    public static void startRolePlay(Topic topic) {
        JFrame rolePlayScreen = new JFrame();
        User currentUser = LoginTracker.getCurrentUser();

        //"A button" Button
        ImageIcon buttonAImage = new ImageIcon("src/resources/buttonA.png");
        JLabel buttonA = new JLabel(buttonAImage);
        buttonA.setBounds(49,41,60,63);
        rolePlayScreen.add(buttonA);

        //"B button" Button
        ImageIcon buttonBImage = new ImageIcon("src/resources/buttonB.png");
        JLabel buttonB = new JLabel(buttonBImage);
        buttonB.setOpaque(false);
        buttonB.setBounds(257,41,60,63);
        rolePlayScreen.add(buttonB);

        //RolePlay panel
        JLabel rolePlayPanel = new JLabel();
        rolePlayPanel.setHorizontalAlignment(SwingConstants.LEFT);
        rolePlayPanel.setVerticalAlignment(SwingConstants.TOP);
        rolePlayPanel.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        rolePlayPanel.setBorder(new EmptyBorder(10,5,0,0));//top,left,b
        JScrollPane scroller = new JScrollPane(rolePlayPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.setBounds(27, 124, 310, 330);
        rolePlayScreen.add(scroller);

        //KeyWord panel
        JLabel keyWordPanel = new JLabel();
        keyWordPanel.setHorizontalAlignment(SwingConstants.LEFT);
        keyWordPanel.setVerticalAlignment(SwingConstants.TOP);
        keyWordPanel.setFont(new Font("Comfortaa", Font.PLAIN, 14));
        keyWordPanel.setBorder(new EmptyBorder(10,5,0,0));//top,left,b
        JScrollPane scroller2 = new JScrollPane(keyWordPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller2.setBounds(27, 460, 310, 80);
        rolePlayScreen.add(scroller2);

        if (Main.keyVocab) {
            keyWordPanel.setText(String.format("<html><div WIDTH=%d>%s</div></html>", 300, topic.getKeyVocab()));
        }

        String[] roleplay = topic.getText().split("\n");
        ArrayList<String> arrayA = new ArrayList<String>();
        ArrayList<String> arrayB = new ArrayList<String>();

        for (int i = 0; i < roleplay.length; i++) {
            if(i % 2 == 0)
                arrayA.add(roleplay[i]);
            else
                arrayB.add(roleplay[i]);
        }

        buttonA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonA.setEnabled(false);
                buttonB.setEnabled(true);
                aChosen = true;
                rolePlayPanel.setText(String.format("<html><div WIDTH=%d>%s</div></html>", 300, rolePlayTextA));

            }
        });

        buttonB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonB.setEnabled(false);
                buttonA.setEnabled(true);
                aChosen = false;
                rolePlayPanel.setText(String.format("<html><div WIDTH=%d>%s</div></html>", 300, rolePlayTextB));
            }
        });

        //"Next" Button
        ImageIcon nextImage = new ImageIcon("src/resources/getStartedButton.png");
        JLabel nextButton = new JLabel(nextImage);
        nextButton.setFont(new Font("Comfortaa", Font.PLAIN, 16));
        nextButton.setForeground(Color.white);
        nextButton.setBounds(107,569,152,42);
        nextButton.setHorizontalTextPosition(JButton.CENTER);
        nextButton.setVerticalTextPosition(JButton.CENTER);
        nextButton.setText("Next");
        rolePlayScreen.add(nextButton);

        nextButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if (aChosen) {
                    if (iA==arrayA.size()) {
                        rolePlayScreen.dispose();
                        mainMenuGUI();
                        currentUser.addCompletedTopic(topic.getId());
                    }
                    String temp = rolePlayTextA + arrayA.get(iA);
                    rolePlayPanel.setText(String.format("<html><div WIDTH=%d>%s</div></html>", 300, temp));
                    rolePlayTextA.append(arrayA.get(iA) + "<br/");
                    iA++;
                    if (iA==arrayA.size()) {
                        nextButton.setText("Finish");
                    }
                }
                else {
                    if (iB==arrayB.size()) {
                        rolePlayScreen.dispose();
                        mainMenuGUI();
                        currentUser.addCompletedTopic(topic.getId());
                    }
                    String temp = rolePlayTextB + arrayB.get(iB);
                    rolePlayPanel.setText(String.format("<html><div WIDTH=%d>%s</div></html>", 300, temp));
                    rolePlayTextB.append(arrayB.get(iB) + "<br/");
                    iB++;
                    if (iB==arrayB.size()) {
                        nextButton.setText("Finish");
                    }
                }



            }
        });
        //initializing GUI
        initGUI(rolePlayScreen);
    }
}
