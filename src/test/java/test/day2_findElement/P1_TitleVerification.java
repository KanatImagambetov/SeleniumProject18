package test.day2_findElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_TitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

        driver.findElement(By.name("search_query")).sendKeys("wooden spoon");

        driver.findElement(By.className("wt-input-btn-group__btn")).click();

        String actualTitle=driver.getTitle();
        System.out.println(driver.getTitle());
        String expectTitle="Wooden spoon | Etsy";

        if(actualTitle.startsWith(expectTitle)){
            System.out.println("Etsy title verification PASSED!");
        }else{
            System.out.println("Etsy title verificsation FAILED");
        }


    }
}
