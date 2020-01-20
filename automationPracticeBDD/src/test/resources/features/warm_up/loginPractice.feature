@loginToAccount
Feature: loginToAccount

  @smokeTest
  Scenario: Login validation
    Given User navigates to home page
    When User clicks on sign in link
    And User inputs valid email and password
    And User clicks on sign in button
    Then User is on account page

  @negativeP
  Scenario: User login with invalid cridentials
    Given User navigates to home page
    When User clicks on sign in link
    And User inputs "invalid" email and "invalid" password
    And User clicks on sign in button
    Then User should see error message "Invalid email address."

  @negativeP @multipleExamples
  Scenario Outline: User login validation with invalid cridentials
    Given User navigates to home page
    When User clicks on sign in link
    And User inputs "<email>" email and "<password>" password
    And User clicks on sign in button
    Then User should see error message "<error message>"

    Examples: Invalid credentials
      | email                 | password | error message          |
      | invalid               | invalid  | Invalid email address. |
      | abc213@mailinator.com | invalid  | Authentication failed. |
      | invalid               | abc1234  | Invalid email address. |

  @negativeP @wip
  Scenario: User login validation with invalid credentials
    Given User navigates to home page
    When User clicks on sign in link
    Then User inputs email, password and clicks sign in button and validate error message
      | email                 | password | error message          |
      | invalid               | invalid  | Invalid email address. |
      | abc213@mailinator.com | invalid  | Authentication failed  |
      | invalid               | abc1234  | Invalid email address. |
#    Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |
