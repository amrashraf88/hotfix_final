@Regression
Feature: verify Inventory functionality

  Scenario: User could select from inventory popup
    Given user select pickup
    And user select store
    And user save store
    And user click in inventory
    And user choose map

    Then user save his current location