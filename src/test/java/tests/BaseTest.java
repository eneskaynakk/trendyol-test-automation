package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utility.Driver;
import utility.library.AppLibrary;

import java.time.Duration;

public class BaseTest {
    AppLibrary appLibrary;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        appLibrary = new AppLibrary();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Driver.closeDriver();
    }

    public AppLibrary getAppLibrary() {
        return appLibrary;
    }
}
