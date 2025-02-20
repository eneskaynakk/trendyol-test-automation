package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class LoginTest extends BaseTest {

    @Test(priority = 1, groups = {"smoke","regression"})
    public void loginEmailOnly() {
        String webSiteUrl = ConfigReader.getProperty("url");
        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);
        getAppLibrary().getPageLibrary().getMainPage().navigateToLoginPage();

        getAppLibrary().getPageLibrary().getLoginPage().fillMail();

        String acutualResult = getAppLibrary().getPageLibrary().getLoginPage().errorMessageControl();
        String expectedErrorText = "Lütfen şifrenizi giriniz.";
        Assert.assertEquals(acutualResult, expectedErrorText);

        getAppLibrary().getFlowsLibrary().refreshPage();
    }

    @Test(priority = 2, groups = {"smoke","regression"})
    public void loginPasswordOnly() {
        getAppLibrary().getPageLibrary().getLoginPage().fillPassword();

        String acutualResult = getAppLibrary().getPageLibrary().getLoginPage().errorMessageControl();
        String expectedErrorText = "Lütfen geçerli bir e-posta adresi giriniz.";
        Assert.assertEquals(acutualResult, expectedErrorText);

        getAppLibrary().getFlowsLibrary().refreshPage();
    }

    @Test(priority = 3, groups = {"smoke","regression"})
    public void loginInvalid() {
        getAppLibrary().getPageLibrary().getLoginPage().wrongEmailOrPassword();

        String acutualResult = getAppLibrary().getPageLibrary().getLoginPage().errorMessageControl();
        String expectedErrorText = "E-posta adresiniz ve/veya şifreniz hatalı.";
        Assert.assertEquals(acutualResult, expectedErrorText);

        getAppLibrary().getFlowsLibrary().refreshPage();
    }

    @Test(priority = 4, groups = {"smoke","regression"})
    public void successfulLoginTest() {
        String actualResult = getAppLibrary().getPageLibrary().getLoginPage().loginProcess();
        String expectedAccountText = "Hesabım";
        Assert.assertEquals(actualResult,expectedAccountText);
    }
}