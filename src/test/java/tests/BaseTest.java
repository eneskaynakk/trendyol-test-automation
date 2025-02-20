package tests;

import org.testng.annotations.*;
import utility.Driver;
import utility.library.AppLibrary;

import java.time.Duration;

public class BaseTest {
    AppLibrary appLibrary;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        appLibrary = new AppLibrary();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Driver.closeDriver();
    }

    public AppLibrary getAppLibrary() {
        return appLibrary;
    }
}