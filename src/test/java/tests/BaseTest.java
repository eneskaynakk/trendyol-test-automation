package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.Driver;
import utility.library.AppLibrary;

import java.time.Duration;

public class BaseTest {
    AppLibrary appLibrary;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        appLibrary = new AppLibrary();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    public AppLibrary getAppLibrary() {
        return appLibrary;
    }

}
