package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class LoginTest extends BaseTest {
    private final Logger logger = LogManager.getLogger(LoginTest.class.getName());

    @Test(priority = 1, groups = {"smoke","regression"}, description = "Login with only email.")
    public void emailOnlyLoginTest () {
        testCaseId = "3";
        logger.info("Login with only email");
        String webSiteUrl = ConfigReader.getProperty("url");
        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);
        getAppLibrary().getPageLibrary().getMainPage().navigateToLoginPage();

        getAppLibrary().getPageLibrary().getLoginPage().fillMail();

        String acutualResult = getAppLibrary().getPageLibrary().getLoginPage().errorMessageControl();
        String expectedErrorText = "Lütfen şifrenizi giriniz.";
        Assert.assertEquals(acutualResult, expectedErrorText);

        getAppLibrary().getFlowsLibrary().refreshPage();
    }

    @Test(priority = 2, groups = {"smoke","regression"}, description = "Login with only password.")
    public void passwordOnlyLoginTest() {
        testCaseId = "4";
        logger.info("Login with only password");
        getAppLibrary().getPageLibrary().getLoginPage().fillPassword();

        String acutualResult = getAppLibrary().getPageLibrary().getLoginPage().errorMessageControl();
        String expectedErrorText = "Lütfen geçerli bir e-posta adresi giriniz.";
        Assert.assertEquals(acutualResult, expectedErrorText);

        getAppLibrary().getFlowsLibrary().refreshPage();
    }

    @Test(priority = 3, groups = {"smoke","regression"}, description = "Login with both incorrect username and password.")
    public void invalidCredentialsLoginTest() {
        testCaseId = "5";
        logger.info("Login with both incorrect username and password");
        getAppLibrary().getPageLibrary().getLoginPage().wrongEmailOrPassword();

        String acutualResult = getAppLibrary().getPageLibrary().getLoginPage().errorMessageControl();
        String expectedErrorText = "E-posta adresiniz ve/veya şifreniz hatalı.";
        Assert.assertEquals(acutualResult, expectedErrorText);

        getAppLibrary().getFlowsLibrary().refreshPage();
    }

    @Test(priority = 4, groups = {"smoke","regression"}, description = "Login with correct email and password.")
    public void successfulLoginTest() {
        testCaseId = "6";
        logger.info("Login with correct email and password");
        String actualResult = getAppLibrary().getPageLibrary().getLoginPage().loginProcess();
        String expectedAccountText = "Hesabım";
        Assert.assertEquals(actualResult,expectedAccountText);
    }
}