package test.day10_jsexecutor_upload_actions;

import utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Uploading {
    @Test
    public void uploading() throws InterruptedException{
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        WebElement choose=Driver.getDriver().findElement(By.id("file-upload"));
        Thread.sleep(2000);

        choose.sendKeys("C:/Users/kanat/OneDrive/Desktop/test.txt");
        WebElement upload=Driver.getDriver().findElement(By.id("file-submit"));
        upload.click();

        WebElement uploadedMessage = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));

        Assert.assertTrue(uploadedMessage.isDisplayed());
    }
}
