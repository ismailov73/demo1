package com.automationpractice.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.automationpractice.utilities.CommonStep;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions (
			plugin = {
				"html:target/cucumber_report",
				"json:target/cucumber_report/cucumber.json",
				"rerun:target/rerun.txt" //1 //
			},
			features = {"src/test/resources/features"},
			glue = {"com.automationpractice.steps", "com.mockaroo.excel_generator"},
			tags = {
					"@excel1"//, "~@contactUs" //tilde to skip scenarios/features 
					},
			monochrome = true //this is only to print in console for pretty view. not important 
//			, dryRun = true
			/*
			 * dryRun = true --> get step implementations 
			 * for unimplemented steps in feature file
			 */
		)
public class Runner extends CommonStep {
	@AfterClass
	public static void after () {
		closeDriver();
	}
}
