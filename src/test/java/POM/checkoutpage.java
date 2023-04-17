package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutpage {
    WebDriver driver = null;

    public checkoutpage(WebDriver driver)
    {
        this.driver = driver;
    }
    public WebElement  Continue_as_guest ()
    {
        return driver.findElement(By.xpath("//*[@id=\"en\"]/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/div/div[1]/div/button[2]"));
    }
    public WebElement   Register  ()
    {
        return driver.findElement(By.xpath("//*[@id=\"en\"]/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/div/div[1]/div/button[1]"));
    }
    public WebElement   login_from_checkout  ()
    {
        return driver.findElement(By.xpath("//*[@id=\"en\"]/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/div/div[2]/div/button"));
    }
    public WebElement first_name_guest(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[1]/div/div/div/div[1]/div/mat-form-field[1]/div/div[1]/div/input"));

    }
    public  WebElement last_name_guest()
    {
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[1]/div/div/div/div[1]/div/mat-form-field[2]/div/div[1]/div/input"));

    }
    public  WebElement email_guest(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[1]/div/div/div/div[1]/div/mat-form-field[3]/div/div[1]/div/input"));
    }
    public WebElement phone_guest(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[1]/div/div/div/div[1]/div/mat-form-field[4]/div/div[1]/div/input"));
    }
    public  WebElement containue_to_store_details(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[1]/div/div/div/div[2]/button"));
    }
    public WebElement crest_address(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[2]/div/div/div[1]/div/div/div/div"));
    }
    public WebElement address_street(){
        return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[2]/mat-form-field/div/div[1]/div/input"));
    }
    public WebElement building(){
        return driver.findElement(By.xpath("//*[@id=\"mat-input-19\"]"));
    }
    public WebElement save_address(){
        return driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-address/div[2]/form/div/div[9]/button"));
    }

    public WebElement store_adrress(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[2]/div/div/div/div[1]/div"));
    }

    public WebElement continue_pyment(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[2]/div/div/div/div[2]/button"));
    }
    public WebElement choose_payment(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[3]/div/div/div/div[1]/div/div/div/mat-radio-group/mat-radio-button/label/span[2]/span[3]"));
    }
    public WebElement agree_team_condetion(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[3]/div/div/div/div[5]/mat-checkbox/label"));
    }
    public WebElement deleviry_time(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[3]/div/div/div/div[3]/div/mat-card[1]/mat-card-content/span"));
    }
    public WebElement place_order(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-payment/div/div/div/div/div/div[1]/mat-accordion/form/mat-expansion-panel[3]/div/div/div/div[6]/button"));
    }

    public WebElement register_from_checkout(){
        return driver.findElement(By.xpath("//*[@id=\"en\"]/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/div/div[1]/div/button[1]"));
    }
    public WebElement login1_from_checkout(){
        return driver.findElement(By.xpath("//*[@id=\"en\"]/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-payment/div/div/div/div/div/div[1]/div/div[2]/div/button"));
    }
    public WebElement  getOrderMessage(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/app-finalreceipt/div/div/div/div/div/div/div/mat-card/div[1]/div[1]/h5"));
    }
}
