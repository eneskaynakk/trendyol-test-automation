package utility.library;

import org.openqa.selenium.WebDriver;
import utility.Driver;

public class FlowsLibrary {
    private final WebDriver driver;

    public FlowsLibrary() {
        this.driver = Driver.getDriver();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void switchToNewTab() {
        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
