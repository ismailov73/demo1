package com.mockaroo.excel_generator;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonStep;
import com.automationpractice.utilities.DataStoreUtils;
import com.automationpractice.utilities.ExcelUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

import static org.junit.Assert.*;

public class ExcelGeneratorSteps extends CommonStep {

	private final ExcelGeneratorPage excelGeneratorPage = ExcelGeneratorPage.getExcelGeneratorPage(getDriver());
	
	@Given("I user I should able to read excel file")
	public void i_user_I_should_able_to_read_excel_file() throws IOException {
	    String filePath = Common.USER_HOME_DIR + "/Downloads/MOCK_DATA.xlsx";
	    excelGeneratorPage.printExcelContent(filePath);
	}
	
	@Given("User navigates to {string} website")
	public void user_navigates_to_website ( String url ) {
		getDriver().get(url);
	}

	@When("User add field name and type")
	public void user_add_field_name_and_type( DataTable dataTable ) {
		List<Map<String, String>> dataTableList = dataTable.asMaps(String.class, String.class);
		
		int numberOfRows = excelGeneratorPage.getNumberOfRows();
		if ( numberOfRows > dataTableList.size() )
			excelGeneratorPage.deleteRows(numberOfRows - dataTableList.size());
		
		for ( int index = 0; index < dataTableList.size(); index++ ) {
			String fieldName = dataTableList.get(index).get("field name");
			String type = dataTableList.get(index).get("type");
			
			excelGeneratorPage.enterFieldName(index, fieldName);
			excelGeneratorPage.chooseType(index, type);
			Common.sleep(1);
		}
	}
	
	@And("User adds {int} rows with file format {string}")
	public void user_adds_rows_with_file_format(Integer rows, String format) {
		excelGeneratorPage.addRows(rows);
		excelGeneratorPage.selectFileFormat(format);
	}
	
	@When("User clicks Download button")
	public void user_clicks_Download_button() {
	    excelGeneratorPage.clickDownloadButton();
	}
	
	/**
	 * when file is found
	 * data of excel file is saved in local memory as Map
	 * @throws IOException
	 */
	@Then("User validates the file is downloaded successfully")
	public void user_validates_the_file_is_downloaded_successfully() throws IOException {
		String filePath = Common.USER_HOME_DIR + "/Downloads/MOCK_DATA.xlsx";
	    boolean isFileDownloaded = Common.isFile(filePath);
	    assertTrue("File is not downloaded", isFileDownloaded);
//	    excelGeneratorPage.printExcelContent(filePath);
	    
	    Map<Integer, List<String>> excellDataMap = ExcelUtils.getExcelDataAsMaps(filePath);
	    
	    for ( Entry<Integer, List<String>> map : excellDataMap.entrySet() ) {
	    	System.out.print(map.getKey() + "\t");
	    	
	    	for ( int index = 0; index < map.getValue().size(); index++ )
	    		System.out.print(map.getValue().get(index) + "\t");
	    	
	    	System.out.println("\n============================================================================");
	    }
	    DataStoreUtils.storeData("excel data", excellDataMap);
	}
	
	@Then("User saves the data in new {string} excel file")
	public void user_saves_the_data_in_new_excel_file ( String fileName ) throws IOException {
	    ExcelUtils.writeToExcel(fileName);
	}
}
