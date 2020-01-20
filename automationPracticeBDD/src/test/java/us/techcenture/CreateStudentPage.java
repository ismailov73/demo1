package us.techcenture;

import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

final class CreateStudentPage extends CommonPage {

	private int timeOutInSeconds = 15;
	private static CreateStudentPage createStudentPage;

	static CreateStudentPage getCreateStudentPage(WebDriver webDriver) {
		if (createStudentPage == null)
			createStudentPage = new CreateStudentPage(webDriver);
		return createStudentPage;
	}

	enum CreateStudentFields {
		NAME, LAST_NAME, COURSE, STUDENT_AGE
	}

	private DriverHelper driverHelper = getDriverHelper();
	private String fieldInputBox = "//td[contains(text(), \"{0}\")]/following-sibling::td/input";

	private CreateStudentPage(WebDriver driver) {
		super(driver);
	}

	void enterStudentData ( String fieldName, String fieldValue ) {
		String xpath = MessageFormat.format(fieldInputBox, fieldName);
		driverHelper.sendKeys(By.xpath(xpath), fieldValue, timeOutInSeconds);
	}

	void enterStudentData(CreateStudentFields createStudentFields, String fieldValue) {
		By textFiledLocator = null;
		switch (createStudentFields) {
		case NAME:
			textFiledLocator = By.id("first_name");
			break;
		case LAST_NAME:
			textFiledLocator = By.id("last_name");
			break;
		case COURSE:
			textFiledLocator = By.id("course");
			break;
		case STUDENT_AGE:
			textFiledLocator = By.id("age");
			break;
		default:
			break;
		}
		driverHelper.sendKeys(textFiledLocator, fieldValue, timeOutInSeconds);
	}
	
	void clickSaveButton () {
		driverHelper.clickButton("Save");
	}

}
