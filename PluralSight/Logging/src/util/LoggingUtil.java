package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

public class LoggingUtil {
    public static void initLogManager() throws IOException {
        LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
    }
}
