@Regression
Feature: Create successful order

  Scenario: user can create Order

    When user choose any category
    And user add any product to cart
    And user open cart page
    And user click on checkout
    And user choose which way he went to checkout
    And user add data
    And user edit billing address
    And user choose payment method
    And user check payment information
    And user agree terms and conditions
    And user confirm order
Then order should be placed successfully