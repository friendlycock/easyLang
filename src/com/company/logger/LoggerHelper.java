package com.company.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerHelper {
    private static Logger logger = Logger.getLogger("EasyLangLogger");

    static {
        logger.setUseParentHandlers(false);
        FileHandler fh;

        try {

            // This block configures the logger with handler and formatter
            fh = new FileHandler("src/resources/logs/log.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String text) {
        logger.info(text);
    }
}
