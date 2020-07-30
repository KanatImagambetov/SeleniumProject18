package test.day9_testbase_properties_driverUtil;

import utilities.ConfigurationReader;
import utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DriverUtilPractice {
    @Test
    public void  driver_practice(){
        Driver.getDriver().get("https://www.google.com");
        WebElement googleSearch=Driver.getDriver().findElement(By.name("q"));

        googleSearch.sendKeys(ConfigurationReader.getProperty("testdata")+ Keys.ENTER);


    }
    @Test
    public void singleton_practice(){
        String str1=Singleton.getWord();
        System.out.println("Str1= "+str1);
        String str2=Singleton.getWord();
        System.out.println("Str2= "+str2);
        String str3=Singleton.getWord();
        System.out.println("Str3= "+str3);
    }
    @Test
    public void singleton_practice2(){
        String str4=Singleton.getWord();
        System.out.println("Str4= "+str4);

    }
}

