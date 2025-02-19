package pages;

import elements.LoginPageElement;
import elements.MainPageElement;
import utility.ConfigReader;
import utility.Utility;

public class LoginPage extends Utility {
    LoginPageElement loginPageElement = new LoginPageElement();
    MainPageElement mainPageElement = new MainPageElement();

    public String loginProcess() {
        fillMail();
        fillPassword();
        clickLoginButton();
        return getLoginVerificationText();
    }

    public void fillMail() {
        String userLoginEmail= ConfigReader.getProperty("email");
        sendKeyToElement(loginPageElement.email, userLoginEmail);
    }

    public void fillPassword() {
        String userLoginPassword= ConfigReader.getProperty("password");
        sendKeyToElement(loginPageElement.password, userLoginPassword);
    }

    public void clickLoginButton() {
        clickElementWithWait(loginPageElement.loginButton);
    }

    public String errorMessageControl(){
        return getTextElement(loginPageElement.errorMessage);
    }

    public String getLoginVerificationText() {
        waits(500);
        return getTextElement(mainPageElement.loginLink);
    }
}
