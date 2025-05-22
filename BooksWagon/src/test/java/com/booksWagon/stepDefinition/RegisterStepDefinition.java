package com.booksWagon.stepDefinition;


import com.booksWagon.pages.Register;
import com.booksWagon.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterStepDefinition {
    WebDriver driver = DriverManager.getDriver();
    Register register = new Register(driver);

    @Given("User is on the BooksWagon registration page")
    public void user_is_on_the_bookswagon_registration_page() {
        driver.get("https://www.bookswagon.com/");
        register.clickSignupLink();
    }

    @When("User enters name {string}, mobile {string}, password {string}, confirm password {string}, captcha {string}")
    public void user_enters_registration_details(String name, String mobile, String password, String confirmPassword, String captcha) {
        register.enterName(name);
        register.enterMobile(mobile);
        register.enterPassword(password);
        register.enterConfirmPassword(confirmPassword);
        register.enterCaptcha(captcha);
    }

    @And("Clicks the register button")
    public void clicks_the_register_button() {
        register.clickRegister();
    }

    @Then("User should be registered successfully")
    public void user_should_be_registered_successfully() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("MyAccount"), "Registration failed!");
    }

    @Then("Registration error message should be displayed")
    public void registration_error_message_should_be_displayed() {
        Assert.assertTrue(register.getErrorMessage().length() > 0, "Error message not displayed");
    }
}
