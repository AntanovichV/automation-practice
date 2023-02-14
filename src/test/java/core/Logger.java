package core;

import java.util.logging.Level;

public class Logger {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(Logger.class.getName());
    private static Logger instance = null;

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void info(String message) {
        log.log(Level.INFO, message);
    }

    public void warn(String message) {
        log.log(Level.WARNING, message);
    }

    public void logTestName(final String testName) {
        String formattedName = String.format("=====================  Test case: '%s' =====================", testName);

        String delims = "";
        int nChars = formattedName.length();
        for (int i = 0; i < nChars; i++) {
            delims += "-";
        }
        info(delims);
        info(formattedName);
        info(delims);
    }

    public void logTestEnd(final String testName) {
        info("");
        String formattedEnd = String.format("***** Test case: '%s' Passed *****", testName);
        String stars = "";
        int nChars = formattedEnd.length();
        for (int i = 0; i < nChars; i++) {
            stars += "*";
        }
        info(stars);
        info(formattedEnd);
        info(stars);
        info("");
    }
}
