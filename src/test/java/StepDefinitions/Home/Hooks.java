package StepDefinitions.Home;

import POM.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver = null;
Api api = new Api();
    @Before
	public void openBrowser() throws InterruptedException {

        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to("https://shop.witheldokan.com");
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));


//        try {
//            // Wait for up to 10 seconds for the element to be present and visible
//            WebElement element = new WebDriverWait(driver, Duration.ofMillis(10))
//                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[2]")));
//            // If the element is present and visible, check if it's enabled and enter some text
//            if (element.isEnabled()) {
//                WebElement selectstore = driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[2]"));
//                selectstore.click();
//          Thread.sleep(2000);
//                WebElement select_inventory_store = driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[1]"));
//                select_inventory_store.click();
//          Thread.sleep(2000);
//                WebElement save_store = driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[3]/button"));
//                save_store.click();
//        //  inventory.storeSave().click();
//            } else {
//                System.out.println("Element is not enabled");
//            }
//        } catch (NoSuchElementException | TimeoutException e) {
//            System.out.println("Element not found or timed out");
//        }

    }
    

//    @After
//    public static void closeBrowser()
//    {
//        try{
//            Thread.sleep(2000);
//            driver.quit();
//        }catch (NullPointerException e) {
//            System.out.println("NullPointerException Thrown!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
