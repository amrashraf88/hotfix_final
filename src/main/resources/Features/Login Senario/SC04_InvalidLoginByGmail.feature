@Regression
Feature: Verify user couldn't login without valid data Functionality for gmail


  Scenario Outline: User couldn't log in with invalid  password for email configuration
    Given user to login page IN GM
    And user accept cookies IN GM
    When user enter invalid email IN GM"<email>"
    And user enter invalid password IN GM"<password>"
    And user click on login IN GN

    Then user could validate that password lenght IN GN
    Examples:
      |email     |password  |
      |test.test@test.com|1234  |

  Scenario Outline: User couldn't log in with invalid email
    Given user to login page IN GM
    And user accept cookies IN GM
    When user enter invalid email IN GM"<email>"
    And user enter invalid password IN GM"<password>"
    And user click on login IN GN
    Then user couldnot login successfully and redirected to home page GM"<email>"
    Examples:
      |email     |password  |
      |test.test@tesmt.com|12345678 |
  Scenario Outline: User couldn't log in with invalid email and password
    Given user to login page IN GM
    And user accept cookies IN GM
    When user enter invalid email IN GM"<email>"
    And user enter invalid password IN GM"<password>"
    And user click on login IN GN

    Then user could validate that email required IN GN
    Then user could validate that password required IN GN
    Examples:
      |email     |password  |
      |||