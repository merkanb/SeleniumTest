package com.eurotech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // this class is used for building reports
    protected ExtentReports report;

    // this class is used to create HTML report file
    protected ExtentHtmlReporter htmlReporter;

    // this will define a test, enable adding logs, authors and test steps
    protected ExtentTest extentLogger;

    @BeforeTest
    // we add all these codes here  (will be extended from here by the all other Test methods ...) for reporting purposes ...
    public void SetupTest() {    // information that we would like to see in the report we set up here..
        // initialize the ExtentReports object
        report = new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String filePath = "/test-output/report.html";           // we define, should be dynamic with date and time info .. for each test running
        String path = projectPath + filePath;

        // initialize the html report
        htmlReporter = new ExtentHtmlReporter(path);

        // attach the html report to the report object
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Eurotech Smoke Test");

        report.setSystemInfo("Environment", "Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Erkan");
    }


    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }



    @AfterMethod
    // we define these codes in case of Fail,  extentLogger codes are here nothing but just for reporting purpose...
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        // if test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            // record the name of failed test case
            extentLogger.fail(result.getName());       // means log it as FAILED (according to the condition of if it fails)   ?

            // take screenshot and return location of the screenshot
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());  // returns  path as a String

            // add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenshotPath);  // create a screenshot at provided path ?

            // capture the exception and put it inside the report
            extentLogger.fail(result.getThrowable());
        }

        Thread.sleep(2000);
        Driver.closeDriver();

    }


    @AfterTest
    public void tearDownTest() {        // these code here ( will be extended from here by all other Test methods..)
        // here actually we just say generate/create the report
        report.flush();

    }


}
