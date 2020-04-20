package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.util.Properties;

public abstract class BasePage
{
    static final Logger log = LogManager.getLogger(BasePage.class);
    public static WebDriver driver;
    public static Properties prop = getProperties();
    //public static WebDriverWait wait = new WebDriverWait(driver,10);
    private String currentPath = System.getProperty("user.dir");

    public BasePage ()
    {
        String baseUrl = prop.getProperty("baseUrl");
        log.info("Base Url is set "+baseUrl);
        String browser = prop.getProperty("defaultBrowser");
        log.info("Browser value is  "+browser);
        try
        {
            driver = DriverUtils.getDriver(driver,browser,baseUrl);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public static Properties getProperties()
    {
        InetAddress host =null;
        prop = new Properties();
        try
        {
            prop.load(new FileInputStream("/Users/lee/Documents/HFCannedModule/src/main/resources/env-qa.properties"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return prop;
    }

    public static boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }catch(NoAlertPresentException ex){
            return false;
        }
    }

    public static void handleAlert(){
        if(isAlertPresent()){
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.dismiss();
        }
    }
}
