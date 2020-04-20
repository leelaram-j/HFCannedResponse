package pages;

import logger.CustomLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage
{
    static String emailXpath = "//input[@id='email']";
    static String passwordXpath = "//input[@id='password']";
    static String submitXpath = "//button[@id='login-submit']";
    static String modalXpath = "//h2[@id='onboarding-modal-header']";
    static String modalLaterXpath = "//label[@for='installation-type-do-it-later']";
    static String nextXpath = "//div[@class='js-onbarding-welcome-step'][5]/div[2]/button[2]";



    public LoginPage()
    {
        super();
    }

    public static void login()
    {
        driver.findElement(By.xpath(emailXpath)).sendKeys(prop.getProperty("email"));
        driver.findElement(By.xpath(passwordXpath)).sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath(submitXpath)).click();
        CustomLogger.logInfo("Login is successful");
        try{
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modalXpath)));
        driver.findElement(By.xpath(modalLaterXpath)).click();
        driver.findElement(By.xpath(nextXpath)).click();

    }
}
