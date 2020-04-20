package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogger
{
    public static final Logger log = LogManager.getLogger(CustomLogger.class);

    public static void logInfo(String s)
    {
        log.info(s);
    }
}
