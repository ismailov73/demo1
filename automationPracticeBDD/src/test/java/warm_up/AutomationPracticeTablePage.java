package warm_up;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.utilities.CommonPage;

public final class AutomationPracticeTablePage extends CommonPage {
	
	private static AutomationPracticeTablePage automationPracticeTablePage;
	
	public static AutomationPracticeTablePage getAutomationPracticeTablePage ( WebDriver driver ) {
		if ( automationPracticeTablePage == null ) 
			automationPracticeTablePage = new AutomationPracticeTablePage(driver);
		return automationPracticeTablePage;
	}

	private AutomationPracticeTablePage ( WebDriver driver ) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
//	private By header = By.tagName("h1");
	
	@FindBy ( tagName = "h1" )
	private WebElement header;
	
	@FindBy ( css = "#content [summary='Sample Table']" ) private WebElement tableElement;
	
//	@FindBys( { @FindBy (id = "") })
//	private WebElement columns;
	
	public String getHeader () {
		return header.getText();
	}
	
	public boolean isTableDisplayed () {
		return tableElement.isDisplayed();
	}
	
	
	
	
	
}
