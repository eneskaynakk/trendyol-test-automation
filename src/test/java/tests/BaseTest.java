package tests;

import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.Driver;
import utility.TestRailManager;
import utility.library.AppLibrary;

import java.time.Duration;

public class BaseTest {
    AppLibrary appLibrary;
    protected String testCaseId;

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

    @AfterMethod(alwaysRun = true)
    public void addResultsToTestRail(ITestResult result) {
        if(result.getStatus() == ITestResult.SUCCESS){
            TestRailManager.addResultsForTestCase(testCaseId, "PASSED : " + result.getName() + " ", TestRailManager.testCasePassStatus);
        }else if(result.getStatus() == ITestResult.FAILURE) {
            TestRailManager.addResultsForTestCase(testCaseId, "FAILED : " + result.getName() + " ", TestRailManager.testCaseFailStatus);
        }
    }
}