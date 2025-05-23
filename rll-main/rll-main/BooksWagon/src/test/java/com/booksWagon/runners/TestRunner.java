//package com.booksWagon.runners;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//        features = "src/test/resources/features",
//        glue = {"com.booksWagon.stepDefinition", "com.booksWagon.hooks"},
//        plugin = {"pretty", "html:target/cucumber-reports.html",
//                  "json:target/cucumber.json",
//                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"},
//        monochrome = true,
//        strict = true
//)
//public class TestRunner extends AbstractTestNGCucumberTests {
//    // This will run all feature files with step definitions and hooks
//}



package com.booksWagon.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.booksWagon.stepDefinition", "com.booksWagon.hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
