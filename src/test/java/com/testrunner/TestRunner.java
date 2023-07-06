 package com.testrunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/FeatureFiles" },

		glue = { "com.stepdefinition" }, 
		plugin = {"summary", "pretty", "html:target/cucumber-reports/cucumber-pretty" ,"json:target/cucumber-reports/CucumberTestReport.json"},
		dryRun = false, monochrome=true, publish = true)
		

public class TestRunner {

}
