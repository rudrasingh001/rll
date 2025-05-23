//
//
//package com.booksWagon.hooks;
//
//import com.booksWagon.utils.DriverManager;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//public class HookClass {
//
//    @Before
//    public void setup() {
//        DriverManager.getDriver();
//    }
//
//    @After
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
//        }
//        DriverManager.quitDriver();
//    }
//}
//
//
//


package com.booksWagon.hooks;

import com.booksWagon.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HookClass {
    private WebDriver driver;

    @Before(order = 1)
    public void setup() {
        driver = DriverManager.getDriver();
//        driver.manage().window().maximize(); // Ensuring window maximized before tests
    }

    @Before(order = 2, value = "@Signup") // Ensures Signup scenarios start from correct page
    public void navigateToSignupPage() {
        driver.get("https://www.bookswagon.com/register");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Scenario: " + scenario.getName());
        }
        DriverManager.quitDriver();
    }
}
