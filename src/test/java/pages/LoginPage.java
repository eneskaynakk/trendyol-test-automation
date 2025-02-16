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
        return getLoginVerificationText();
    }

    private void performLogin() {
        String userLoginEmail= ConfigReader.getProperty("email");
        String userLoginPassword= ConfigReader.getProperty("password");
        sendKeyToElement(loginPageElement.email, userLoginEmail);
        sendKeyToElement(loginPageElement.password, userLoginPassword);
        clickElementWithWait(loginPageElement.loginButton);
    }

    public String getLoginVerificationText() {
        waits(1);
        return getTextElement(mainPageElement.loginLink);
    }
}
