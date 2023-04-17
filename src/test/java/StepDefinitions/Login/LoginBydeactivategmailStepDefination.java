package StepDefinitions.Login;

import POM.Api;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static StepDefinitions.Home.Hooks.driver;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class LoginBydeactivategmailStepDefination {

   Api api = new Api();
    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);

    String nphone;

    @Given("user to login page DE GM")
    public void openLoginPageForDEGM() throws InterruptedException {

        Thread.sleep(4000);
        home.login().click();
        Thread.sleep(1000);
        api.openemail();
        driver.navigate().refresh();
        Thread.sleep(3000);
        api.deactivedaccountFOREMAIL();

    }


    @And("user accept cookies DE GM")
    public void accept_cookieDEGN() throws InterruptedException {
        Thread.sleep(3000);
        login.accept_cookie().click();
    }

    @When("user enter invalid email DE GM\"(.*)\"$")
    public void enterEmailDEGN(String email) throws IOException, InterruptedException {
        File emailFile = new File("fileName2.txt");
        Scanner emailScanner = new Scanner(emailFile);
        String email1 = emailScanner.nextLine();
        emailScanner.close();

// Read phone from phone.txt
        File phoneFile = new File("fileName.txt");
        Scanner phoneScanner = new Scanner(phoneFile);
        String phone = phoneScanner.nextLine();
        phoneScanner.close();

// Find the element that determines whether to send email or phone
        WebElement user_name = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/input"));


        if (user_name.isDisplayed()) {
            try {
                WebElement phoneInput = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/span[2]/label"));

                if (phoneInput.isDisplayed()) {
                    // Element is displayed, send phone number
                    user_name.sendKeys(phone);}
            } catch (Exception e) {
                user_name.click();
                user_name.sendKeys(email);
            }
        }else {   WebElement emailInput = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/span/label/span"));
            emailInput.sendKeys(email);
        }
    }



    @And("user enter invalid password DE GM\"(.*)\"$")
    public void enterPasswordDEGN(String password) {
        login.password().sendKeys(password);
    }

    @And("user click on login DE GN")
    public void clickLoginButtonDEGN() {
        login.loginButton().click();
        api.checkloginbyemail();
        api.activedaccount();
    }




}
