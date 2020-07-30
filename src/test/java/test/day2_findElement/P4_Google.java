package test.day2_findElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_Google {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
//        driver.findElement(By.name("q")).sendKeys("apple");
        driver.findElement(By.name("q")).sendKeys("apple");

        //Thread.sleep(1000);

        //4- Click google search button
//        driver.findElement(By.linkText("Google Search")).click();
        driver.findElement(By.name("btnK")).click();

        String actualTitle=driver.getTitle();
        String expectTitle="apple";
        if(actualTitle.startsWith(expectTitle)){
            System.out.println("Google search title verification PASSED!");
        }else{
            System.out.println("Google search title verificsation FAILED");
        }
    }
}
