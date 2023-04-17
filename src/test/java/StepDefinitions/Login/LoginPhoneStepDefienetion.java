
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


public class LoginPhoneStepDefienetion   {


    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);

    String nphone;

    @Given("user to login page PH")
    public void openLoginPagePH() throws InterruptedException {

        Thread.sleep(3000);
        home.login().click();
        openPhone();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    public static void openPhone() {
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
                .body("{ \"configs\": [ { \"id\": 359, \"value\": \"https://api.whatsapp.com/send/?phone=xxxxxx\" }, { \"id\": 181, \"value\": true } ] }")
                .post()
                .then()
                .statusCode(200);


    }

    @And("user accept cookies PH")
    public void accept_cookiePH() throws InterruptedException {
        Thread.sleep(3000);
        login.accept_cookie().click();
    }

    @When("user enter valid Phone PH\"(.*)\"$")
    public void enterEmailPH(String phonenumber) throws IOException, InterruptedException {
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

    @And("user enter valid password PH\"(.*)\"$")
    public void enterPassworPH(String password) {
        login.password().sendKeys(password);
    }

    @And("user click on login PH")
    public void clickLoginButtonPH() {
        login.loginButton().click();
    }

    @And("user click on profile PH")
    public void clickaccountbuttonPH() throws InterruptedException {
        Thread.sleep(2000);
        home.profile().click();
    }

    @Then("user could login successfully and redirected to home page PH")
    public void successLoginPH() throws InterruptedException {
        Thread.sleep(2000);
        String expectedResult = "Profile information";
        String actualResult = home.profile_name().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
