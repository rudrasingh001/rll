package com.booksWagon.stepDefinition;

import com.booksWagon.pages.Login;
import com.booksWagon.utils.DriverManager;
import com.booksWagon.utils.ExcelUtils;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class LoginStepDefinition {
    WebDriver driver = DriverManager.getDriver();
    Login login = new Login();
    Map<String, String> testData;
    
    

    public LoginStepDefinition() throws IOException {
        testData = ExcelUtils.getTestData("src/test/resources/testingData/TestData.xlsx", "LoginData");

        // Debugging: Print retrieved testData keys and values
        System.out.println("Loaded Test Data:");
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    @Given("User is on the BooksWagon homepage")
    public void user_is_on_homepage() {
        System.out.println("Navigating to BooksWagon homepage...");
        driver.get("https://www.bookswagon.com/");
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @When("User clicks on Login")
    public void user_clicks_login() {
        System.out.println("Clicking Login button...");
        login.clickLoginLink();
    }

    @When("User enters email {string}")
    public void user_enters_email(String emailKey) {
        String email = testData.get(emailKey);
        System.out.println("Retrieved Email: " + emailKey + " -> " + email);

        // Prevent NullPointerException by ensuring email is not null
        if (email == null || email.isEmpty()) {
            email = "";
            System.out.println("WARNING: Email value is null or empty!");
        }

        login.enterEmail(email);
    }

    @When("User enters password {string}")
    public void user_enters_password(String passwordKey) {
        String password = testData.get(passwordKey);
        System.out.println("Retrieved Password: " + passwordKey + " -> " + password);

        if (password == null || password.isEmpty()) {
            password = "";
            System.out.println("WARNING: Password value is null or empty!");
        }

        login.enterPassword(password);
    }

    @When("User clicks on Login button")
    public void user_clicks_login_button() {
        System.out.println("Clicking Login button...");
        login.clickLoginButton();
    }
    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        System.out.println("Checking login success...");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Current Page Title: " + driver.getTitle());

        // Updated assertion with correct URL check
        Assert.assertTrue(driver.getCurrentUrl().contains("myaccount.aspx") || driver.getTitle().contains("My Account"));
    }

    

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String errorKey) {
        String expectedError = testData.get(errorKey);
        String actualError = login.getErrorMessage();

        System.out.println("Expected Error Message: " + expectedError);
        System.out.println("Actual Error Message: " + actualError);

        Assert.assertEquals(actualError, expectedError);
    }
}
