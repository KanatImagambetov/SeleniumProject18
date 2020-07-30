package test.day1_seleniumIntr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_Google {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String actualTitle=driver.getTitle();

        String expect="Google";

        if(actualTitle.equals(expect)){
            System.out.println("Google title verification PASSED!");
        }else{
            System.out.println("Google title verification FAILED");
        }

        driver.close();
    }
}
