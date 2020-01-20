package us.techcenture;

import java.util.List;

import com.automationpractice.utilities.CommonStep;
import com.automationpractice.utilities.DataStoreUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import us.techcenture.CreateStudentPage.CreateStudentFields;

import static org.junit.Assert.*;

public class CreateStudentSteps extends CommonStep {

	private HomePage homePage = HomePage.getHomePage(getDriver());
	private StudentsListPage studentsListPage = StudentsListPage.getStudentsListPage(getDriver());
	private CreateStudentPage createStudentPage = CreateStudentPage.getCreateStudentPage(getDriver());
	
	@Given("User navigates to home page {string}")
	public void user_navigates_to_home_page(String url) {
	    getDriver().get(url);
	}

	@When("User clicks on CREATE STUDENT button")
	public void user_clicks_on_CREATE_STUDENT_button() {
	    homePage.clickCreateStudentButton();
	}

	@When("User clicks CREATE NEW STUDENT button")
	public void user_clicks_CREATE_NEW_STUDENT_button() {
	    studentsListPage.clickCreateNewStudentLink();
	}

	@When("User inputs name, last name, course and student age")
	public void user_inputs_name_last_name_course_and_student_age( DataTable dataTable ) {
	   List<String> dataTableList = dataTable.asList(String.class);
	   
	   //TODO
//	   for ( int index = 0; index < dataTableList.size(); index++ ) {
//		   String fieldName = index % 2 == 0 ? 
//	   }
	   
	   String name = dataTableList.get(1);
	   String lastName = dataTableList.get(3);
	   String course = dataTableList.get(5);
	   String age = dataTableList.get(7);
	   
	   createStudentPage.enterStudentData(CreateStudentFields.NAME, name);
	   createStudentPage.enterStudentData(CreateStudentFields.LAST_NAME, lastName);
	   createStudentPage.enterStudentData(CreateStudentFields.COURSE, course);
	   createStudentPage.enterStudentData(CreateStudentFields.STUDENT_AGE, age);
	   
	   DataStoreUtils.storeData("name", name);
	   DataStoreUtils.storeData("last name", lastName);
	   DataStoreUtils.storeData("course", course);
	   DataStoreUtils.storeData("age", age);
	}

	@When("User clicks SAVE button")
	public void user_clicks_SAVE_button() {
	    createStudentPage.clickSaveButton();
	}

	@Then("User should see his name in the student list")
	public void user_should_see_his_name_in_the_student_list() {
		String name = DataStoreUtils.getObjectAsString("name");
		String [] studentData = studentsListPage.getStudentData(name);
		
	    String actualId = studentData [0];
	    String actualName = studentData [1];
	    String actualLastName = studentData [2];
	    String actualCourse = studentData [3];
	    String actualAge = studentData [4];
	    
	    assertEquals(name, actualName);
	    assertEquals(actualLastName, DataStoreUtils.getObjectAsString("last name"));
	    assertEquals(actualCourse, DataStoreUtils.getObjectAsString("course"));
	    assertEquals(actualAge, DataStoreUtils.getObjectAsString("age"));
	}
}








