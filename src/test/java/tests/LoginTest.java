package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        String webSiteUrl = ConfigReader.getProperty("url");
        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);

        getAppLibrary().getPageLibrary().getMainPage().closeCookie();
        getAppLibrary().getPageLibrary().getMainPage().navigateToLoginPage();

        String actualResult = getAppLibrary().getPageLibrary().getLoginPage().loginProcess();
        String expectedAccountText = "Hesabım";
        Assert.assertEquals(actualResult,expectedAccountText);
    }

    @Test
    public void unsuccessfulLoginTest() {
        String webSiteUrl = ConfigReader.getProperty("url");
        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);

        getAppLibrary().getPageLibrary().getMainPage().closeCookie();
        getAppLibrary().getPageLibrary().getMainPage().navigateToLoginPage();

        getAppLibrary().getPageLibrary().getLoginPage().fillMail();
        getAppLibrary().getPageLibrary().getLoginPage().clickLoginButton();

        String acutualResult = getAppLibrary().getPageLibrary().getLoginPage().errorMessageControl();
        String expectedErrorText = "Lütfen şifrenizi giriniz.";
        Assert.assertEquals(acutualResult, expectedErrorText);
    }
}
