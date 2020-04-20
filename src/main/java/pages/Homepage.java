package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends BasePage
{
    static String plusXpath= "//div[@class='sidebar-status-toggle']/div/button/img";
    static String addCannedXpath = "//div[@class='sidebar-status-toggle']/div/ul/li[3]";
    static String addInvite = "//div[@class='sidebar-status-toggle']/div/ul/li[1]";
    static String acceptChatXPath ="//div[@class='ns-content']/div[2]/button[2]";
    static String chatBodyXpath = "//div[@class='expanding-wrapper']";
    static String closeChatXpath = "//*[@id='chat-container']/div[2]/div[2]/div[1]/img[3]";
    static String yesXpath = "//*[@id='chat-container']/div[2]/div[1]/div[1]/div[4]/button[1]";
    static String menuButtonXpath ="//button[@class='menu-button']/img";
    static String logoutXpath = "//div[@class='link-list']/a[5]/img";

    //WebDriverWait wait = new WebDriverWait(driver, 10);

    public static void addCannedResponse()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        handleAlert();
        driver.findElement(By.xpath(plusXpath)).click();
        driver.findElement(By.xpath(addCannedXpath)).click();
        handleAlert();


    }

    public static void invite()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        handleAlert();
        try
        {
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(plusXpath)).click();
        driver.findElement(By.xpath(addInvite)).click();

        handleAlert();
    }

    public static void openChatAndSendCannedResponse()
    {
        handleAlert();

        driver.findElement(By.xpath(acceptChatXPath)).click();
        driver.findElement(By.xpath(chatBodyXpath)).sendKeys("#S"+Keys.ENTER);
        driver.findElement(By.xpath(chatBodyXpath)).sendKeys(Keys.ENTER);
        handleAlert();
    }

    public static void closeChat()
    {
        handleAlert();
        driver.findElement(By.xpath(closeChatXpath)).click();
        driver.findElement(By.xpath(yesXpath)).click();

    }

    public static void signOut()
    {
        driver.findElement(By.xpath(menuButtonXpath)).click();
        driver.findElement(By.xpath(logoutXpath)).click();
    }
}
