package test.day8_alerts_iframes_windows;

import utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsTabsPractice {
WebDriver driver;
@BeforeMethod
    public void setUp(){
    driver= WebDriverFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/windows");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test
    public void p5(){
    String currentWindow=driver.getWindowHandle();
    System.out.println("currentWindowHandle = "+currentWindow);
    WebElement click=driver.findElement(By.xpath("//a[.='Click Here']"));
    System.out.println("BEFORE CLICKING: "+driver.getTitle());
    click.click();
    System.out.println("AFTER CLICKING: "+driver.getTitle());
    //driver.getWindowHandles() --> returns us A SET of Strings
    Set<String> windows=driver.getWindowHandles();
    for (String each:windows){
        driver.switchTo().window(each);
        System.out.println(driver.getTitle());
    }
    driver.switchTo().window(currentWindow);
    System.out.println(driver.getTitle());
}
}
