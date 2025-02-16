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

    public void searchProduct(){
        clickElementWithWait(mainPageElement.searchBox);
        sendKeyToElement(mainPageElement.searchBox, "Kol Saati");
        clickElementWithWait(mainPageElement.searchClick);
    }
}
