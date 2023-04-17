@Regression
Feature: verify category functionality

  Scenario: Logged user could select different Categories
    Given user logged in to select category
    And user hover on category and select subcategory
    Then the selected category should be displayed