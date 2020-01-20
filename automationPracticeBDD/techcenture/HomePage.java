package us.techcenture;

import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

final class HomePage extends CommonPage {

	private static HomePage homePage;

	static HomePage getHomePage(WebDriver webDriver) {
		if (homePage == null)
			homePage = new HomePage(webDriver);
		return homePage;
	}

	private DriverHelper driverHelper = getDriverHelper();
	
	private HomePage(WebDriver driver) { super(driver); }
	
	void clickCreateStudentButton () {
		driverHelper.clickButton("CREATE STUDENT");
	}
}
