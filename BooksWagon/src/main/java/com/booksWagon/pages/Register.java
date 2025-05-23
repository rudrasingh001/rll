//package com.booksWagon.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import com.booksWagon.utils.DriverManager;
//
//public class Register {
//    WebDriver driver = DriverManager.getDriver();
//
//    // Locators for signup elements
//    private By nameInput = By.id("ctl00_phBody_SignUp_txtName");
//    private By emailInput = By.id("ctl00_phBody_SignUp_txtEmail");
//    private By mobileInput = By.id("ctl00_phBody_SignUp_txtMobile");
//    private By passwordInput = By.id("ctl00_phBody_SignUp_txtPassword");
//    private By confirmPasswordInput = By.id("ctl00_phBody_SignUp_txtConfirmPwd");
//    private By captchaBox = By.id("ctl00_phBody_SignUp_txtCaptcha");  // Updated
//    private By registerBtn = By.id("ctl00_phBody_SignUp_btnSubmit");
//    private By otpField = By.id("ctl00_phBody_SignUp_txtOtp");
//    private By errorMessage = By.id("errorMsg");
//
//    // Methods to interact with the signup form
//    public void enterName(String name) {
//        driver.findElement(nameInput).sendKeys(name);
//    }
//
//    public void enterEmail(String email) {
//        driver.findElement(emailInput).sendKeys(email);
//    }
//
//    public void enterMobile(String mobile) {
//        driver.findElement(mobileInput).sendKeys(mobile);
//    }
//
//    public void enterSignupPassword(String password) {
//        driver.findElement(passwordInput).sendKeys(password);
//    }
//
//    public void enterConfirmPassword(String confirmPassword) {
//        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
//    }
//
//    // ADDED selectCaptcha()
//    public void selectCaptcha() {
//        driver.findElement(captchaBox).click();
//    }
//
//    public boolean isCaptchaSelected() {
//        return !driver.findElement(captchaBox).getAttribute("value").isEmpty();
//    }
//
//    public void enterOTP(String otp) {
//        driver.findElement(otpField).sendKeys(otp);
//    }
//
//    public void clickSignupButton() {
//        driver.findElement(registerBtn).click();
//    }
//
//    public boolean isSignupButtonClicked() {
//        return driver.findElement(registerBtn).isDisplayed();
//    }
//
//    public String getErrorMessage() {
//        return driver.findElement(errorMessage).getText();
//    }
//
//    public boolean areFieldsEmpty() {
//        return driver.findElement(nameInput).getAttribute("value").isEmpty() &&
//               driver.findElement(emailInput).getAttribute("value").isEmpty() &&
//               driver.findElement(mobileInput).getAttribute("value").isEmpty() &&
//               driver.findElement(passwordInput).getAttribute("value").isEmpty();
//    }
//}





package com.booksWagon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.booksWagon.utils.DriverManager;
import java.time.Duration;

public class Register {
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Explicit wait for element handling

    // Locators for signup elements
    private By nameInput = By.id("ctl00_phBody_SignUp_txtName");
    private By mobileInput = By.id("ctl00_phBody_SignUp_txtEmail");
    private By passwordInput = By.id("ctl00_phBody_SignUp_txtPassword");
    private By confirmPasswordInput = By.id("ctl00_phBody_SignUp_txtConfirmPwd");
    private By captchaBox = By.id("ctl00_phBody_SignUp_txtCaptcha");
    private By continueBtn = By.id("ctl00_phBody_SignUp_btnContinue");  // Added Continue button
    private By registerBtn = By.id("ctl00_phBody_SignUp_btnSubmit");
    private By otpField = By.id("ctl00_phBody_SignUp_txtOtp");
    private By errorMessage = By.id("errorMsg");

    // Methods to interact with the signup form with Explicit Waits
    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterMobile(String mobile) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileInput));
        driver.findElement(mobileInput).sendKeys(mobile);
    }

    public void enterSignupPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInput));
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
    }

    public void selectCaptcha() {
        System.out.println("Please select the captcha manually...");
        try {
            Thread.sleep(30000); // Manual wait for captcha selection
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isCaptchaSelected() {
        return !driver.findElement(captchaBox).getAttribute("value").isEmpty();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        driver.findElement(continueBtn).click();
    }

    public void enterOTP(String otp) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(otpField));
        driver.findElement(otpField).sendKeys(otp);
    }

    public void clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
        driver.findElement(registerBtn).click();
    }

    public boolean isSignupButtonClicked() {
        return driver.findElement(registerBtn).isDisplayed();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    public boolean areFieldsEmpty() {
        return driver.findElement(nameInput).getAttribute("value").isEmpty() &&
               driver.findElement(mobileInput).getAttribute("value").isEmpty() &&
               driver.findElement(passwordInput).getAttribute("value").isEmpty();
    }
}
