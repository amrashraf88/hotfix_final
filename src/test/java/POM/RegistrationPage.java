package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class RegistrationPage {
	WebDriver driver = null;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement firstName() {
		return driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]"));
	}

	public WebElement lastName() {
		return driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]"));
	}

	public WebElement email() {
		return driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]"));
	}

	public WebElement phone() {
		return driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]"));
		
	}

	public WebElement password() {
		return driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]"));
	}

	public WebElement confirmPassword() {
		return driver.findElement(By.xpath("//*[@id=\"mat-input-9\"]"));
	}

	public WebElement registerButton() {
		return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div[1]/embryo-register/div/div/div/div/div/div[2]/mat-card/form/button"));
	}
	public WebElement firstNameValidation(){
		return driver.findElement(By.xpath("//div[@class=\"ng-tns-c74-26 ng-trigger ng-trigger-transitionMessages ng-star-inserted\"]"));
	}

	public WebElement lastNameValidation(){
		return driver.findElement(By.xpath("//div[@class=\"ng-tns-c74-27 ng-trigger ng-trigger-transitionMessages ng-star-inserted\"]"));
	}
	public WebElement emailValidation(){
		return driver.findElement(By.xpath("//div[@class=\"ng-tns-c74-28 ng-trigger ng-trigger-transitionMessages ng-star-inserted\"]"));
	}
	public WebElement phoneValidation(){
		return driver.findElement(By.xpath("//div[@class=\"ng-tns-c74-29 ng-trigger ng-trigger-transitionMessages ng-star-inserted\"]"));
	}
	public WebElement passwordValidation(){
		return driver.findElement(By.xpath("//div[@class=\"ng-tns-c74-31 ng-trigger ng-trigger-transitionMessages ng-star-inserted\"]"));
	}
	public WebElement confirmPasswordValidation(){
		return driver.findElement(By.xpath("//div[@class=\"ng-tns-c74-32 ng-trigger ng-trigger-transitionMessages ng-star-inserted\"]"));
	}
	public WebElement checkemail(){
		return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/embryo-register/div/div/div/div/div/div[2]/mat-card/form/div[1]/mat-form-field[3]/div/div[3]/div/mat-error"));

	}
	public WebElement checkphone(){
		return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/embryo-register/div/div/div/div/div/div[2]/mat-card/form/div[1]/mat-form-field[4]/div/div[3]/div/mat-error"));
	}

}
