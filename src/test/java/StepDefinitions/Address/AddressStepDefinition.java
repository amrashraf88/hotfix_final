package StepDefinitions.Address;

import POM.AddressPage;
import POM.HomePage;
import POM.LoginPage;
import POM.PointPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;

import java.io.FileNotFoundException;

import static StepDefinitions.Home.Hooks.driver;

public class AddressStepDefinition {
    HomePage home = new HomePage(driver);

    LoginPage login = new LoginPage(driver);
    PointPage point = new PointPage(driver);
    AddressPage address = new AddressPage(driver);
    @Given("user login for address")
    public void loginforaddress() throws InterruptedException, FileNotFoundException {
        Thread.sleep(2000);
        home.login().click();
        Thread.sleep(2000);
        login.userName();
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }
    @Then("user navigate to profile")
    public void profile() throws InterruptedException {
        Thread.sleep(2000);
        home.profile().click();
    }
    @And("user navigate to address page")
    public void address_page() throws InterruptedException {
        Thread.sleep(2000);
        address.address_page().click();
    }
    @And("user add fill all field")
    public void create_address() throws InterruptedException {
  address.add_address_button().click();
        Thread.sleep(2000);

            if (address.address_street()!=null){
                address.address_street().click();
                address.address_street().sendKeys("aaa");
            }else {
                System.out.println("sdd");
            }

            if (address.Government_addrss()!=null){
                address.Government_addrss().click();
                Thread.sleep(1000);
                address.select_GOv().sendKeys(Keys.ENTER);
                Thread.sleep(2000);
            }else{
                System.out.println("555");
            }
            if (address.City()!=null){
                    System.out.println("hhhhhhhhh");
                address.City().click();
                Thread.sleep(1000);
                address.select_city().sendKeys(Keys.ENTER);
            }else{
                System.out.println("66");

            }
            if (address.Appartment() !=null){
                address.Appartment().click();
                address.Appartment().sendKeys("ass");
            }else {
                System.out.println("no appartment");
            }
            if (address.Building() !=null){
                address.Building().click();
                address.Building().sendKeys("ssss");
            }else {
                System.out.println("building no found ");
            }
            if (address.floor() !=null){
                address.floor().click();
                Thread.sleep(1000);
                address.floor().sendKeys("s");
            }else {
                System.out.println("floor not found");
            }
            if (address.save_address() !=null){
                address.save_address().click();
            }else {
                System.out.println("عيط");
            }
            }
}
