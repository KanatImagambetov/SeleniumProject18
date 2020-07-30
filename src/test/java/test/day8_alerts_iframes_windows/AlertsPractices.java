package test.day8_alerts_iframes_windows;

import utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
@Test
    public void p1(){
        //Locating the alert button to be able to click.
        WebElement infoAlertButton=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        //Clicking to the alert button so that the alert should pop-up
        infoAlertButton.click();
        //1- Create the Alert instance and switch to it
        Alert alert=driver.switchTo().alert();
        //2- Use "alert" to accept the alert.
        alert.accept();
    //locating result web element
        WebElement resultText=driver.findElement(By.id("result"));
    //WebElement resultText2 = driver.findElement(By.id("result"));
    //Asserting the result text is displayed
    Assert.assertTrue(resultText.isDisplayed());
     }
     @Test
     public void p2(){
//        WebElement confirmation=driver.findElement(By.xpath("//button[.='Click for JS Confirm']");
      WebElement confirmation = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));        confirmation.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
         //locating result web element
         WebElement result=driver.findElement(By.xpath("//p[@id='result']"));
         //WebElement resultText2 = driver.findElement(By.id("result"));
         //Asserting the result text is displayed
         Assert.assertTrue(result.isDisplayed());
     }
}

