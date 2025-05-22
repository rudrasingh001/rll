package com.booksWagon.hooks;


import com.booksWagon.utils.DriverManager;
import com.booksWagon.utils.ExtentManager;
import com.booksWagon.utils.Log;
import com.booksWagon.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class HookClass {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public static void beforeAll() {
        Log.startLog();
        extent = ExtentManager.getInstance();
        Log.info("Extent Report Initialized");
    }

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverManager.getDriver();
        Log.info("Driver Initialized");
        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, scenario.getName().replaceAll(" ", "_"));
            test.fail("Scenario failed. Screenshot attached.")
                .addScreenCaptureFromPath(screenshotPath);
            Log.error("Scenario failed: " + scenario.getName());
        } else {
            test.pass("Scenario passed.");
            Log.info("Scenario passed: " + scenario.getName());
        }
        driver.quit();
        Log.info("Driver quit");
    }

    @AfterSuite
    public static void afterAll() {
        extent.flush();
        Log.info("Extent Report flushed");
    }
}
