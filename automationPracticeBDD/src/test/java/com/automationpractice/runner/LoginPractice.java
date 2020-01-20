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
				"rerun:target/rerun.txt"
			},
		
		features = {"src/test/resources/features/warm_up/loginPractice.feature "
			
		},
		
		glue = {"com.automationpractice.steps"
			
		},
		
		tags = { "@smokeTest"
			
		},
		
		monochrome = true,
		
		 dryRun = false
		
		
		
		)


public class LoginPractice extends CommonStep {
	@AfterClass
	public static void after () {
		closeDriver();
	}

}
