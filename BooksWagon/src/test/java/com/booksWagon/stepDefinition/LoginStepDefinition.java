package com.booksWagon.stepDefinition;



import com.booksWagon.pages.Login;
import com.booksWagon.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginStepDefinition {
    WebDriver driver = DriverManager.getDriver();
    Login login = new Login(driver);

    @Given("User is on the BooksWagon login page")
    public void user_is_on_the_bookswagon_login_page() {
        driver.get("https://www.bookswagon.com/");
        login.clickLoginIcon()	;
    }

    @When("User enters valid email {string} and password {string}")
    public void user_enters_valid_email_and_password(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
    }

    @And("Clicks the login button")
    public void clicks_the_login_button() {
        login.clickLoginButton();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("MyAccount"), "Login failed!");
    }

    @When("User enters invalid email {string} or password {string}")
    public void user_enters_invalid_email_or_password(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
    }

    @Then("Login error message should be displayed")
    public void login_error_message_should_be_displayed() {
        Assert.assertTrue(login.getErrorMessage().contains("invalid"), "Error not shown");
    }
}
