package StepDefinitions.Login;

import POM.Api;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static StepDefinitions.Home.Hooks.driver;

public class LoginBydeactivedPhoneStepDefinition {
	   public static int iduser;
	Api api = new Api();
	HomePage home = new HomePage(driver);
	LoginPage login = new LoginPage(driver);



	@Given("user to login page DE PH")
	public void openLoginPageINPHDE() throws InterruptedException {

		Thread.sleep(3000);
		home.login().click();
		api.openphone();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		api.deactivedaccount();
	}




	@And("user accept cookies DE PH")
	public void accept_cookieINPHDE() throws InterruptedException {
		Thread.sleep(3000);
		login.accept_cookie().click();
	}

	@When("user enter invalid phone DE PH\"(.*)\"$")
	public void enterphoneINPHDE(String username) throws IOException, InterruptedException {
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
					user_name.sendKeys(phone);
				}
			} catch (Exception e) {
				user_name.click();
				user_name.sendKeys(username);
			}
		} else {
			WebElement emailInput = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/span/label/span"));
			emailInput.sendKeys(email);
		}
	}

	@And("user enter invalid password DE PH\"(.*)\"$")
	public void enterPasswordINPHDE(String password) {

		login.password().sendKeys(password);
	}

	@And("user click on login DE PH")
	public void clickLoginButtonINPHDE() {
		login.loginButton().click();
	//	loginacountbyphone();
		api.checkloginbyphone();

	}

	@And("user click on profile DE PH")
	public void clickaccountbuttonPHDE() throws InterruptedException {
		Thread.sleep(2000);
		api.activedaccount();
	}

	@Then("user could login successfully and redirected to home page Ph DE")
	public void successLoginEMDE() throws InterruptedException {

		Thread.sleep(2000);
		String expectedResult = "Profile information";
		String actualResult = home.profile_name().getText();
		Assert.assertTrue(actualResult.contains(expectedResult));
	}



}
