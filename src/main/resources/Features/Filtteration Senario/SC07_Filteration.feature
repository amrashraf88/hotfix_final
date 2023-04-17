@Regression
Feature: verify filtration functionality

  Scenario: Logged user could filter with color
    Given user is logged in to filter
    When user select category
    And user filter by color
    Then products with this attribute should be displayed