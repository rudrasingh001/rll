////package com.booksWagon.pages;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.WebDriver;
////
////public class Login {
////    WebDriver driver;
////
////    public Login(WebDriver driver) {
////        this.driver = driver;
////    }
////
////    // Locators
////    By loginIcon = By.id("ctl00_lblUser"); // Assumed ID for login button/icon
////    By emailInput = By.id("ctl00_phBody_SignIn_txtEmail");
////    By passwordInput = By.id("ctl00_phBody_SignIn_txtPassword");
////    By loginBtn = By.id("ctl00_phBody_SignIn_btnLogin");
////
////    By otpInput = By.id("otpBox"); // Hypothetical ID
////    By otpSubmitBtn = By.id("submitOtp"); // Hypothetical ID
////
////    By errorMsg = By.className("error-message"); // Placeholder class
////
////    // Methods
////    public void clickLoginIcon() {
////        driver.findElement(loginIcon).click();
////    }
////
////    public void enterEmail(String email) {
////        driver.findElement(emailInput).sendKeys(email);
////    }
////
////    public void enterPassword(String password) {
////        driver.findElement(passwordInput).sendKeys(password);
////    }
////
////    public void clickLoginButton() {
////        driver.findElement(loginBtn).click();
////    }
////
////    public void enterOTP(String otp) {
////        driver.findElement(otpInput).sendKeys(otp);
////    }
////
////    public void submitOTP() {
////        driver.findElement(otpSubmitBtn).click();
////    }
////
////    public String getErrorMessage() {
////        return driver.findElement(errorMsg).getText();
////    }
////}
//
//
//package com.booksWagon.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//public class Login {
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public Login(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    private By loginLink = By.linkText("Login");
//    private By emailMobileInput = By.id("loginEmail");
//    private By passwordInput = By.id("loginPassword");
//    private By loginButton = By.id("btnLogin");
//    private By errorMsg = By.id("loginError");
//
//    public void clickLoginLink() {
//        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
//    }
//
//    public void enterEmailOrMobile(String emailOrMobile) {
//        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailMobileInput));
//        emailField.clear();
//        emailField.sendKeys(emailOrMobile);
//    }
//
//    public void enterPassword(String password) {
//        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
//        passwordField.clear();
//        passwordField.sendKeys(password);
//    }
//
//    public void clickLoginButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
//    }
//
//    public String getErrorMessage() {
//        try {
//            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
//        } catch (Exception e) {
//            return "Error message not found";
//        }
//    }
//}

package com.booksWagon.pages;

import com.booksWagon.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;

    // Ensuring WebDriver is correctly retrieved from DriverManager
    public Login() {
        this.driver = DriverManager.getDriver();
    }

    private By loginLink = By.id("ctl00_lblUser");
    private By emailInput = By.id("ctl00_phBody_SignIn_txtEmail");
    private By passwordInput = By.id("ctl00_phBody_SignIn_txtPassword");
    private By loginButton = By.id("ctl00_phBody_SignIn_btnLogin");
    private By otpInput = By.id("otpBox");
    private By otpSubmitButton = By.id("submitOtp");
    private By errorMsg = By.id("ctl00_phBody_SignIn_lblemailmsg");

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void enterOTP(String otp) {
        driver.findElement(otpInput).sendKeys(otp); // Removed WebDriverWait usage
    }

    public void submitOTP() {
        driver.findElement(otpSubmitButton).click(); // Removed WebDriverWait usage
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText(); // Removed WebDriverWait usage
    }
}
