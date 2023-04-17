package StepDefinitions.Register;

import POM.HomePage;

import POM.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.http.ContentType;

import java.io.IOException;


import static StepDefinitions.Home.Hooks.driver;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class RegisterStepDefinition {
	




    HomePage home = new HomePage(driver);


    RegistrationPage register = new RegistrationPage(driver);

    @Given("user navigate to registration page")
    public void openRegistrationPag() throws InterruptedException {
        Thread.sleep(3000);
    	home.login().click();

    	try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        home.register().click();
        deleteMyAccountByphone();
        deleteMyAccountByemail();
    }


  

    @When("user enter first name")
    public void enterFirstName()
    {
    	String name = home.fask_name();
        register.firstName().sendKeys(name);
        String Name_f=  name;
    }

    @And("user enter last name")
    public void enterLastName()
    {
        register.lastName().sendKeys("ashraf");
    }

    @And("user enter email\"(.*)\"$")
    public void enterEmailVA(String gmail) throws IOException {

        register.email().sendKeys(gmail);

    }


    
    @And("user enter phone\"(.*)\"$")
    public void phone(String phonenumber) throws IOException {


        register.phone().sendKeys(phonenumber);


    }


    @And("user enter password")
    public void enterPassword()
    {
        register.password().sendKeys("12345678");
    }

    @And("user confirm password")
    public void confirmPassword()
    {
        register.confirmPassword().sendKeys("12345678");
    }

    @Then("user could register successfully")
    public void clickOnRegisterBtn() throws InterruptedException {
        register.registerButton().click();
        Thread.sleep(3000);

    }





@When("I delete my account")
public void i_delete_my_account() throws InterruptedException {
    // Call the deleteMyAccount() method here
    Thread.sleep(1000);

}
String token1;
    public static void deleteMyAccountByphone() {
        String token1 = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/auth")
                .contentType(ContentType.JSON)
                .body("{ \"phone\": \"010623883\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)

                .extract()

                .path("data.token");

        System.out.println("Token: " + token1);
        given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/delete")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1)
                .body("{}")
                .post("/my_account")
                .then()
                .statusCode(200);
//                .assertThat()
//                .body(equalTo("Account deleted successfully."));
    }
    public static void deleteMyAccountByemail() {
        String token1 = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/auth")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"test.test@test.com \", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)

                .extract()

                .path("data.token");

        System.out.println("Token: " + token1);
        given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/delete")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1)
                .body("{}")
                .post("/my_account")
                .then()
                .statusCode(200);
//                .assertThat()
//                .body(equalTo("Account deleted successfully."));
    }
    public static void createaccount() {
        given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/delete")
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"test\", \"last_name\": \"test\", \"email\": \"test@test.com\", \"phone\": \"010623888\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200);
//                .assertThat()
//                .body(equalTo("Account deleted successfully."));
    }

//        .body("{ \"name\": \"test\", \"last_name\": \"test\", \"email\": \"test@test.com\", \"phone\": \"010623888\", \"password\": \"12345678\" }")
    }

