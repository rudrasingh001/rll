package com.booksWagon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Objects;

public class Login {
    WebDriver driver;
    WebDriverWait wait;

    private final By loginLink = By.id("ctl00_lblUser");
    private final By mobileOrEmailInput = By.id("ctl00_phBody_SignIn_txtEmail");
    private final By passwordInput = By.id("ctl00_phBody_SignIn_txtPassword");
    private final By loginButton = By.id("ctl00_phBody_SignIn_btnLogin");
    private final By verifyButton = By.id("ctl00_phBody_SignIn_btnLogin");
    private final By requestOTPButton = By.id("ctl00_phBody_SignIn_btnRequestOTP");
    private final By otpInput = By.id("ctl00_phBody_SignIn_txtOTP");

    public Login(WebDriver driver) {
        this.driver = Objects.requireNonNull(driver, "Driver instance cannot be null");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void enterMobileOrEmail(String input) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileOrEmailInput));
        driver.findElement(mobileOrEmailInput).clear();
        driver.findElement(mobileOrEmailInput).sendKeys(input);
    }


    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

//    public void decideLoginMethod() {
//        String passwordText = driver.findElement(passwordInput).getAttribute("value");
//        if (!passwordText.isEmpty()) {
//            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
//        } else {
//            wait.until(ExpectedConditions.elementToBeClickable(requestOTPButton)).click();
//        }
//    }
    
    public void decideLoginMethod() {
        String passwordText = driver.findElement(passwordInput).getAttribute("value");
        if (!passwordText.isEmpty()) {
            driver.findElement(loginButton).click();  
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(requestOTPButton)).click();
        }
    }


    public void waitForManualOTPEntry(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted while waiting for OTP entry.");
        }
    }

    public void enterOTP(String otp) {
        driver.findElement(otpInput).clear();
        driver.findElement(otpInput).sendKeys(otp);
    }

    public void clickLoginAfterOTP() {
        wait.until(ExpectedConditions.elementToBeClickable(verifyButton)).click();
    }

    public boolean isLoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlContains("myaccount.aspx"));
    }

}
