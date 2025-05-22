package com.booksWagon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By loginIcon = By.id("ctl00_lblUser"); // Assumed ID for login button/icon
    By emailInput = By.id("ctl00_phBody_SignIn_txtEmail");
    By passwordInput = By.id("ctl00_phBody_SignIn_txtPassword");
    By loginBtn = By.id("ctl00_phBody_SignIn_btnLogin");

    By otpInput = By.id("otpBox"); // Hypothetical ID
    By otpSubmitBtn = By.id("submitOtp"); // Hypothetical ID

    By errorMsg = By.className("error-message"); // Placeholder class

    // Methods
    public void clickLoginIcon() {
        driver.findElement(loginIcon).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginBtn).click();
    }

    public void enterOTP(String otp) {
        driver.findElement(otpInput).sendKeys(otp);
    }

    public void submitOTP() {
        driver.findElement(otpSubmitBtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}
