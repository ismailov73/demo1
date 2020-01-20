package warm_up;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

public class AutomationPracticeCreateAccountPage extends CommonPage {
	
	private int timeOutInSeconds = 10;
	private DriverHelper driverHelper = getDriverHelper();
	private WebDriver driver;
	
	private static AutomationPracticeCreateAccountPage automationPracticeCreateAccountPage;
	
	public static AutomationPracticeCreateAccountPage getAutomationPracticeCreateAccountPage (WebDriver driver) {
		if(automationPracticeCreateAccountPage == null)
			automationPracticeCreateAccountPage = new AutomationPracticeCreateAccountPage(driver);
		return automationPracticeCreateAccountPage;
		
	}

	protected AutomationPracticeCreateAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}
	
	private By loginButton = By.className("login");
	private By emailTextBox = By.id("email_create");
	private By submit = By.id("SubmitCreate");
	private By getErrorText = By.xpath("//li[text()='An account using this email address has already been registered."
			+ " Please enter a valid password or request a new one. ']");
	private By submitButton = By.id("submitAccount");
	private By errorTextOne = By.xpath("//li[text()='You must register at least one phone number.']");
	private By errorTextTwo = By.xpath("//div/ol/li[2]");
	private By errorTextThree = By.xpath("//div/ol/li[3]");
	private By errorTextFour = By.xpath("//div/ol/li[4]");
	private By errorTextFive = By.xpath("//div/ol/li[5]");
	private By errorTextSix = By.xpath("//div/ol/li[6]");
	private By errorTextSeven = By.xpath("//div/ol/li[7]");
	private By errorTextEight = By.xpath("//div/ol/li[8]");
	private By genderButton = By.id("uniform-id_gender1");
	private By firstName = By.id("customer_firstname");
	private By lastName = By.name("customer_lastname");
	private By emailValidate = By.id("email");
	private By password = By.id("passwd");
	
	private By clickDay = By.id("uniform-days");
	
	private By pickDay = By.id("days");
	
	private By fNameValidate = By.id("firstname");
	private By lNameValidate = By.id("lastname");
	private By companyName = By.id("company");
	private By address = By.id("address1");
	private By city = By.id("city");
	private By state = By.id("id_state");
	private By pCode = By.id("postcode");
	private By country = By.id("id_country");
	private By additionalInfo = By.name("other");
	private By mobilePhone = By.id("phone_mobile");
	private By futureReference = By.id("alias");
	private By submitRegister = By.id("submitAccount");
	private By myAccountPage = By.className("info-account");
			
//	
//	private By selectMonth = By.name("months");
//	private By selectYear = By.id("years");
//	private By checkBox = By.name("newsletter");
//	private By optinBox = By.id("optin");
//	//private By firstName = By.id("firstname");
//	
//	private By address2 = By.id("address2");
//	
	
	
	public void clickLoginButton() {
		driverHelper.click(loginButton, timeOutInSeconds);
	}
	
	public void enterEmailAddress(String email) {
		driverHelper.sendKeys(emailTextBox, email, timeOutInSeconds);
	}
	
	public void enterSubmit() {
		driverHelper.click(submit, timeOutInSeconds);
	}
	
	public String errorText() {
		return driverHelper.getText(getErrorText, timeOutInSeconds);
	}
	
	public void clickRegister() {
		driverHelper.click(submitButton, timeOutInSeconds);
	}
	
	public String errorText1() {
		return driverHelper.getText(errorTextOne, timeOutInSeconds);
	}
	
	public String errorText2() {
		return driverHelper.getText(errorTextTwo, timeOutInSeconds);
	}
	
	public String errorText3() {
		return driverHelper.getText(errorTextThree, timeOutInSeconds);
	}
	
	public String errorText4() {
		return driverHelper.getText(errorTextFour, timeOutInSeconds);
	}
	
	public String errorText5() {
		return driverHelper.getText(errorTextFive, timeOutInSeconds);
	}
	
	public String errorText6() {
		return driverHelper.getText(errorTextSix, timeOutInSeconds);
	}
	
	public String errorText7() {
		return driverHelper.getText(errorTextSeven, timeOutInSeconds);
	}
	
	public String errorText8() {
		return driverHelper.getText(errorTextEight, timeOutInSeconds);
	}
	
	public void selectGender() {
		driverHelper.click(genderButton, timeOutInSeconds);
	}
	

	public void enterFirstName() {
		driverHelper.sendKeys(firstName, "John", timeOutInSeconds);
	}
	
	public void enterLastName(String lName) {
		driverHelper.sendKeys(lastName, lName, timeOutInSeconds);
	}
	
	public String validateEmail() {
	   return driverHelper.getElement(emailValidate, timeOutInSeconds).getAttribute("value");
	}
	
	
	public void createPassword(String password1) {
		driverHelper.sendKeys(password, password1, timeOutInSeconds);
	}
	
	
	public void clickOnDay() {
			//driverHelper.getElement(clickDay, timeOutInSeconds);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('class', '')",driverHelper.getElement(clickDay, timeOutInSeconds));
//		driverHelper.getElement(clickDay);
	}
//	public  void clickOnDay() {
//		 driverHelper.getElement(clickDay, timeOutInSeconds);
//	    //driverHelper.selectDropdownValue(pickDay, "11", timeOutInSeconds);
//	}

	
	public void pickOnDay() {
		 //driverHelper.getElement(pickDay, timeOutInSeconds);
		 Select select = new
	    Select(driverHelper.getElement(pickDay, timeOutInSeconds)); 
		 select.selectByValue("11");
}
	public String validateFName() {
		return driverHelper.getElement(fNameValidate, timeOutInSeconds).getAttribute("value");
	}
	
	public String validateLName() {
		return driverHelper.getElement(lNameValidate, timeOutInSeconds).getAttribute("value");
	}
	
	public void CompanyName(String company) {
		driverHelper.sendKeys(companyName, company, timeOutInSeconds);
	}
	
	public void typeAddress() {
		driverHelper.sendKeys(address, "123 abc street", timeOutInSeconds);
	}
	
	public void typeCuty() {
		driverHelper.sendKeys(city, "New York", timeOutInSeconds);
	}
	
	
	
	
//	WebElement selectMyElement = driver.findElement(this.getObject(By.Id("Id of Your DropDown"))); 
//	selectMyElement.click();
//
//	Actions keyDown = new Actions(driver);
//	keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();

		
//		//Select select = //new Select(driver.findElement(By.id("days")));
//				//((ISelect) driverHelper.findElement(pickDay)).selectByValue("22");
//		//select.selectByValue("22"); 
//	}
//	
//	
//	public void selectMonthValue () {
//		driverHelper.selectDropdownValue(selectMonth, "April", timeOutInSeconds);
//	
//	}
//	
//	public void selectYearValue () {
//		driverHelper.selectDropdownValue(selectYear, "1993", timeOutInSeconds);
//	}
//	
//	public void selectCheckBox () {
//		driverHelper.click(checkBox, timeOutInSeconds);
//	}
//	
//	public void selectOptin() {
//		driverHelper.click(optinBox, timeOutInSeconds);
//		
//	}
//	
//	public void enterAddress() {
//		driverHelper.sendKeys(address, "123 e main street", timeOutInSeconds);
//		
//	}
//	
//	public void enterAddress2() {
//		driverHelper.sendKeys(address2, "apt 2b", timeOutInSeconds);
//	}
//	
//	public void enterCity() {
//		driverHelper.sendKeys(city, "Pittsburgh", timeOutInSeconds);
//		
//	}
//	
//	public void enterState() {
//		driverHelper.sendKeys(state, "PA", timeOutInSeconds);
//		
//	}
//	
//	public void selectCountry() {
//		driverHelper.selectDropdownValue(country, "United States", timeOutInSeconds);
//	}
//	
//	public void additionalInfo(String message ) {
//		driverHelper.sendKeys(additionalInfo, message, timeOutInSeconds);
//	}
//	
//	public void phoneNumber() {
//		driverHelper.sendKeys(mobilePhone, "412-334-4554", timeOutInSeconds);
//		
//	}
//	
//	public void enterfutureReference() {
//		
//		driverHelper.sendKeys(futureReference, "My address", timeOutInSeconds);
//	}
//	
//	public void enterRegister() {
//		driverHelper.click(submitButton, timeOutInSeconds);
//		
//	}
//	
//	public void validateAccount() {
//		String actualText = driverHelper.getText(myAccountPage, timeOutInSeconds);
//		String expectedText = "Welcome to your account. Here you can manage all of your personal information and orders.";
//		Assert.assertEquals(expectedText, actualText);
//	}
	

	
	
	
	

	
	
	
	
	
	
	
	
	
	

}
