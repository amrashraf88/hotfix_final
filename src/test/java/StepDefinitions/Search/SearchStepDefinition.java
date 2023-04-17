package StepDefinitions.Search;

import POM.HomePage;
import POM.LoginPage;
import POM.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.io.FileNotFoundException;

import static StepDefinitions.Home.Hooks.driver;


public class SearchStepDefinition {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    SearchPage search = new SearchPage(driver);

    @Given("user login to his account")
    public void loggedUser() throws InterruptedException, FileNotFoundException {


        Thread.sleep(3000);
        home.login().click();
        Thread.sleep(3000);
        login.userName();
       // login.userName().sendKeys(dataString);
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @And("user enter name of product at search box")
    public void searchOnProduct() throws InterruptedException {
        Thread.sleep(3000);
        home.searchBox().click();
        home.searchBox().sendKeys(" ");
    }

    @And("user click on search")
    public void clickSearchButton()
    {
        home.searchBox().sendKeys(Keys.ENTER);
    }

    @Then("user could see the product displayed")
    public void productIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        boolean expectedResult = search.appleProduct().isDisplayed();
        Assert.assertEquals(expectedResult, true);
    }


}
