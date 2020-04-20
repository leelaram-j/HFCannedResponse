package pages;

public class Pages
{
    public static LoginPage loginPage()
    {
        return new LoginPage();
    }

    public static Homepage homePage()
    {
        return new Homepage();
    }

    public static CannedResponse cannedResponse()
    {
        return new CannedResponse();
    }

    public static InvitePage invitePage()
    {
        return new InvitePage();
    }

    public static ChatPage chatPage()
    {
        return new ChatPage();
    }


}
