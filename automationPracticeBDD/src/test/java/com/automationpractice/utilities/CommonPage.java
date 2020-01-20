package com.automationpractice.utilities;

import org.openqa.selenium.WebDriver;

/**
 * Parent of all page object classes
 * 
 * @author TechCenture
 *
 */
public class CommonPage extends DriverHelper{
//public class CommonPage {

	protected DriverHelper driverHelper;

	protected CommonPage(WebDriver driver) {
		super(driver);
		if (driverHelper == null)
			driverHelper = new DriverHelper(driver);
	}

	protected DriverHelper getDriverHelper() {
		return driverHelper;
	}
}
