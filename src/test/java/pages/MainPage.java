package pages;

import elements.MainPageElement;
import utility.Utility;

public class MainPage extends Utility {
    MainPageElement mainPageElement = new MainPageElement();

    public void navigateToLoginPage() {
        closeCookie();
        clickElementWithWait(mainPageElement.loginLink);
    }

    public void closeCookie() {
        clickElementWithWait(mainPageElement.cookie);
    }

    public void searchProduct() {
        clickElementWithWait(mainPageElement.searchBox);
        sendKeyToElement(mainPageElement.searchBox, "Kol Saati");
        clickElementWithWait(mainPageElement.searchClick);
    }
}
