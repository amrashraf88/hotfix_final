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
public class InvalidLoginByPhoneStepDefinition   {
	   public static int iduser;
	Api api = new Api();
	HomePage home = new HomePage(driver);
	LoginPage login = new LoginPage(driver);

	String nphone;
	private String idcustomer;

	@Given("user to login page IN PH")
	public void openLoginPageINPH() throws InterruptedException {

		Thread.sleep(3000);
		home.login().click();
		api.openphone();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}




	@And("user accept cookies IN PH")
	public void accept_cookieINPH() throws InterruptedException {
		Thread.sleep(3000);
		login.accept_cookie().click();
	}

	@When("user enter invalid phone IN PH\"(.*)\"$")
	public void enterphoneINPH(String username) throws IOException, InterruptedException {
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
					user_name.sendKeys(username);
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

	@And("user enter invalid password IN PH\"(.*)\"$")
	public void enterPasswordINPH(String password) {

		login.password().sendKeys(password);
	}

	@And("user click on login IN PH")
	public void clickLoginButtonINPH() {
		login.loginButton().click();
	//	loginacountbyphone();


	}

	@And("user click on profile IN PH")
	public void clickaccountbuttonPH() throws InterruptedException {
		Thread.sleep(2000);
		home.profile().click();
	}

	@Then("user could login successfully and redirected to home page EM")
	public void successLoginEM() throws InterruptedException {
		api.deleteMyAccountByemail();
		Thread.sleep(2000);
		String expectedResult = "Profile information";
		String actualResult = home.profile_name().getText();
		Assert.assertTrue(actualResult.contains(expectedResult));
	}

	@Then("user could validate that phone length IN PH")
	public void PHonevalidatePH() throws InterruptedException {
		Thread.sleep(2000);
		String expectedResult = "Phone number must be 9 digits";
		String actualResult = login.phonelenght().getText();
		System.out.println(actualResult);
		Assert.assertTrue(actualResult.contains(expectedResult));

	}
	@Then("user could validate that phone required IN PH")
	public void PhonevalidateGN() throws InterruptedException {

		Thread.sleep(2000);
		String expectedResult = "Phone is required";
		String actualResult = login.validationphone().getText();
		Assert.assertTrue(actualResult.contains(expectedResult));

	}
	@Then("user could validate that password length IN GN")
	public void passwordlenghtGN() throws InterruptedException {

		Thread.sleep(2000);
		String expectedResult = "Password isn't long enough, minimum of 8 characters";
		String actualResult = login.wrongpasswordLenght().getText();
		Assert.assertTrue(actualResult.contains(expectedResult));

	}
	@Then("user could validate that password required IN PH")
	public void passwordvalidatePH() throws InterruptedException {

		Thread.sleep(2000);
		String expectedResult = "Password is required";
		String actualResult = login.phonelenght().getText();
		Assert.assertTrue(actualResult.contains(expectedResult));

	}

}
