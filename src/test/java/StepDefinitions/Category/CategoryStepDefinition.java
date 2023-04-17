package StepDefinitions.Category;

import POM.CategoryPage;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.io.FileNotFoundException;

import static StepDefinitions.Home.Hooks.driver;


public class CategoryStepDefinition {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    CategoryPage category = new CategoryPage(driver);


    @Given("user is logged in to filter")
    public void loggedUser() throws InterruptedException, FileNotFoundException {
        home.login().click();
        Thread.sleep(3000);
        login.userName();
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @When("user select category")
    public void selectCategory() throws InterruptedException {
        Thread.sleep(2000);
        home.hoverOnCategory();
    }

    @And("user filter by color")
    public void filterByColor() throws InterruptedException {
        Thread.sleep(3000);
        category.priceFilter().click();
        category.priceFilter().sendKeys("10");
        category.priceFilter_input().click();
        category.priceFilter_input().sendKeys("1000");
        category.apply_filter().click();
    }

    @Then("products with this attribute should be displayed")
    public void checkFiltration() throws InterruptedException {
        Thread.sleep(2000);
        boolean actualResult = category.filteredCategory().isDisplayed();
        Assert.assertEquals(true, actualResult);
    }


}
