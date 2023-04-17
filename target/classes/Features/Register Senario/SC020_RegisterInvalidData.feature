@Regression
Feature: verify register functionality

  Scenario Outline: User couldnot  register without field in required
    Given user navigate to registration page IN

    When user enter first name IN "<F_name>"
    And user enter last name IN "<L_name>"
    And user enter email IN "<gmail>"
    And user enter phone IN "<phonenumber>"
    And user enter password IN "<password>"
    And user confirm password IN "<confirm_password>"
    Then user could register successfully
    Then user could validate phone length
    Then user could validate email correct

    Examples:
      |F_name|L_name|gmail|phonenumber|password|confirm_password|
      |   test   | test     |   test@as  |   0105266        |    12345678    |12345678                |

  Scenario Outline: User couldnot  register without field in required
    Given user navigate to registration page IN

    When user enter first name IN "<F_name>"
    And user enter last name IN "<L_name>"
    And user enter email IN "<gmail>"
    And user enter phone IN "<phonenumber>"
    And user enter password IN "<password>"
    And user confirm password IN "<confirm_password>"
    Then user could register successfully
    Then user could validate phone length
    Then user could validate email correct
    Then user cloudnot regiseter without make confirm password like password
    Examples:
      |F_name|L_name|gmail|phonenumber|password|confirm_password|
      |   test   | test     |   test@as  |   0105266        |    12345678    |1234567                |



