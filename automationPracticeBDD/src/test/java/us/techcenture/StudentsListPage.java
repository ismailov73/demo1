package us.techcenture;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

/**
 * 
 * @author TechCenture
 *
 */
final class StudentsListPage extends CommonPage {

	private int timeOutInSeconds = 15;
	private static StudentsListPage studentsListPage;

	static StudentsListPage getStudentsListPage (WebDriver webDriver) {
		if (studentsListPage == null)
			studentsListPage = new StudentsListPage(webDriver);
		return studentsListPage;
	}

	private DriverHelper driverHelper = getDriverHelper();
	
	private StudentsListPage(WebDriver driver) { super(driver); }
	
	void clickCreateNewStudentLink () {
		driverHelper.clickByLinkText("Create new Student");
	}
	
	String [] getStudentData ( String name ) {
		String [] studentData = new String [5];
		//tbody//tr//td[2]
		List<WebElement> rowElements = driverHelper.getElements(By.cssSelector("tbody tr"), timeOutInSeconds);
		
		for ( int index = 0; index < rowElements.size(); index++ ) {
			WebElement rowElement = rowElements.get(index);
			
			if ( index == 0 ) continue; 
			
			String actualFirstName = rowElement.findElement(By.xpath(".//td[2]")).getText();
			
			/*
			 * try { actualFirstName =
			 * rowElement.findElement(By.xpath(".//td[2]")).getText(); } catch (
			 * NoSuchElementException e ) { continue; }
			 */
			
			if ( actualFirstName.equalsIgnoreCase(name) ) {
				studentData [0] = rowElement.findElement(By.xpath(".//td[1]")).getText();
				studentData [1] = rowElement.findElement(By.xpath(".//td[2]")).getText();
				studentData [2] = rowElement.findElement(By.xpath(".//td[3]")).getText();
				studentData [3] = rowElement.findElement(By.xpath(".//td[4]")).getText();
				studentData [4] = rowElement.findElement(By.xpath(".//td[5]")).getText();
				break;
			}
		}
		return studentData;
	}
}
