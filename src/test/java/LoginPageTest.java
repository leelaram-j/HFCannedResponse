import org.testng.annotations.Test;
import pages.Pages;

public class LoginPageTest extends BaseTest
{
    @Test
    public void sampleTest()
    {
        Pages.loginPage().login();
    }
}
