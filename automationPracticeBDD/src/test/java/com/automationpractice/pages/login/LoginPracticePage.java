package com.automationpractice.pages.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

public class LoginPracticePage extends CommonPage {
	
	private static final int timeOutInSeconds = 15;
	private static final Logger logger = Logger.getLogger(LoginPracticePage.class);
	private DriverHelper driverHelper = getDriverHelper();
	
	//private By signInLink = By.linkText("http://automationpractice.com/index.php?controller=my-account");
	private By signInLink = By.className("login");
	private By emailBox = By.name("email");
	private By passwordBox = By.name("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By getTextInfo = By.className("info-account");
	private By myInfo = By.xpath("//span[text()='My personal information']");
	private By header = By.tagName("h1");
	private By signOut = By.className("logout");
	
	

	public LoginPracticePage(WebDriver driver) {
		super(driver);
	
	}
	
	public void signIn () {
		driverHelper.click(signInLink, timeOutInSeconds);
	}
	
	public void typeEmail (String email ) {
		driverHelper.sendKeys(emailBox, email, timeOutInSeconds);
		logger.info("Entered email " + email );
	}
	
	public void typePassword(String password ) {
		driverHelper.sendKeys(passwordBox, password, timeOutInSeconds);
		logger.info("Entered password " + password);
	}
	
	public void submitButton () {
		driverHelper.click(signInButton, timeOutInSeconds);
		logger.info("Clicked on sing in ");
	}
	
	public String verifyText() {
		return driverHelper.getText(getTextInfo, timeOutInSeconds);
	}
	
	public String verifyMyInfoText() {
		return driverHelper.getText(myInfo, timeOutInSeconds);
	}
	
	public  String getHeader () {
		 return driverHelper.getText(header, timeOutInSeconds);
	}
	
	public void logOut() {
		driverHelper.click(signOut, timeOutInSeconds);
		logger.info("Clicked on sign out");
	}
	
	
	public String getErrorMessage () {
		
		return driverHelper.getText(By.cssSelector("[class='alert alert-danger']"), timeOutInSeconds);
		
	}
	
	
	
	

}
