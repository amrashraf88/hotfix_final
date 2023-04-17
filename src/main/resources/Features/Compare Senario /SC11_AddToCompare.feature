@Regression
Feature: verify compare list functionality

  Scenario:  Logged user could add different products to compare list
    Given user logged in to add product to compare list
    When user select specific category
    And user add product to compare list
    Then the product should added to compare list successfully