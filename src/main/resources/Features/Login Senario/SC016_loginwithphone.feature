@Regression
Feature: Verify login with phone Functionality
Scenario Outline: User could log in with valid phone and password
Given user to login page PH
And user accept cookies PH
When user enter valid Phone PH"<phonenumber>"
And user enter valid password PH"<password>"
And user click on login PH
And  user click on profile PH
Then user could login successfully and redirected to home page PH
Examples:
|phonenumber|password|
|010345234 |12345678|