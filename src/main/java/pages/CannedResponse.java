package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CannedResponse extends BasePage
{
    static String snippetXpath = "//input[@class='snippet-text']";
    static String expansionXpath = "//textarea[@class='expansion-text']";
    static String addXpath = "//button[@form='add-response-form']";


    public static void enterCannedResponse()
    {
        handleAlert();

        if(driver.findElements(By.xpath(snippetXpath)).size()>0) {
            driver.findElement(By.xpath(snippetXpath)).sendKeys("SampleSnippet");
            driver.findElement(By.xpath(expansionXpath)).sendKeys("This is a sample Expansion.");
            handleAlert();
            driver.findElement(By.xpath(addXpath)).click();
            handleAlert();
        }
        else {
            System.out.println("form not visible");
        }
    }
}
