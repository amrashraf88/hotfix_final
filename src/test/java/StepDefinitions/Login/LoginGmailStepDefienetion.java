
package StepDefinitions.Login;

import POM.Api;
import POM.HomePage;
import POM.LoginPage;
import POM.Respponsive;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.*;

import java.time.Duration;
import java.util.Scanner;

import static StepDefinitions.Home.Hooks.driver;
import static io.restassured.RestAssured.given;


public class LoginGmailStepDefienetion {

    Respponsive respponsive = new Respponsive();
    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    Api api = new Api();

    @Given("user to login page GM1")
    public void openLoginPageGM() throws InterruptedException {


//        api.setpranch();
//        driver.navigate().refresh();


        Thread.sleep(2000);
        home.login().click();
        Thread.sleep(2000);
        api.openGmail();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
    }



    @And("user accept cookies GM")
    public void accept_cookieGM() throws InterruptedException {
        Thread.sleep(3000);
        login.accept_cookie().click();
    }

    @When("user enter valid gmail GM\"(.*)\"$")
    public void enterEmailGM(String phonenumber) throws IOException, InterruptedException {
        File emailFile = new File("fileName2.txt");
        Scanner emailScanner = new Scanner(emailFile);
        String email = emailScanner.nextLine();
        emailScanner.close();

        File phoneFile = new File("fileName.txt");
        Scanner phoneScanner = new Scanner(phoneFile);
        String phone = phoneScanner.nextLine();
        phoneScanner.close();

        WebElement user_name = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/input"));

        if (user_name.isDisplayed()) {
            try {
                WebElement phoneInput = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/span[2]/label"));

                if (phoneInput.isDisplayed()) {
                    user_name.sendKeys(phonenumber);
                }
            } catch (Exception e) {
                user_name.click();
                user_name.sendKeys(email);
            }
        } else {
            WebElement emailInput = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/span/label/span"));
            emailInput.sendKeys(email);
        }
    }

    @And("user enter valid password GM\"(.*)\"$")
    public void enterPassworGM(String password) {
        login.password().sendKeys(password);
    }

    @And("user click on login GM")
    public void clickLoginButtonGM() {
        login.loginButton().click();
    }

    @And("user click on profile GM")
    public void clickaccountbuttonGM() throws InterruptedException {
        Thread.sleep(2000);
        home.profile().click();
    }

    @Then("user could login successfully and redirected to home page GM")
    public void successLogingGM() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "Profile information";
        String actualResult = home.profile_name().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
