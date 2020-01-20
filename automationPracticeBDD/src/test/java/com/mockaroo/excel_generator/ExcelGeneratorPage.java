package com.mockaroo.excel_generator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

final class ExcelGeneratorPage extends CommonPage {

	private static int timeOutInSeconds = 15;
	private static final Logger logger = Logger.getLogger(ExcelGeneratorPage.class);
	private static ExcelGeneratorPage excelGeneratorPage;
	
	static ExcelGeneratorPage getExcelGeneratorPage ( WebDriver webDriver ) {
		if ( excelGeneratorPage == null ) excelGeneratorPage =
				new ExcelGeneratorPage(webDriver);
		return excelGeneratorPage;
	}
	
	private DriverHelper driverHelper = getDriverHelper();
	
	private ExcelGeneratorPage(WebDriver driver) {
		super(driver);
	}
	
	void printExcelContent ( String filePath ) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheetAt(0);
		
		int numberOfRows = sheet.getLastRowNum();
		
		for ( int row = 0; row <= numberOfRows; row++ ) {
			Row rowObj = sheet.getRow(row);
			
			int columns = rowObj.getLastCellNum();
			
			for ( int column = 0; column < columns; column++ ) {
				Cell cell = rowObj.getCell(column);
				System.out.print(cell.toString() + " | ");
				
				if ( column == columns - 1 ) {
					System.out.print("\n");
				}
				
			}
			
//			System.out.println();
			
		}
		
		workbook.close();
		fileInputStream.close();
	}
	
	int getNumberOfRows () {
		return driverHelper.getElements(By.cssSelector("#fields .fields"), timeOutInSeconds).size();
	}
	
	void deleteRows ( int numberOfRowsToDelete ) {
		List<WebElement> rowElements = driverHelper.getElements(By.cssSelector("#fields .fields"), timeOutInSeconds);
		
		for ( int row = 1; row <= numberOfRowsToDelete; row++ ) {
			int index = rowElements.size() - row;
			
			WebElement rowElement = rowElements.get(index);
			WebElement deleteIcon = rowElement.findElement(By.cssSelector(".column-remove"));
			deleteIcon.click();

//			rowElements.get(index).findElement(By.cssSelector(".column-remove")).click();
		}
	}
	
	void enterFieldName ( int row, String fieldName ) {
		boolean isRow = isRow(row + 1);
		if ( !isRow )
			clickAddAnotherFieldButton();
		
//		driverHelper.sendKeys(By.id("schema_columns_attributes_" + row + "_name"), fieldName, timeOutInSeconds);
		driverHelper.sendKeys(By.cssSelector("[placeholder='enter name...']"), (row + 1), fieldName, timeOutInSeconds);
	}
	
	void chooseType ( int row, String type ) {
		driverHelper.click(By.cssSelector("[placeholder='choose type...']"), (row + 1), timeOutInSeconds);
		driverHelper.sendKeys(By.id("type_search_field"), type, timeOutInSeconds);
		driverHelper.click(By.xpath("//div[@class='type-name'][contains(text(), '" + type + "')]"), timeOutInSeconds);
//		driverHelper.waitForElementInvisibility(By.cssSelector(".modal-backdrop"), timeOutInSeconds);
	}

	void clickAddAnotherFieldButton () {
		driverHelper.click(By.linkText("Add another field"), timeOutInSeconds);
	}
	
	void addRows ( int row ) {
		driverHelper.sendKeys(By.id("num_rows"), String.valueOf(row), timeOutInSeconds);
	}
	
	void selectFileFormat ( String format ) {
		driverHelper.selectDropdownValue(By.id("schema_file_format"), format, timeOutInSeconds);
	}
	
	void clickDownloadButton () {
		driverHelper.click(By.id("download"), timeOutInSeconds);
	}
	
	private boolean isRow ( int row ) {
		boolean isRow = false;
		try {
			isRow = driverHelper.getElement(By.cssSelector("#fields .fields"), row, timeOutInSeconds).isDisplayed();
		} catch ( Exception e ) {
			logger.error(e.getMessage());
		}
		return isRow;
	}
	
	
}









