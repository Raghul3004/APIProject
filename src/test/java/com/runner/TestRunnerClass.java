package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Login or @State or @City or @Address or @Product", features = "src\\test\\resources", glue = "com.step", plugin = {
		"pretty", "json:target\\reportOutput.json" }, dryRun = false)

public class TestRunnerClass extends BaseClass {

	@AfterClass
	public static void report() {

		Reporting.generateReport("C:\\Users\\Admin\\RealTime Projects\\OMRBranchAPIAutomation\\target\\cucumber-html-reports");
	}

}