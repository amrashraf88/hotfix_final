@Regression
Feature: verify search function

  Scenario: Logged User could search for any product
    Given user login to his account
    And user enter name of product at search box
    And user click on search
    Then user could see the product displayed