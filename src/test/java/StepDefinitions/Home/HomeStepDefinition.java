package StepDefinitions.Home;

import POM.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static StepDefinitions.Home.Hooks.driver;


public class HomeStepDefinition {

    HomePage home = new HomePage(driver);
    CategoryPage category = new CategoryPage(driver);
    LoginPage login = new LoginPage(driver);


    @Given("user logged in to select category")
    public void loggedUser() throws InterruptedException, FileNotFoundException {
        home.login().click();
        Thread.sleep(2000);
        login.userName();

        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/amr/Downloads/hotfix_final/fileName.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String dataString = data.toString();
        System.out.println(dataString);

      //  login.userName().sendKeys(dataString);
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @And("user hover on category and select subcategory")
    public void selectCategory() throws InterruptedException {
        Thread.sleep(1000);
        home.hoverOnCategory();
    }

    @Then("the selected category should be displayed")
    public void checkSelectedCategory() throws InterruptedException {
        Thread.sleep(4000);
        boolean actualResult = category.categoryExist().isDisplayed();
        Assert.assertEquals(true, actualResult);
    }

}
