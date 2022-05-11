package com.company;



import com.company.GUI.AdministratorGUI;
import com.company.GUI.GUI;
import com.company.GUI.TopicsChoiceGUI;

public class Main {

    public static boolean keyVocab; //checkbox in preferences to show a key vocabulary

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.startGUI();
//        AdministratorGUI.startAdministrator();
//        TopicsChoiceGUI.startTopicsChoice();
    }
}
