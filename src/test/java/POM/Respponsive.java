package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static StepDefinitions.Home.Hooks.driver;

public class Respponsive {
    LoginPage login=new LoginPage(driver);
    public void mobileresponsive() throws InterruptedException {
        // Switch to mobile responsive view
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver.quit();

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to("https://shop.witheldokan.com");
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        try {
            // Wait for up to 10 seconds for the element to be present and visible
            WebElement element = new WebDriverWait(driver, Duration.ofMillis(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[2]")));
            Thread.sleep(2000);
            login.accept_cookie().click();

            // If the element is present and visible, check if it's enabled and enter some text
            if (element.isEnabled()) {
                WebElement selectstore = driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[2]"));
                selectstore.click();
                Thread.sleep(2000);
                WebElement select_inventory_store = driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[2]/div[1]"));
                select_inventory_store.click();
                Thread.sleep(2000);
                WebElement save_store = driver.findElement(By.xpath("/html/body/app-root/div[2]/div/div[3]/button"));
                save_store.click();
                //  inventory.storeSave().click();
            } else {
                System.out.println("Element is not enabled");
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Element not found or timed out");
        }

        // Run test case in mobile responsive view
        // ...


    }
}
