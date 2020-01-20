@login
Feature: Excel Generator

@skip
Scenario: As User I should be able to generate excel file
	Given I user I should able to read excel file
	
	@excel1
	Scenario: As User I should be able to generate excel file with test data
		Given User navigates to "https://mockaroo.com/" website
		When User add field name and type
			|field name|type          |
			|id        |Row Number    |
			|first_name|First Name    |
			|last_name |Last Name     |
			|address   |Street Address|
		And User adds 20 rows with file format "Excel"
		And User clicks Download button
		Then User validates the file is downloaded successfully
		And User saves the data in new "students" excel file

