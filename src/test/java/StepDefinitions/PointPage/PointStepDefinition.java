package StepDefinitions.PointPage;

import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.*;

import static StepDefinitions.Home.Hooks.driver;


public class PointStepDefinition {


    HomePage home = new HomePage(driver);

    LoginPage login = new LoginPage(driver);
    PointPage point = new PointPage(driver);

    @Given("user navigate to openpointpagforuser page")
    public void openpointpagforuser() throws InterruptedException, FileNotFoundException {
        //home.c();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
//        try {
//            // Wait for up to 10 seconds for the element to be present and visible
//            WebElement element = new WebDriverWait(driver, Duration.ofMillis(10))
//                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[2]")));
//
//         // If the element is present an887isible, check if it's enabled and enter some text
//            if (element.isEnabled()) {
//                inventory.SelectStore().click();
//          Thread.sleep(2000);                 ---/*/*/*
//          inventory.StoreInventory().click();
//          Thread.sleep(3000);
//          inventory.storeSave().click();
//            } else {
//                System.out.println("Element is not enabled");
//            }
//        } catch (NoSuchElementException | TimeoutException e) {
//            System.out.println("Element not found or timed out");
//        }
//         WebElement eleinvetort_pagement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[2]")));
//      if(invetort_page.isDisplayed()){
//          inventory.SelectStore().click();
//          Thread.sleep(2000);
//          inventory.StoreInventory().click();
//          Thread.sleep(3000);
//          inventory.storeSave().click();
//        }
//      else {
//          System.out.println("no");
//      }
        Thread.sleep(3000);
    	home.login().click();
        Thread.sleep(2000);
        login.userName();
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }




    @When("user navigate to point")
    public void pintpage() throws InterruptedException {
        Thread.sleep(2000);
        home.point().click();
    }

    @And("user check voucher")
    public void voucher_point() throws InterruptedException {
        Thread.sleep(2000);
        point.yourvoucher().click();
        String url = driver.getCurrentUrl();
        String expectedResult = "https://shop.witheldokan.com/en/account/vouchers";
        Assert.assertTrue((url.contains(expectedResult)));
        
        System.out.println("url");
    }





//	@Override
//	void openRegistrationPage() {
//		// TODO Auto-generated method stub	home.login().click();
//    	try {
//			Thread.sleep(9000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        home.register().click();
//	}



}
