package pages;

import elements.MainPageElement;
import utility.Utility;

public class MainPage extends Utility {
    MainPageElement mainPageElement = new MainPageElement();

    public void closeCookie() {
        clickElementWithWait(mainPageElement.cookie);
    }

    public void navigateToLoginPage() {
        clickElementWithWait(mainPageElement.loginLink);
    }

}
