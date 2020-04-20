import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.BasePage;

public class BaseTest extends BasePage
{
    @BeforeTest
    public void setup()
    {

    }

    @AfterTest
    public void destruct()
    {
        driver.quit();
    }
}
