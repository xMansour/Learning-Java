import util.LoggingUtil;

import java.io.IOException;
import java.util.logging.*;

public class LoggingDemo {
    private static final Logger LOGGER = Logger.getLogger(LoggingDemo.class.getName());    //best practise is to use the class name as the logger name

    //Using log manager, we can remove all this configuration
    /*static {
        //ConsoleHandler consoleHandler = new ConsoleHandler();
        //consoleHandler.setLevel(Level.FINEST);
        //LOGGER.addHandler(consoleHandler);
        //LOGGER.setLevel(Level.FINEST);
        //Logging to a file
        try {
            FileHandler fileHandler = new FileHandler(LoggingDemo.class.getName() + ".log");
            fileHandler.setLevel(Level.FINEST);
            fileHandler.setFormatter(new SimpleFormatter());    //to change it to plain text not xml
            //fileHandler.setFilter(record -> record.getMessage().contains("an"));    //filters could be added to handlers or loggers.
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.FINEST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }*/

    public static void main(String[] args){
        //Only Severe to Info are being displayed because the logging level is set to info by the console handler
        //To change this behaviour, we should add a handler
        try {
            LoggingUtil.initLogManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.log(Level.SEVERE, "This is a SEVERE level message");
        LOGGER.log(Level.WARNING, "This is a WARNING level message");
        LOGGER.log(Level.INFO, "This is an INFO level message");
        LOGGER.log(Level.CONFIG, "This is a CONFIG level message");    //Not printed
        LOGGER.log(Level.FINE, "This is a FINE level message");    //Not printed
        LOGGER.log(Level.FINER, "This is a FINER level message");  //Not printed
        LOGGER.log(Level.FINEST, "This is a FINEST level message");    //Not printed

    }
}