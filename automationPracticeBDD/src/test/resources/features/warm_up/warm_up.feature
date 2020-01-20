Feature: HTML form submission
  User HTML form submission #notes about the feature

  Scenario: As user I ashould able submit HTML form
    Given User navigates to TOOLS QA home page
    When User clicks HTML form link
    And User enters "Ali" first name
    And User enters "Oz" last name
    And User enters "USA" country
    And User enters "Hello" subject
    And User clicks submit button
    Then User should see successful page

	@htmlFormSubmission
  Scenario Outline: As user I ashould able submit HTML form
    Given User navigates to TOOLS QA home page
    When User clicks HTML form link
    And User enters "<first name>" first name
    And User enters "<last name>" last name
    And User enters "<country>" country
    And User enters "<subject>" subject
    And User clicks submit button
    Then User should see successful page

	Examples: users
	|first name|last name|country |subject                       |
	|Ali       |Oz       |USA     |I am from USA                 |
	|Mushfig   |Oz1      |USA     |I am from USA, I like cucumber|
	|Jahid     |Greece   |Virginia|I am from VA                  |
	
		@sampleTable
	 	Scenario: As a user I should be able to print all values from Sample table
	 	Given User navigates to ""
	 	When User is able to view Sample table
	 	Then User should be able to print values to console
	
	
	
	
	
	

