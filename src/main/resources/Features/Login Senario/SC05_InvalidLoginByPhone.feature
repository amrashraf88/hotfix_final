@Regression
Feature: Verify user couldn't login without valid data Functionality


  Scenario Outline: User couldn't log in with invalid  password
Given user to login page IN PH
And user accept cookies IN PH
When user enter invalid phone IN PH"<username>"
And user enter invalid password IN PH"<password>"
And user click on login IN PH

Then user could validate that password length IN GN
Examples:
|username     |password  |
|010623883|1234  |

  Scenario Outline: User couldn't log in with invalid phone
    Given user to login page IN PH
    And user accept cookies IN PH
    When user enter invalid phone IN PH"<username>"
    And user enter invalid password IN PH"<password>"
    And user click on login IN PH

    Then user could validate that phone length IN PH
    Examples:
      |username     |password  |
      |01062388|12345678 |
  Scenario Outline: User couldn't log in with invalid email and password
    Given user to login page PH
    And user accept cookies PH
    When user enter invalid phone IN PH"<username>"
    And user enter invalid password IN PH"<password>"
    And user click on login IN PH

#    Then user could validate that phone required IN PH
    Then user could validate that password required IN PH
    Examples:
      |username     |password  |
      |||