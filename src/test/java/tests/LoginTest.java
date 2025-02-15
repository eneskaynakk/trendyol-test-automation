package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        String webSiteUrl = ConfigReader.getProperty("url");
        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);

        getAppLibrary().getPageLibrary().getMainPage().closeCookie();
        getAppLibrary().getPageLibrary().getMainPage().navigateToLoginPage();
        String actualResult = getAppLibrary().getPageLibrary().getLoginPage().loginProcess();

        String expectedAccountText = "Hesabım";
        Assert.assertEquals(actualResult,expectedAccountText);
    }
}
