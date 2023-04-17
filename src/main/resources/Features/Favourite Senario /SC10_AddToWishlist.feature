@Regression
Feature: verify wishlist functionality

  Scenario: Logged user could add different products to Wishlist
    Given user logged in to add product to wishlist
    When user select any category
    And user add product to wishlist
    Then product should add to wishlist successfully