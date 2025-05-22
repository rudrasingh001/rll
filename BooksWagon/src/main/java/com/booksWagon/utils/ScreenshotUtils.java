//package com.booksWagon.utils;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import java.io.File;
//import java.io.IOException;
//
//public class ScreenshotUtils {
//    public static String captureScreenshot(WebDriver driver, String screenshotName) {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String dest = System.getProperty("user.dir") + "/outputScreenShots/" + screenshotName + ".png";
//        try {
//            FileUtils.copyFile(source, new File(dest));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return dest;
//    }
//}
