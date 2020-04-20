package pages;

import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class InvitePage extends BasePage
{
    static String inviteURLXpath= "//input[@id='chatInviteUrl']";
    static String closeXpath = "//span[@class='fa fa-times']";
    static String navigateXpath = "//fieldset[@class='share-link']/label/a";

    public static String getChatURL()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String chatURL = driver.findElement(By.xpath(inviteURLXpath)).getText();
        handleAlert();
        driver.findElement(By.xpath(closeXpath)).click();
        return chatURL;
    }

//    public static void navigateToChatPage()
//    {
//        driver.findElement(By.xpath(navigateXpath)).click();
//        Set<String> ids = driver.getWindowHandles();
//        Iterator<String> =
//
//    }


}
