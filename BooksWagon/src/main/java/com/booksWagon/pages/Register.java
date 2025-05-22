package com.booksWagon.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    WebDriver driver;

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By signupLink = By.id("ctl00_lblUser"); // Assume opens signup tab
    By nameInput = By.id("ctl00_phBody_SignUp_txtName");
    By mobileInput = By.id("ctl00_phBody_SignUp_txtMobile");
    By passwordInput = By.id("ctl00_phBody_SignUp_txtPassword");
    By confirmPasswordInput = By.id("ctl00_phBody_SignUp_txtConfirmPwd");
    By captchaBox = By.id("ctl00_phBody_SignUp_txtCaptcha"); // Assume this
    By registerBtn = By.id("ctl00_phBody_SignUp_btnSubmit");

    By otpBox = By.id("otpBox"); // Placeholder
    By otpSubmit = By.id("submitOtp");

    By errorMsg = By.className("error-message");

    // Methods
    public void clickSignupLink() {
        driver.findElement(signupLink).click();
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterMobile(String mobile) {
        driver.findElement(mobileInput).sendKeys(mobile);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
    }

    public void enterCaptcha(String captcha) {
        driver.findElement(captchaBox).sendKeys(captcha);
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }

    public void enterOTP(String otp) {
        driver.findElement(otpBox).sendKeys(otp);
    }

    public void submitOTP() {
        driver.findElement(otpSubmit).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}
