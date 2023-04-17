package StepDefinitions.Compare;

import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import static StepDefinitions.Home.Hooks.driver;


public class CompareStepDefinition {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    CategoryPage category = new CategoryPage(driver);
    ComparePage compare = new ComparePage(driver);


    @Given("user logged in to add product to compare list")
    public void loggedUser(){
        home.login().click();
    //    login.userName().sendKeys("youssefsamir@gmail.com");
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @When("user select specific category")
    public void selectCategory() throws InterruptedException {
        home.selectproduct();
    }

    @And("user add product to compare list")
    public void addToCompareList()
    {
        category.addToCompareButton().click();
    }

    @Then("the product should added to compare list successfully")
    public void productAddedToWishList() throws InterruptedException {
        Thread.sleep(2000);
        String expectedResult = "The product has been added to your product comparison";
        String actualResult = compare.getCompareListMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
