package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.Scanner;

public class LoginPage {

    WebDriver driver = null;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
//
    public WebElement accept_cookie()
    {
        return driver.findElement(By.xpath("//*[@id=\"cookieNotice\"]/div[3]/div/div/button"));
    }
    public class ClearTextFile2 {
        public void main(String[] args) {
            // Replace "path/to/file.txt" with the actual path to your text file
            String filePath = "/home/amr/Downloads/hotfix_final/fileName2.txt";

            try {
                PrintWriter writer = new PrintWriter(new FileWriter(filePath, false));
                writer.print("");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public class ClearTextFile1 {
        public void main(String[] args) {
            // Replace "path/to/file.txt" with the actual path to your text file
            String filePath = "/home/amr/Downloads/hotfix_final/fileName.txt";

            try {
                PrintWriter writer = new PrintWriter(new FileWriter(filePath, false));
                writer.print("");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void userName() throws FileNotFoundException {

        File emailFile = new File("fileName2.txt");
        Scanner emailScanner = new Scanner(emailFile);
        String email = emailScanner.nextLine();
        emailScanner.close();

// Read phone from phone.txt
        File phoneFile = new File("fileName.txt");
        Scanner phoneScanner = new Scanner(phoneFile);
        String phone = phoneScanner.nextLine();
        phoneScanner.close();

// Find the element that determines whether to send email or phone
        WebElement user_name = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/input"));


            if (user_name.isDisplayed()) {
                try {
                WebElement phoneInput = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/span[2]/label"));

                    if (phoneInput.isDisplayed()) {
                        // Element is displayed, send phone number
                        user_name.sendKeys(phone);}
                    } catch (Exception e) {
                    user_name.click();
                    user_name.sendKeys(email);
                    }
                    }else {   WebElement emailInput = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/span/label/span"));
                emailInput.sendKeys(email);
                    }
//
//            } else {
//                // Element is not displayed, send email address
//               WebElement emailInput = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/span/label/span"));
//                user_name.click();
//
//                user_name.sendKeys(email);
//            }



    }
//    public void phone_user()
//    {
//        WebElement user_name=  driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[1]/div/input"));
//        StringBuilder data = new StringBuilder();
//        try (BufferedReader br = new BufferedReader(new FileReader("/home/amr/Downloads/hotfix_final/fileName.txt"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                data.append(line).append("\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String dataString = data.toString();
//        System.out.println(dataString);
//
//        user_name.sendKeys(dataString);
//
//
//    }

    public WebElement password()
    {
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[2]/mat-form-field/div/div[1]/div[1]/input"));
    }

    public WebElement loginButton()
    {
        return driver.findElement(By.xpath("//*[@id=\"en\"]/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/button"));
    }

    public WebElement forgotPassword()
    {
        return driver.findElement(By.xpath("//*[@id=\"en\"]/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[3]/a"));
    }
    public WebElement emailValidation(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[3]/div/mat-error"));
    }
    public WebElement passwordValidation(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[2]/mat-form-field/div/div[3]/div/mat-error"));
    }
    public WebElement wrongpasswordLenght(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[2]/mat-form-field/div/div[3]/div/mat-error"));
    }
    public WebElement wrongEmail(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[3]/div/mat-error"));
    }
    public WebElement phonelenght(){
            return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[3]/div"));
    }
    public WebElement validationphone(){
        return driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div/signin/div/div/div/div/div/div[2]/mat-card/embryo-signin/form/div[1]/mat-form-field/div/div[3]/div/mat-error"));
    }
}
