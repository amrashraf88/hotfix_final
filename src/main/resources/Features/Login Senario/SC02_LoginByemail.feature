@Regression
Feature: Verify login Functionality

  Scenario Outline: User could log in with valid email and password
    Given user to login page GM1
    And user accept cookies GM
    When user enter valid gmail GM"<username>"
    And user enter valid password GM"<password>"
    And user click on login GM
    And  user click on profile GM
    Then user could login successfully and redirected to home page GM
    Examples:
    |username|password|
|Test.test.test@test.test |12345678|

