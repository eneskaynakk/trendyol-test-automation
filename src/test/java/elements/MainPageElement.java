package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class MainPageElement {

    public MainPageElement() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="onetrust-reject-all-handler")
    public WebElement cookie;

    @FindBy(css="div[class='link account-user'] > p[class='link-text']")
    public WebElement loginLink;

    @FindBy(css="[data-testid='suggestion']")
    public WebElement searchBox;

    @FindBy(css="[data-testid='search-icon']")
    public WebElement searchClick;
}
