package POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class InventoryPage {
    WebDriver driver = null;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement inventoryWindow(){
        return driver.findElement(By.xpath("/html/body/app-root/div[2]/div"));
    }
    public WebElement MapInventory(){
        return driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[1]"));
    }
    public WebElement StoreInventory(){
        return driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[1]"));
    }
    public WebElement closebutton(){
        return driver.findElement(By.xpath("/html/body/app-root/div[2]/div/mat-icon"));
    }
    public WebElement SelectStore(){
        return driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[2]"));
    }
    public WebElement currentLocation(){
        return driver.findElement(By.xpath("/html/body/app-root/div[2]/app-multi-invintory-area/div/div/div[1]/div/mat-icon"));
    }
public WebElement storeSave(){
        return driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[3]/button"));
}
public  WebElement mapSave(){
        return driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[3]/button"));
}
public WebElement invventory_icon(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/headertwo/mat-toolbar/mat-toolbar-row[2]/div/div/div[3]/div[1]/span[2]/app-source-icons/div/button/span[1]/mat-icon"));
}
public WebElement zoom_button(){
        return driver.findElement(By.xpath("/html/body/app-root/div[2]/app-multi-invintory-area/div/div/div[2]/agm-map/div[1]/div/div/div[13]/div/div[2]/div/button[1]"));
}
public WebElement inventory_page(){
        return driver.findElement(By.xpath("/html/body/app-root/div[2]/div"));

}


}
