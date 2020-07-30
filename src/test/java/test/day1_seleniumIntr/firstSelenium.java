package test.day1_seleniumIntr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstSelenium {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
//        WebDriver driver1=new ChromeDriver();
//        WebDriver driver2=new ChromeDriver();

        driver.get("https://www.google.com");
 //       driver1.get("https://www.amazon.com");
 //       driver2.get("https://www.apple.com");
        System.out.println("Driver.getTitle()--> "+driver.getTitle());
        System.out.println("Driver.getCurrentUrl()--> "+driver.getCurrentUrl());

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        Thread.sleep(2000);
        driver.navigate().refresh();
//        System.out.println(driver.getTitle());

        driver.navigate().to("https://www.facebook.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

      //  System.out.println(driver.getPageSource());
        driver.manage().window().maximize();

        Thread.sleep(3000);
        driver.close();
    }
}
