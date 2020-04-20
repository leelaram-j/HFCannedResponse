package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import utils.WindowSwitcher;

import java.util.Iterator;
import java.util.Set;

public class ChatPage extends BasePage
{
    static String chatButtonXpath = "//div[@class='badge-image']/img";
    static String nameXpath = "//input[@name='name']";
    static String emailXpath = "//input[@name='email']";
    static String submitXpath = "//div[@class='button-content']";
    static String replyXpath = "//textarea[@id='reply-textarea']";

    public static void loadChatPage(String URL)
    {
        // here this can be optimized based on OS.
        handleAlert();
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
        String s = WindowSwitcher.getChildWindow(driver.getWindowHandles());
        driver.switchTo().window(s);
        driver.get(URL);
    }

    public static void loadChat()
    {
        handleAlert();
        driver.findElement(By.xpath(chatButtonXpath)).click();
        driver.findElement(By.xpath(nameXpath)).sendKeys("TESTUSER");
        driver.findElement(By.xpath(emailXpath)).sendKeys("test@test.com");
        driver.findElement(By.xpath(submitXpath)).click();
        try {
            Thread.sleep(2000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(replyXpath)).sendKeys("test");
        String s = WindowSwitcher.getParentWindow(driver.getWindowHandles());
        driver.switchTo().window(s);
    }


}
