package com.booksWagon.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.booksWagon.stepDefinition", "com.booksWagon.hooks"},
        tags="@Test",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}


