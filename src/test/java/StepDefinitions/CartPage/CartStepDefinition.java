package StepDefinitions.CartPage;

import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.io.FileNotFoundException;

import static StepDefinitions.Home.Hooks.driver;


public class CartStepDefinition {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    CategoryPage category = new CategoryPage(driver);
    CartPage cart = new CartPage(driver);


    @Given("user logged in to add product to cart")
    public void loggedUser() throws InterruptedException, FileNotFoundException {

        Thread.sleep(3000);
        home.login().click();
        Thread.sleep(3000);
        login.userName();
        // login.userName().sendKeys(dataString);
        login.password().sendKeys("12345678");
        login.loginButton().click();
      //  login.userName().sendKeys(dataString);
    }

    @When("user choose category")
    public void selectCategory() throws InterruptedException {
     home.selectproduct();
    }

    @And("user add product to cart")
    public void addToCart() throws InterruptedException {
        Thread.sleep(4000);
        category.addToCartButton().click();
    }

    @Then("product should be added successfully to cart")
    public void productAddedToCart() throws InterruptedException {
        home.cartPageButton().click();
        Thread.sleep(3000);
        String expectedResult = "IMPEX GLORIA SMART LED TV 40";
        String actualResult = cart.getCartMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
