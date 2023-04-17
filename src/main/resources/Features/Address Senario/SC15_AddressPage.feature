@Regression
Feature: point

  Scenario: user add address
    Given user login for address
    When user navigate to profile
    And user navigate to address page
    And user add fill all field
