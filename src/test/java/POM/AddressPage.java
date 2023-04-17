package POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddressPage {
    WebDriver driver = null;
    Actions action;
    Faker faker = new Faker();
    InventoryPage inventory = new InventoryPage(driver);
    String nphone;
    //Constructor
    public AddressPage(WebDriver driver)
    {
        this.driver = driver;
        action = new Actions(driver);
    }
    public WebElement address_page(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-account/div/div/div/div/div[2]/div[1]/mat-list/mat-list-item[3]/div/a/span"));
    }
    public WebElement add_address_button(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-account/div/div/div/div/div[2]/div[2]/div/app-address/mat-card/div[1]/button"));
    }
public WebElement save_address(){
        try {
            return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[11]/button"));
        }catch (Exception e){
            return null;
        }
        }
public WebElement edit_address(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-account/div/div/div/div/div[2]/div[2]/div/app-address/mat-card/div[2]/div/div/button[1]"));
}
public WebElement delete_address(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-account/div/div/div/div/div[2]/div[2]/div/app-address/mat-card/div[2]/div/div/button[2]"));
}
public WebElement address_street() {
        try {
            return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[2]/mat-form-field/div/div[1]/div/input"));

        }catch (Exception e){
            return null;
        }
}
public WebElement Government_addrss(){
        try {
            return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[3]/mat-form-field/div/div[1]/div/mat-select/div/div[1]/span"));
        }catch (Exception e){
            return null;
        }
        }
public WebElement select_GOv(){
        try {
            return driver.findElement(By.id("mat-option-4"));
        }
        catch (Exception e){
            return null;
        }
}
public WebElement City(){
        try {
            return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[4]/mat-form-field/div/div[1]/div/mat-select/div/div[1]/span"));
        }
        catch (Exception e){
            return null;
        }
        }
public WebElement select_city(){
        try {
            return driver.findElement(By.id("mat-option-5"));
        }catch (Exception e){
            return null ;
        }
}
public WebElement Appartment(){
        try {
            return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[5]/mat-form-field/div/div[1]/div/input"));
        }catch (Exception e){
            return null;
        }
}
public WebElement Building() {
    try {
        return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[6]/mat-form-field/div/div[1]/div/input"));
    } catch (Exception e) {
        return null;
    }
}
public WebElement floor(){
        try {
            return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[7]/mat-form-field/div/div[1]/div/input"));
        }catch (Exception e){
            return null;
        }
        }
 public WebElement landmark(){
        try {
            return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[8]/mat-form-field/div/div[1]/div"));
        }catch (Exception e ){
            return null;
        }
        }
 public WebElement setdefoult(){
        return driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[8]/mat-form-field/div/div[1]/div/input"));
 }
public WebElement close_button_address(){
        return driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/app-add-address/div[1]/button"));
}

}
