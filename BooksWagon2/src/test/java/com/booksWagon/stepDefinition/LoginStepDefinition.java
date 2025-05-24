//package com.booksWagon.stepDefinition;
//
//import com.booksWagon.pages.Login;
//import com.booksWagon.utils.DriverManager;
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
//public class LoginStepDefinition {
//    WebDriver driver = DriverManager.getDriver();
//    Login loginPage = new Login(driver);
//
//    @Given("User is on the BooksWagon homepage")
//    public void userIsOnHomepage() {
//        driver.get("https://www.bookswagon.com/");
//    }
//
//    @When("User clicks on Login")
//    public void userClicksLogin() {
//        loginPage.clickLoginLink();
//    }
//
//    @When("User enters email or mobile as {string}")
//    public void userEntersMobileOrEmail(String mobile) {
//        loginPage.enterMobileOrEmail(mobile);
//    }
//
//    @When("User enters password as {string}")
//    public void userEntersPassword(String password) {
//        loginPage.enterPassword(password);
//    }
//
//    @When("User attempts login or requests OTP")
//    public void userAttemptsLoginOrOTP() {
//        loginPage.decideLoginMethod();
//    }
//
//    @When("User enters OTP manually if required {string}")
//    public void userEntersOTPManually(String otp) {
//        if (!otp.isEmpty()) {
//            loginPage.waitForManualOTPEntry(50);
//            loginPage.enterOTP(otp);
//            loginPage.clickLoginAfterOTP();
//        }
//    }
//
//    @Then("Login should be {string}")
//    public void verifyLogin(String expectedResult) {
//        boolean loginSuccess = loginPage.isLoginSuccessful();
//        Assert.assertEquals(expectedResult.equalsIgnoreCase("success"), loginSuccess, "Login result did not match expectation.");
//    }
//}
//
//
//


package com.booksWagon.stepDefinition;

import com.booksWagon.pages.Login;
import com.booksWagon.utils.DriverManager;
import com.booksWagon.utils.ExcelUtils;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginStepDefinition {
    WebDriver driver = DriverManager.getDriver();
    Login loginPage = new Login(driver);

    String excelPath = "src/test/resources/testingData/TestData.xlsx";
    String sheetName = "LoginData";

    @Given("User is on the BooksWagon homepage")
    public void userIsOnHomepage() {
        driver.get("https://www.bookswagon.com/");
    }

    @When("User clicks on Login")
    public void userClicksLogin() {
        loginPage.clickLoginLink();
    }

    @When("User attempts login or requests OTP using Excel data")
    public void userAttemptsLoginOrOTP() throws Exception {
        int rowCount = ExcelUtils.getRowCount(excelPath, sheetName);

        for (int i = 1; i < rowCount; i++) {
            try {
                String mobile = ExcelUtils.getCellData(excelPath, sheetName, i, 0);
                String password = ExcelUtils.getCellData(excelPath, sheetName, i, 1);
                String otp = ExcelUtils.getCellData(excelPath, sheetName, i, 2);
                String expectedResult = ExcelUtils.getCellData(excelPath, sheetName, i, 3);

                loginPage.enterMobileOrEmail(mobile);
                loginPage.enterPassword(password);
                loginPage.decideLoginMethod();

                if (!otp.isEmpty()) {
                    loginPage.waitForManualOTPEntry(50);
                    loginPage.enterOTP(otp);
                    loginPage.clickLoginAfterOTP();
                }

                boolean loginSuccess = loginPage.isLoginSuccessful();
                Assert.assertEquals(expectedResult.equalsIgnoreCase("success"), loginSuccess, "Login result did not match expectation.");

                ExcelUtils.setCellData(excelPath, sheetName, i, 4, "Passed");
            } catch (Exception e) {
                ExcelUtils.setCellData(excelPath, sheetName, i, 4, "Failed");
            }
        }
    }
}
