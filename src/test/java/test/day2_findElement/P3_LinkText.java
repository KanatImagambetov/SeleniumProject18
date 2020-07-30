package test.day2_findElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_LinkText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Gmail")).click();

        String actualGmailTitle=driver.getTitle();
        String expectedInTitle="Gmail";

        if(actualGmailTitle.contains(expectedInTitle)){
            System.out.println("Gmail title verificantion passed!");
        }else{
            System.out.println("Gmail title verificantion failed!");
        }

        driver.navigate().back();

        String actualGoogleTitle=driver.getTitle();
        String expectedInTitle1="Google";

        if(actualGoogleTitle.contains(expectedInTitle1)){
            System.out.println("Google page title verificantion passed!");
        }else{
            System.out.println("Google page title verificantion failed!");
        }



    }
}
