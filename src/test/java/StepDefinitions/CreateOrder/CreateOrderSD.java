package StepDefinitions.CreateOrder;

import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static StepDefinitions.Home.Hooks.driver;

public class CreateOrderSD {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    CategoryPage category = new CategoryPage(driver);
    checkoutpage checkout = new checkoutpage(driver);
    CartPage cart = new CartPage(driver);
  //  WebDriverWait wait = new WebDriverWait(driver, 30); // Wait up to 30 seconds


    @And("user choose any category")
    public void selectproduct() throws InterruptedException {
        Thread.sleep(6000);

        driver.navigate().to("https://shop.witheldokan.com/en/products/IMPEX-GLORIA-SMART-LED-TV-40-/47027?variant=47028");
    }

    @And("user add any product to cart")
    public void addToCart() throws InterruptedException {
        Thread.sleep(6000);
        category.addToCartButton().click();

    }

    @And("user open cart page")
    public void openCartPage()
    {
        home.cartPageButton().click();
    }


    @And("user click on checkout")
    public void clickOnCheckout() throws InterruptedException {
        Thread.sleep(3000);
        cart.checkoutButton().click();
    }

    @And("user choose which way he went to checkout")
    public void choose_way() throws InterruptedException {
        Thread.sleep(2000);
        checkout.Continue_as_guest().click();
    }
    @And("user add data")
    public void add_data_guest() throws InterruptedException {
        Thread.sleep(3000);

        checkout.first_name_guest().click();
        checkout.first_name_guest().sendKeys("as");
        checkout.last_name_guest().click();
        checkout.last_name_guest().sendKeys("sa");
        checkout.email_guest().click();
        checkout.email_guest().sendKeys("sa@as.cc");
        checkout.phone_guest().click();
        checkout.phone_guest().sendKeys("251215325");
        checkout.containue_to_store_details().click();
    }
    @And("user edit billing address")
    public void addBillingAddress() throws InterruptedException {
        Thread.sleep(4000);
        try {
            WebElement store = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[2]/div/div/div/div[1]/div"));

            if (store.isDisplayed()) {
                checkout.store_adrress().click();
            } else {
                System.out.println("no element");
            }
        }catch (Exception e) {

            checkout.crest_address().click();
            Thread.sleep(2000);
            checkout.address_street().click();
            checkout.address_street().sendKeys("test");
            //  checkout.building().click();
            // checkout.building().sendKeys("test");

            WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[3]/mat-form-field/div/div[1]/div/mat-select/div/div[1]/span"));
            if (element.isDisplayed()) {

                element.click();
                WebElement Governorate = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div/div/mat-option"));
                Governorate.click();
            } else {
                System.out.println("Element is not displayed");
            }

            WebElement city = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[4]/mat-form-field/div/div[1]/div/mat-select/div/div[1]/span"));
            if (city.isDisplayed()) {
                city.click();

            } else {
                System.out.println("Element is not displayed");

            }
            Thread.sleep(1000);
            WebElement city_appear = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div"));

            if (city_appear.isDisplayed()) {
                WebElement city_selected = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div/div/mat-option[2]/span"));

                city_selected.click();

            } else {
                System.out.println("Element is not displayed");

            }
            checkout.save_address().click();
        }

    }
  /*  @And("user add address")
    public void add_address_guest() throws InterruptedException {

    }*/




    @And("user choose payment method")
    public void selectPaymentMethod() throws InterruptedException {
        Thread.sleep(1000);
        checkout.continue_pyment().click();
    }

    @And("user check payment information")
    public void checkPaymentInformation() throws InterruptedException {
        Thread.sleep(3000);
        checkout.choose_payment().click();
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(0,500)");


    }

    @And("user agree terms and conditions")
    public void agreeTermsANDConditions() throws InterruptedException {JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
      //  checkout.deleviry_time().click();
        checkout.agree_team_condetion().click();
    }

    @And("user confirm order")
    public void clickConfirmOrder()
    {
        checkout.place_order().click();
    }

    @Then("order should be placed successfully")
    public void checkOrderIsPlaced() throws InterruptedException {
        Thread.sleep(2000);
        String expectedResult = "Thank you for shopping with us";
        String actualResult = checkout.getOrderMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
