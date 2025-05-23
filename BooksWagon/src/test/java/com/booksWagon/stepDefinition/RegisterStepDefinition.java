//package com.booksWagon.stepDefinition;
//
//import com.booksWagon.pages.Register;
//import com.booksWagon.utils.DriverManager;
//import com.booksWagon.utils.ExcelUtils;
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
//import java.io.IOException;
//import java.util.Map;
//
//public class RegisterStepDefinition {
//    WebDriver driver = DriverManager.getDriver();
//    Register registration = new Register();
//    Map<String, String> testData;
//
//    public RegisterStepDefinition() throws IOException {
//        testData = ExcelUtils.getTestData("src/test/resources/testingData/TestData.xlsx", "SignupData");
//    }
//
//    @Given("User is on the BooksWagon registration page")
//    public void user_is_on_registration_page() {
//        driver.get("https://www.bookswagon.com/register");
//        Assert.assertTrue(driver.getCurrentUrl().contains("register"), "Registration page not loaded correctly!");
//    }
//
//    @When("User enters valid name, email, mobile number, and password")
//    public void user_enters_valid_registration_data() {
//        registration.enterName(testData.get("valid_name"));
//        registration.enterEmail(testData.get("valid_email"));
//        registration.enterMobile(testData.get("valid_mobile"));
//        registration.enterPassword(testData.get("valid_password"));
//        
//        Assert.assertFalse(testData.get("valid_name").isEmpty(), "Name field is empty!");
//        Assert.assertFalse(testData.get("valid_email").isEmpty(), "Email field is empty!");
//        Assert.assertFalse(testData.get("valid_mobile").isEmpty(), "Mobile field is empty!");
//        Assert.assertFalse(testData.get("valid_password").isEmpty(), "Password field is empty!");
//    }
//
//    @When("User selects the captcha")
//    public void user_selects_captcha() {
//        registration.selectCaptcha();
//        Assert.assertTrue(registration.isCaptchaSelected(), "Captcha was not selected!");
//    }
//
//    @When("User enters correct OTP")
//    public void user_enters_correct_otp() {
//        registration.enterOTP(testData.get("valid_otp"));
//        Assert.assertFalse(testData.get("valid_otp").isEmpty(), "OTP field is empty!");
//    }
//
//    @When("User clicks on Signup button")
//    public void user_clicks_signup_button() {
//        registration.clickSignupButton();
//        Assert.assertTrue(registration.isSignupButtonClicked(), "Signup button was not clicked!");
//    }
//
//    @Then("User should be registered successfully")
//    public void user_should_be_registered_successfully() {
//        Assert.assertTrue(driver.getCurrentUrl().contains("myaccount.aspx") || driver.getTitle().contains("My Account"), "Registration failed!");
//    }
//
//    @When("User enters an invalid name")
//    public void user_enters_invalid_name() {
//        registration.enterName(testData.get("invalid_name"));
//        Assert.assertTrue(testData.get("invalid_name").matches(".*[^a-zA-Z ].*"), "Invalid name format check failed!");
//    }
//
//    @When("User enters an invalid mobile number")
//    public void user_enters_invalid_mobile() {
//        registration.enterMobile(testData.get("invalid_mobile"));
//        Assert.assertTrue(testData.get("invalid_mobile").length() != 10, "Mobile number validation failed!");
//    }
//
//    @When("User enters invalid OTP")
//    public void user_enters_invalid_otp() {
//        registration.enterOTP(testData.get("invalid_otp"));
//        Assert.assertTrue(testData.get("invalid_otp").length() < 4, "OTP validation failed!");
//    }
//
//    @When("User enters an invalid password")
//    public void user_enters_invalid_password() {
//        registration.enterPassword(testData.get("invalid_password"));
//        Assert.assertTrue(testData.get("invalid_password").length() < 6, "Password length validation failed!");
//    }
//
//    @When("User enters password {string}")
//    public void user_enters_password(String passwordKey) {
//        registration.enterPassword(testData.get(passwordKey));
//        Assert.assertFalse(testData.get(passwordKey).isEmpty(), "Password field is empty!");
//    }
//
//    @When("User enters confirm password {string}")
//    public void user_enters_confirm_password(String confirmPasswordKey) {
//        registration.enterConfirmPassword(testData.get(confirmPasswordKey));
//        Assert.assertEquals(testData.get(confirmPasswordKey), testData.get("valid_password"), "Confirm password does not match!");
//    }
//
//    @When("User leaves all required fields empty")
//    public void user_leaves_required_fields_empty() {
//        registration.enterName("");
//        registration.enterEmail("");
//        registration.enterMobile("");
//        registration.enterPassword("");
//
//        Assert.assertTrue(registration.areFieldsEmpty(), "Fields should be empty but they are not!");
//    }
//
//    @When("User enters a mobile number with more than 10 digits")
//    public void user_enters_mobile_exceeding_10_digits() {
//        registration.enterMobile(testData.get("invalid_mobile_length"));
//        Assert.assertTrue(testData.get("invalid_mobile_length").length() > 10, "Mobile number validation failed!");
//    }
//
//    @Then("User should see an error message {string}")
//    public void user_should_see_error_message(String errorKey) {
//        Assert.assertEquals(registration.getErrorMessage(), testData.get(errorKey), "Error message validation failed!");
//    }
//}




//package com.booksWagon.stepDefinition;
//
//import com.booksWagon.pages.Register;
//import com.booksWagon.utils.DriverManager;
//import com.booksWagon.utils.ExcelUtils;
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
//import java.io.IOException;
//import java.util.Map;
//
//public class RegisterStepDefinition {
//    WebDriver driver = DriverManager.getDriver();
//    Register registration = new Register();
//    Map<String, String> testData;
//
//    public RegisterStepDefinition() throws IOException {
//        testData = ExcelUtils.getTestData("src/test/resources/testingData/TestData.xlsx", "SignupData");
//    }
//
//    @Given("User is on the BooksWagon registration page")
//    public void user_is_on_registration_page() {
//        driver.get("https://www.bookswagon.com/login?q=signup");
//        Assert.assertTrue(driver.getCurrentUrl().contains("signup"), "Registration page not loaded correctly!");
//    }
//
//    @When("User enters valid name, email, mobile number, and signup password")
//    public void user_enters_valid_registration_data() {
//        registration.enterName(testData.get("valid_name"));
//        registration.enterEmail(testData.get("valid_email"));
//        registration.enterMobile(testData.get("valid_mobile"));
//        registration.enterSignupPassword(testData.get("valid_password"));
//
//        Assert.assertFalse(testData.get("valid_name").isEmpty(), "Name field is empty!");
//        Assert.assertFalse(testData.get("valid_email").isEmpty(), "Email field is empty!");
//        Assert.assertFalse(testData.get("valid_mobile").isEmpty(), "Mobile field is empty!");
//        Assert.assertFalse(testData.get("valid_password").isEmpty(), "Password field is empty!");
//    }
//
//    @When("User selects the captcha")
//    public void user_selects_captcha() {
//        registration.selectCaptcha();
//        Assert.assertTrue(registration.isCaptchaSelected(), "Captcha was not selected!");
//    }
//
//    @When("User enters correct OTP")
//    public void user_enters_correct_otp() {
//        registration.enterOTP(testData.get("valid_otp"));
//        Assert.assertFalse(testData.get("valid_otp").isEmpty(), "OTP field is empty!");
//    }
//
//    @When("User clicks on Signup button")
//    public void user_clicks_signup_button() {
//        registration.clickSignupButton();
//        Assert.assertTrue(registration.isSignupButtonClicked(), "Signup button was not clicked!");
//    }
//
//    @Then("User should be registered successfully")
//    public void user_should_be_registered_successfully() {
//        Assert.assertTrue(driver.getCurrentUrl().contains("myaccount.aspx") || driver.getTitle().contains("My Account"), "Registration failed!");
//    }
//
//    @When("User enters an invalid name")
//    public void user_enters_invalid_name() {
//        registration.enterName(testData.get("invalid_name"));
//        Assert.assertTrue(testData.get("invalid_name").matches(".*[^a-zA-Z ].*"), "Invalid name format check failed!");
//    }
//
//    @When("User enters an invalid mobile number")
//    public void user_enters_invalid_mobile() {
//        registration.enterMobile(testData.get("invalid_mobile"));
//        Assert.assertTrue(testData.get("invalid_mobile").length() != 10, "Mobile number validation failed!");
//    }
//
//    @When("User enters an invalid signup password")
//    public void user_enters_invalid_signup_password() {
//        registration.enterSignupPassword(testData.get("invalid_password"));
//        Assert.assertTrue(testData.get("invalid_password").length() < 6, "Password length validation failed!");
//    }
//
//    @When("User enters signup password {string}")
//    public void user_enters_signup_password(String passwordKey) {
//        registration.enterSignupPassword(testData.get(passwordKey));
//        Assert.assertFalse(testData.get(passwordKey).isEmpty(), "Password field is empty!");
//    }
//
//    @When("User enters confirm password {string}")
//    public void user_enters_confirm_password(String confirmPasswordKey) {
//        registration.enterConfirmPassword(testData.get(confirmPasswordKey));
//        Assert.assertEquals(testData.get(confirmPasswordKey), testData.get("valid_password"), "Confirm password does not match!");
//    }
//
//    @When("User leaves all required fields empty")
//    public void user_leaves_required_fields_empty() {
//        registration.enterName("");
//        registration.enterEmail("");
//        registration.enterMobile("");
//        registration.enterSignupPassword("");
//
//        Assert.assertTrue(registration.areFieldsEmpty(), "Fields should be empty but they are not!");
//    }
//
//    @When("User enters a mobile number with more than 10 digits")
//    public void user_enters_mobile_exceeding_10_digits() {
//        registration.enterMobile(testData.get("invalid_mobile_length"));
//        Assert.assertTrue(testData.get("invalid_mobile_length").length() > 10, "Mobile number validation failed!");
//    }
//
//    @Then("User should see an error message {string}")
//    public void user_should_see_error_message(String errorKey) {
//        Assert.assertEquals(registration.getErrorMessage(), testData.get(errorKey), "Error message validation failed!");
//    }
//}
//






package com.booksWagon.stepDefinition;

import com.booksWagon.pages.Register;
import com.booksWagon.utils.DriverManager;
import com.booksWagon.utils.ExcelUtils;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class RegisterStepDefinition {
    WebDriver driver = DriverManager.getDriver();
    Register registration = new Register();
    Map<String, String> testData;

    public RegisterStepDefinition() throws IOException {
        testData = ExcelUtils.getTestData("src/test/resources/testingData/TestData.xlsx", "SignupData");
    }

    @Given("User is on the BooksWagon registration page")
    public void user_is_on_registration_page() {
        driver.get("https://www.bookswagon.com/login?q=signup");
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"), "Registration page not loaded correctly!");
    }

    @When("User enters valid name {string}, mobile number {string}, and signup password {string}")
    public void user_enters_valid_registration_data(String nameKey, String mobileKey, String passwordKey) {
        registration.enterName(testData.get(nameKey));
        
        registration.enterMobile(testData.get(mobileKey));
        registration.enterSignupPassword(testData.get(passwordKey));

        Assert.assertFalse(testData.get(nameKey).isEmpty(), "Name field is empty!");
        
        Assert.assertFalse(testData.get(mobileKey).isEmpty(), "Mobile field is empty!");
        Assert.assertFalse(testData.get(passwordKey).isEmpty(), "Password field is empty!");
    }

    @When("User selects the captcha manually")
    public void user_selects_captcha_manually() {
        System.out.println("Please select the captcha manually...");
        try {
            Thread.sleep(5000); // Gives time for manual captcha selection
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        registration.clickContinue();
    }

    @When("User enters OTP {string}")
    public void user_enters_otp(String otpKey) {
        registration.enterOTP(testData.get(otpKey));
        Assert.assertFalse(testData.get(otpKey).isEmpty(), "OTP field is empty!");
    }

    @When("User enters signup password {string}")
    public void user_enters_signup_password(String passwordKey) {
        registration.enterSignupPassword(testData.get(passwordKey));
        Assert.assertFalse(testData.get(passwordKey).isEmpty(), "Password field is empty!");
    }

    @When("User enters confirm password {string}")
    public void user_enters_confirm_password(String confirmPasswordKey) {
        registration.enterConfirmPassword(testData.get(confirmPasswordKey));
        Assert.assertEquals(testData.get(confirmPasswordKey), testData.get("valid_password"), "Confirm password does not match!");
    }

    @When("User clicks on Signup button")
    public void user_clicks_signup_button() {
        registration.clickSignupButton();
        Assert.assertTrue(registration.isSignupButtonClicked(), "Signup button was not clicked!");
    }

    @Then("User should be registered successfully")
    public void user_should_be_registered_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("myaccount.aspx") || driver.getTitle().contains("My Account"), "Registration failed!");
    }

    @When("User enters an invalid name {string}, mobile number {string}, and signup password {string}")
    public void user_enters_invalid_name(String nameKey,  String mobileKey, String passwordKey) {
        registration.enterName(testData.get(nameKey));
        
        registration.enterMobile(testData.get(mobileKey));
        registration.enterSignupPassword(testData.get(passwordKey));
    }

    @When("User enters valid name {string}, invalid mobile number {string}, and signup password {string}")
    public void user_enters_invalid_mobile(String nameKey, String mobileKey, String passwordKey) {
        registration.enterName(testData.get(nameKey));
        
        registration.enterMobile(testData.get(mobileKey));
        registration.enterSignupPassword(testData.get(passwordKey));
    }

    @When("User skips captcha selection")
    public void user_skips_captcha_selection() {
        System.out.println("Skipping captcha selection.");
    }

    @Then("User should see an error message {string}")
    public void user_should_see_error_message(String errorKey) {
        Assert.assertEquals(registration.getErrorMessage(), testData.get(errorKey), "Error message validation failed!");
    }
}

