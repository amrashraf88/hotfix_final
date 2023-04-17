package StepDefinitions.Register;

import POM.HomePage;
import POM.InventoryPage;
import POM.RegistrationPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static StepDefinitions.Home.Hooks.driver;

public class InvalidRegisterStepDefination {
    Faker faker = new Faker();
    String nPhone;

    InventoryPage inventory = new InventoryPage(driver);
    HomePage home = new HomePage(driver);
    String phone = home.fask_phone();

    RegistrationPage register = new RegistrationPage(driver);
    @Given("user navigate to registration page IN")
    public void openRegistrationPagInvalid() throws InterruptedException {
        Thread.sleep(3000);
        home.login().click();

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        home.register().click();
    }
    @When("user enter first name IN \"(.*)\"$")
    public void InalidFirstNameIN(String F_name)
    {
        String name = home.fask_name();
        register.firstName().sendKeys(F_name);
        String Name_f=  name;
    }
    @And("user enter last name IN \"(.*)\"$")
    public void InvalidLastNameIN(String L_name)
    {
        register.lastName().sendKeys(L_name);
    }
    @And("user enter email IN \"(.*)\"$")
    public void invalidEmailIN(String gmail) throws IOException {
        String email = home.fask_email();
        register.email().sendKeys(gmail);
    }
    @And("user enter phone IN \"(.*)\"$")
    public void phoneIN(String phonenumer) throws IOException {
        register.phone().sendKeys(phonenumer);
        register.phone().getAttribute(phonenumer);
    }
    @And("user enter password IN \"(.*)\"$")
    public void IncorrectPasswordIN(String password)
    {
        register.password().sendKeys(password);
    }
    @And("user confirm password IN \"(.*)\"$")
    public void confirmPasswordIN(String confirm_password)
    {
        register.confirmPassword().sendKeys(confirm_password);
    }

    @Then("user could register successfully IN")
    public void clickOnRegisterBtnIN()
    {
        register.registerButton().click();
    }
    @Then("user could validate that first name required")
    public void fisrtNameValidationIN() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "First name is required";
        String actualResult = register.firstNameValidation().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Then("user could validate that last name required IN")
    public void LastNameValidationIN() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "Last name is required";
        String actualResult = register.lastNameValidation().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Then("user could validate that email required")
    public void EmailValidationIN() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "Email is required";
        String actualResult = register.emailValidation().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Then("user could validate that phone required")
    public void PhoneValidationIN() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "Phone is required";
        String actualResult = register.phoneValidation().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Then("user could validate that password required")
    public void PasswordValidationIN() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "Password is required";
        String actualResult = register.passwordValidation().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Then("user could validate phone length")
    public void PhonelengthIN() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "Phone number must be 9 digits";
        String actualResult = register.checkphone().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Then("user could validate email correct")
    public void emailcheackIN() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "Email is not valid";
        String actualResult = register.checkemail().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Then("user cloudnot regiseter without make confirm password like password")
    public void confirmepassword() throws InterruptedException {
        Thread.sleep(2000);
        String expectedResult = "Passwords doesn't match";
        String actualResult = register.confirmPassword().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
