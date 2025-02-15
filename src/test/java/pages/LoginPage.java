package pages;

import elements.LoginPageElement;
import elements.MainPageElement;
import utility.ConfigReader;
import utility.Utility;

public class LoginPage extends Utility {
    LoginPageElement loginPageElement = new LoginPageElement();
    MainPageElement mainPageElement = new MainPageElement();

    public String loginProcess() {
        performLogin();
        return getLoginVerificationTexts();
    }

    private void performLogin() {
        String userLoginEmail= ConfigReader.getProperty("email");
        String userLoginPassword= ConfigReader.getProperty("password");
        sendKeyToElement(loginPageElement.email, userLoginEmail);
        sendKeyToElement(loginPageElement.password, userLoginPassword);
        clickElementWithWait(loginPageElement.loginButton);
    }

    public String getLoginVerificationTexts() {
        return getTextElementWithWait(mainPageElement.loginLink, 1);
    }
}
