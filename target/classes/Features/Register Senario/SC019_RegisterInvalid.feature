@Regression
Feature: verify register functionality

  Scenario Outline: User could validate that register field in required
    Given user navigate to registration page IN

    When user enter first name IN "<F_name>"
    And user enter last name IN "<L_name>"
    And user enter email IN "<gmail>"
    And user enter phone IN "<phonenumber>"
    And user enter password IN "<password>"
    And user confirm password IN "<confirm_password>"
    Then user could register successfully
    Then user could validate that first name required
    Then user could validate that last name required IN
    Then user could validate that email required
    Then user could validate that phone required
    Then user could validate that password required
   Examples:
    |F_name|L_name|gmail|phonenumber|password|confirm_password|
    |      |      |     |           |        |                |



