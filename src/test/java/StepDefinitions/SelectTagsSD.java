package StepDefinitions;

import POM.CategoryPage;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static StepDefinitions.Home.Hooks.driver;


public class SelectTagsSD {

    HomePage home = new HomePage(driver);
    CategoryPage category = new CategoryPage(driver);
    LoginPage login = new LoginPage(driver);
    Actions action;
    @Given("user login")
    public void loginToWebsite()
    {
        home.login().click();
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
    }

    @And("user choose specific category")
    public void selectCategory() throws InterruptedException {
        home.select_category().click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"en\"]/app-root/div/mat-sidenav-container/mat-sidenav-content/app-softbar/div"));
        Actions action=new Actions(driver);
        action.moveToElement(element).perform();
        action.click().build().perform();
    }

    @And("user select any tag")
    public void selectTag()
    {
        category.computerTag().click();
    }

    @Then("this tag page should be opened successfully")
    public void validateSuccessTag() throws InterruptedException {
        Thread.sleep(2000);
        String expectedResult = "BREAD";
        String actualResult = category.getMessageOfTag().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
