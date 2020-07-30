package test.day11_page_object_model;

import utilities.ConfigurationReader;
import utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;

public class NegativeLoginTest {
    LoginPage loginpage;
    @Ignore
    @Test
    public void negativeLogin(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        WebElement username=Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement password=Driver.getDriver().findElement(By.id("prependedInput2"));

        WebElement button=Driver.getDriver().findElement(By.id("_submit"));

        String username1=ConfigurationReader.getProperty("storemanager_username");
        username.sendKeys(username1);

       // String password1=ConfigurationReader.getProperty("storemanager_password");
       // password.sendKeys(password1);
        password.sendKeys("dfdfsdsd");

        button.click();
        WebElement errorM=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(errorM.isDisplayed(),"Assert message is Not displayed");
    }
    @Test
    public void negativeLogin2(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        LoginPage loginpage=new LoginPage();
        String username1=ConfigurationReader.getProperty("storemanager_username");
        loginpage.username.sendKeys(username1);
        loginpage.password.sendKeys("jkklppp");
        loginpage.button.click();
        Assert.assertTrue(loginpage.errorM.isDisplayed());
        String actualText=loginpage.errorM.getText();
        String expected="Invalid user name or password.";
        Assert.assertEquals(actualText,expected);
    }
    @Ignore
    @Test
    public void tc31_wrong_username(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginpage=new LoginPage();

        String username1="sdssasas";
        String password1=ConfigurationReader.getProperty("storemanager_password");

        loginpage.login(username1,password1);

        String actualText=loginpage.errorM.getText();
        String expected="Invalid user name or password.";
        Assert.assertEquals(actualText,expected);
    }

    @Test
    public void tc32_positive_username(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginpage=new LoginPage();

        String username1=ConfigurationReader.getProperty("storemanager_username");
        String password1=ConfigurationReader.getProperty("storemanager_password");

        loginpage.login(username1,password1);

      //  String actualText=loginpage.errorM.getText();
      //  String expected="Invalid user name or password.";
      //  Assert.assertEquals(actualText,expected);
    }
}
