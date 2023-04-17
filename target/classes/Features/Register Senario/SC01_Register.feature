@Regression
Feature: verify register functionality

  Scenario Outline: User could register with valid data
    Given user navigate to registration page

    When user enter first name
    And user enter last name
    And user enter email"<gmail>"
    And user enter phone"<phonenumber>"
    And user enter password
    And user confirm password
    Then user could register successfully

    Examples:
    |gmail|phonenumber|
    |test.test@test.com     | 01062388340        |




