//package com.booksWagon.runners;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//    features = "src/test/resources/features",
//    glue = {"com.booksWagon.stepDefinition", "com.booksWagon.hooks"},
//    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
//    monochrome = true
//)
//public class TestRunner extends AbstractTestNGCucumberTests {
//}



package com.booksWagon.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.booksWagon.stepDefinition", "com.booksWagon.hooks"},
    tags = "@Signup",  // Ensuring Login & Signup scenarios execute
    plugin = {
        "pretty", 
        "html:target/cucumber-reports.html", 
        "json:target/cucumber.json", 
        "junit:target/cucumber.xml",  // Added JUnit report for CI/CD integrations
        "rerun:target/rerun.txt"  // Helps rerun failed tests in CI pipelines
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
