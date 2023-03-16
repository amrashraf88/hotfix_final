# hotfix_final
Automation for E-Commerce System
This project is an automation testing framework for an e-commerce system using Cucumber with reporting in Allure. The project is implemented using the latest automation technologies.

Requirements
Java 8 or higher
Maven
Cucumber
Selenium WebDriver
Allure reporting
Installation
Clone this repository to your local machine
Install Java 8 or higher
Install Maven
Install Cucumber, Selenium WebDriver, and Allure reporting dependencies by running the following command:
bash
Copy code
mvn install
Usage
To execute the tests, run the following command in the terminal:

bash
Copy code
mvn clean test
This will run all the feature files in the src/test/resources/features directory.

After the tests are executed, the Allure report can be generated by running the following command:

bash
Copy code
mvn allure:serve
This will generate the Allure report and open it in the default browser.

Features
The features tested in this project include:

User registration
User login
Adding items to cart
Removing items from cart
Checking out
Framework
This project is implemented using the Page Object Model (POM) design pattern, which promotes code reusability and easy maintenance. The framework uses Cucumber for behavior-driven development, Selenium WebDriver for web automation, and Allure for reporting.

Conclusion
This project provides an efficient and scalable automation framework for testing e-commerce systems using the latest automation technologies. The POM design pattern ensures easy maintenance and code reusability, while Cucumber and Allure enable behavior-driven development and comprehensive reporting.
