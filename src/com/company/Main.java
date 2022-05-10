package com.company;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.company.GUI.GUI;

public class Main {

    public static boolean keyVocab; //checkbox in preferences to show a key vocabulary

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("MyLog");
        logger.setUseParentHandlers(false);
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("src/resources/logs/log.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("My first log");

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

        logger.info("App started");

        GUI gui = new GUI();
        gui.startGUI();

    }
}
