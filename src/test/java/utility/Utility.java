package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.library.FlowsLibrary;

import java.time.Duration;

public class Utility extends FlowsLibrary {

    public void clickElementWithWait(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(element)).click();
        } catch (TimeoutException e) {
            ScreenshotSendEmail.screenshotMailer(element);
        }
    }

    public void scrollToCenter(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public void scrollAndClickElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            wait.until(ExpectedConditions.visibilityOf(element)).click();
        } catch (TimeoutException e) {
            ScreenshotSendEmail.screenshotMailer(element);
        }
    }

    public void sendKeyToElement(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        } catch (TimeoutException e) {
            ScreenshotSendEmail.screenshotMailer(element);
        }
    }

    public String getTextElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void clearElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
    }

    public static void waits(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
