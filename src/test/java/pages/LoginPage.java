package pages;

import elements.LoginPageElement;
import elements.MainPageElement;
import utility.ConfigReader;
import utility.Utility;

public class LoginPage extends Utility {
    LoginPageElement loginPageElement = new LoginPageElement();
    MainPageElement mainPageElement = new MainPageElement();

    public void fillMail() {
        String userLoginEmail= ConfigReader.getProperty("email");
        sendKeyToElement(loginPageElement.email, userLoginEmail);
        clickElementWithWait(loginPageElement.loginButton);
    }

    public void fillPassword() {
        String userLoginPassword= ConfigReader.getProperty("password");
        sendKeyToElement(loginPageElement.password, userLoginPassword);
        clickElementWithWait(loginPageElement.loginButton);
    }

    public void wrongEmailOrPassword() {
        String userLoginEmail= ConfigReader.getProperty("email");
        sendKeyToElement(loginPageElement.email, userLoginEmail);
        String userLoginPassword= "asdasd";
        sendKeyToElement(loginPageElement.password, userLoginPassword);
        clickElementWithWait(loginPageElement.loginButton);
    }

    public String loginProcess() {
        String userLoginEmail= ConfigReader.getProperty("email");
        sendKeyToElement(loginPageElement.email, userLoginEmail);
        String userLoginPassword= ConfigReader.getProperty("password");
        sendKeyToElement(loginPageElement.password, userLoginPassword);
        clickElementWithWait(loginPageElement.loginButton);
        return getLoginVerificationText();
    }

    public String errorMessageControl() {
        return getTextElement(loginPageElement.errorMessage);
    }

    public String getLoginVerificationText() {
        waits(1000);
        return getTextElement(mainPageElement.loginLink);
    }
}
