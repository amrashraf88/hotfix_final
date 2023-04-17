@Regression
Feature: Logged user could select different tags

  Scenario: user can select different tags
    Given user login
    And user choose specific category
    And user select any tag
    Then this tag page should be opened successfully