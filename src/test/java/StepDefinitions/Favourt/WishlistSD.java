package StepDefinitions.Favourt;

import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.io.FileNotFoundException;

import static StepDefinitions.Home.Hooks.driver;


public class WishlistSD {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    CategoryPage category = new CategoryPage(driver);
    WishlistPage list = new WishlistPage(driver);


    @Given("user logged in to add product to wishlist")
    public void loggedUser() throws InterruptedException, FileNotFoundException {
        Thread.sleep(3000);
        home.login().click();
        Thread.sleep(3000);
        login.userName();
        // login.userName().sendKeys(dataString);
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @When("user select any category")
    public void selectCategory() throws InterruptedException {
      home.selectproduct();
    }

    @And("user add product to wishlist")
    public void addToWishlist() throws InterruptedException {
        Thread.sleep(2000);

        category.addToWishlistButton().click();
    }

    @Then("product should add to wishlist successfully")
    public void productAddedToWishlist() throws InterruptedException {
        home.faverote().click();
        Thread.sleep(6000);
        String expectedResult = "IMPEX GLORIA SMART LED TV 40";
        String actualResult = list.getWishlistMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
