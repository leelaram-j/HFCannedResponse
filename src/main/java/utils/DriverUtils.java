package utils;


import driverFactory.DriverFactory;
import logger.CustomLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static utils.Constants.*;
import static logger.CustomLogger.*;
public class DriverUtils
{
    static final Logger log = LogManager.getLogger(DriverUtils.class);
    private static Properties prop;

    public static WebDriver getDriver(WebDriver driver, String browser, String baseURL) throws Exception
    {
        prop = new Properties();
        prop.load(new FileInputStream(DRIVER_PROP_FILE));
        if(isWindows())
        {
            if(browser.equalsIgnoreCase("firefox"))
            {
                System.setProperty("webdriver.gecko.driver",prop.getProperty(FIREFOX_DRIVER_WIN));
                driver = DriverFactory.getInstance().getDriver("firefox");
            }
            if(browser.equalsIgnoreCase("chrome"))
            {
                System.setProperty("webdriver.chrome.driver",prop.getProperty(CHROME_DRIVER_WIN));
                driver = DriverFactory.getInstance().getDriver("chrome");
            }
        }
        else if(isMac())
        {
            if(browser.equalsIgnoreCase("firefox"))
            {
                System.setProperty("webdriver.gecko.driver",prop.getProperty(FIREFOX_DRIVER_MAC));
                driver = DriverFactory.getInstance().getDriver("firefox");
            }
            if(browser.equalsIgnoreCase("chrome"))
            {
                System.setProperty("webdriver.chrome.driver",prop.getProperty(CHROME_DRIVER_MAC));
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                driver = DriverFactory.getInstance().getDriver("chrome",options);
                CustomLogger.logInfo("Chrome Driver is initialized");

            }
        }

        driver.get(baseURL);
        driver.manage().window().fullscreen();
        //long implicitWait = Long.parseLong(prop.getProperty("implicitWaitTimeout"));
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        return driver;
    }

    private static boolean isWindows()
    {
        String os = System .getProperty("os.name");
        return os.startsWith("Windows");
    }

    private static boolean isMac()
    {
        String os = System.getProperty("os.name");
        return os.startsWith("Mac");
    }
}
