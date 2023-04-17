package StepDefinitions.Inventory;

import POM.HomePage;
import POM.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static StepDefinitions.Home.Hooks.driver;

public class InventoryStepDefinition {
    HomePage home = new HomePage(driver);
    InventoryPage inventory = new InventoryPage(driver);


    @Given("user select pickup")
    public void Select_store() throws InterruptedException {
        Thread.sleep(3000);
        inventory.invventory_icon().click();
        Thread.sleep(1000);
        inventory.SelectStore().click();
    }
    @And("user select store")
    public void  select_from_stores() throws InterruptedException {
        Thread.sleep(2000);
        inventory.StoreInventory().click();
    }
    @And("user save store")
    public void  save_store(){
        inventory.storeSave().click();
    }
    @And("user click in inventory")
    public void click_on_inventory() throws InterruptedException {
        Thread.sleep(1000);
        inventory.invventory_icon().click();
    }
    @And("user choose map")
    public void choose_map(){
        inventory.MapInventory().click();
    }
    @And("user choose current locaion")
    public void current_location() throws InterruptedException {
        inventory.currentLocation().click();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);

         WebElement element = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-multi-invintory-area/div/div/div[2]/agm-map/div[1]/div/div/div[2]"));
        actions.moveToElement(element,50,100).perform();
        actions.moveToElement(element).clickAndHold().moveByOffset(300, 0).release().perform();
    }
    @Then("user save his current location")
    public void save_map() throws InterruptedException {
        Thread.sleep(2000);
        inventory.zoom_button().click();
        inventory.zoom_button().click();
        inventory.zoom_button().click();
        inventory.zoom_button().click();
        inventory.zoom_button().click();
        inventory.zoom_button().click();
        Thread.sleep(6000);

        inventory.mapSave().click();
    }
}
