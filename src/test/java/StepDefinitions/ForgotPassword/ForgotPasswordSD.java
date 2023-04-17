package StepDefinitions.ForgotPassword;

import POM.ForgotPassword;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import java.io.FileNotFoundException;

import static StepDefinitions.Home.Hooks.driver;

public class ForgotPasswordSD {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    ForgotPassword forget = new ForgotPassword(driver);

    @Given("user opened login page")
    public void openLoginPage(){
        home.login().click();
    }
    
    @And("user click on reset password")
    public void forgotPassword() throws InterruptedException
    {
    	Thread.sleep(3000);
        login.forgotPassword().click();
  
    }

    @And("user enter his email")
    public void enterEmail() throws InterruptedException, FileNotFoundException {
    	Thread.sleep(3000);
    	login.accept_cookie().click();
    	 forget.emailAddress();

    }

    @And("user click recover")
    public void clickOnRecover(){
        forget.recoverButton().click();
    }

    @Then("user should receive a link to reset password")
    public void checkRecoverMessage() throws InterruptedException {
        String expectedResult = "There is a link sent to your email, check your email.";
        Thread.sleep(2000);
        String actualResult =  forget.getRecoverMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
