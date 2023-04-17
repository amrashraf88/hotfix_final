package StepDefinitions.Login;
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
        import java.io.*;
        import java.util.Scanner;
        import static StepDefinitions.Home.Hooks.driver;

        import static io.restassured.RestAssured.given;
        import static org.hamcrest.CoreMatchers.equalTo;


public class InvalidLoginBygmailStepDefination  {


    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);

    String nphone;

    @Given("user to login page IN GM")
    public void openLoginPageForInGM() throws InterruptedException {

        Thread.sleep(4000);
        home.login().click();
        Thread.sleep(1000);
        openemail();
        driver.navigate().refresh();
        Thread.sleep(3000);

    }
    public static void openemail() {
        String token1 = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/auth")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"admin@el-dokan.com\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)

                .extract()

                .path("data.token");

        System.out.println("Token: " + token1);
        given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/configurations/manager/update")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1)
                .body("{ \"configs\": [ { \"id\": 359, \"value\": \"https://api.whatsapp.com/send/?phone=xxxxxx\" }, { \"id\": 181, \"value\": false } ] }")
                .post()
                .then()
                .statusCode(200);


    }

    @And("user accept cookies IN GM")
    public void accept_cookieINGN() throws InterruptedException {
        Thread.sleep(3000);
        login.accept_cookie().click();
    }

    @When("user enter invalid email IN GM\"(.*)\"$")
    public void enterEmailINGN(String email) throws IOException, InterruptedException {
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



    @And("user enter invalid password IN GM\"(.*)\"$")
    public void enterPasswordINGN(String password) {
        login.password().sendKeys(password);
    }

    @And("user click on login IN GN")
    public void clickLoginButtonInGN() {
        login.loginButton().click();
    }
    @And ("user click on profile IN GN")
    public void clickaccountbuttonINGN() throws InterruptedException {
        Thread.sleep(2000);
        home.profile().click();
    }
    @Then("user could validate that password required IN GN")
    public void passwordvalidateGN() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "Password is required";
        String actualResult = login.passwordValidation().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Then("user could validate that email required IN GN")
    public void EmailvalidateGN() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "Email is required";
        String actualResult = login.emailValidation().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Then("user could validate that email IN GN")
    public void Wrongemail() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = " Email is not valid";
        String actualResult = login.wrongEmail().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Then("user could validate that password lenght IN GN")
    public void passwordlenghtGN() throws InterruptedException {

        Thread.sleep(2000);
        String expectedResult = "Password isn't long enough, minimum of 8 characters";
        String actualResult = login.wrongpasswordLenght().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }


}
