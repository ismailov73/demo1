
@createAccount

Feature: Application 

Scenario: Sign up Application


Given I am on home page 
And Click on sign in button 
And In email address text field of left side enter already registered email address 
Then Click on create an account button and verify error message displayed

@test
Scenario: User register with with valid email 
Given I am on home page 
And Click on sign in button
And In email address text field of left side enter new email address
And Click on create account
Then Click on register and verify error messages displayed
And Fill up the apllication with data provided





#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

#@tag
#Feature: Title of your feature
#  I want to use this template for my feature file

#  @tag1
#  Scenario: Title of your scenario
#    Given I want to write a step with precondition
#    And some other precondition
#    When I complete action
#    And some other action
#    And check more outcomes

#  @tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step

#    Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |
