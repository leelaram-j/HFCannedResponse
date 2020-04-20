import org.testng.annotations.Test;
import pages.Pages;

public class CannedResponseTest //extends BaseTest
{
    @Test
    public void addcannedResponseTest()
    {
        Pages.loginPage().login();
        Pages.homePage().addCannedResponse();
        Pages.cannedResponse().enterCannedResponse();
    }

    @Test
    public void validateCannedResponseTest()
    {
        Pages.loginPage().login();
        Pages.homePage().addCannedResponse();
        Pages.cannedResponse().enterCannedResponse();
        Pages.homePage().invite();
        String s = Pages.invitePage().getChatURL();
        Pages.chatPage().loadChatPage(s);
        Pages.chatPage().loadChat();
        Pages.homePage().openChatAndSendCannedResponse();
        Pages.homePage().closeChat();
        Pages.homePage().signOut();


    }
}
