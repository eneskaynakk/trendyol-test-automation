package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class LoginPageElement {

    public LoginPageElement() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login-email")
    public WebElement email;

    @FindBy(id = "login-password-input")
    public WebElement password;

    @FindBy(css = "[type='submitt']")
    public WebElement loginButton;

    @FindBy(className = "message")
    public WebElement errorMessage;
}
