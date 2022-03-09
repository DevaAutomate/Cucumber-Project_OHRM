#Author: Bharath.Nittech@gmail.com
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
Feature: OrangeHRM Application Feature
  I want to use this feature file to test orange hrm application features

  Background: Application should be aunched
    Given Launch the application

  @Smoke @Functional
  Scenario: Verify application title
    Then Verify application title

  @Functional
  Scenario: Verify application page header
    Then Verify loginpage header

  @Regression
  Scenario Outline: Verify login functionality
    When I enter <Username> and <Password>
    And Click on login button
    Then Application login should be successful

    Examples: 
      | Username | Password |
      | admin    | admin123 |
      | abcd     | abcd123  |

  @Regression
  Scenario: Verify forgot password functionality
    Then Verify fogotpassword functionality
