package com.automationpractice.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.automationpractice.utilities.CommonStep;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumber_report",
				"json:target/cucumber_report/cucumber.json",
				"rerun:target/rerun.txt"},
		
				glue = {
						"com.automationpractice.steps"
						},
				
		
		features = {"src/test/resources/features/warm_up/application.feature"},
		
		
		
		tags = {"@test"
				
		},
		monochrome = true,
		
		 dryRun = false
		
		
		)

public class ApplicationRunner extends CommonStep {
	@AfterClass
	public static void after () {
		closeDriver();
	}

	
}
