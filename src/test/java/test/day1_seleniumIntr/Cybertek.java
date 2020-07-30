package test.day1_seleniumIntr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cybertek {
    public static void main(String[] args) {
        //o	https://practice.cybertekschool.com
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");

        String actualTitle=driver.getTitle().toLowerCase();
        String expect="practice";
        System.out.println(driver.getTitle());

        if(actualTitle.equals(expect)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectUrl="cybertekschool";
        System.out.println(driver.getCurrentUrl());

        if(actualUrl.equals(expectUrl)){
            System.out.println("Url verification PASSED!");
        }else{
            System.out.println("Url verification FAILED");
        }
        driver.close();
    }
}
