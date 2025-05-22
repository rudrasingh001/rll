//package com.booksWagon.utils;
//
//
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtentManager {
//    private static ExtentReports extent;
//
//    public static ExtentReports getInstance() {
//        if (extent == null) {
//            String reportPath = System.getProperty("user.dir") + "/extentReports/BookswagonTestReport.html";
//            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
//            extent = new ExtentReports();
//            extent.attachReporter(reporter);
//            reporter.config().setReportName("BooksWagon Automation Test Report");
//            reporter.config().setDocumentTitle("Automation Report");
//        }
//        return extent;
//    }
//}
