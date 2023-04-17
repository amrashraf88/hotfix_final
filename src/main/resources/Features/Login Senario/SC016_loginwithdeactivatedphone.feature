@Regression
Feature: Verify login with phone Functionality
Scenario Outline: User could log in with valid phone and password
Given user to login page DE PH
And user accept cookies DE PH
When user enter invalid phone DE PH"<phonenumber>"
And user enter invalid password DE PH"<password>"
And user click on login DE PH
And user click on profile DE PH
Examples:
|phonenumber|password|
|01062388 |12345678|