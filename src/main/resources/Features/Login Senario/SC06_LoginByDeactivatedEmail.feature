@Regression
Feature: Verify login Functionality

  Scenario Outline: User could log in with valid email and password
    Given user to login page DE GM
    And user accept cookies DE GM
    When user enter invalid email DE GM"<username>"
    And user enter invalid password DE GM"<password>"
    And user click on login DE GN

    Examples:
    |username|password|
|test.test@test.com|12345678|

