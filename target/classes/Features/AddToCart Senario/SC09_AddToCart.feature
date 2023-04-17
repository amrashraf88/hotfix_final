@Regression
Feature: verify cart functionality

  Scenario: Logged user could add different products to Shopping cart
    Given user logged in to add product to cart
    When user choose category
    And user add product to cart
    Then product should be added successfully to cart