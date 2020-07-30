package test.day10_jsexecutor_upload_actions;

import utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTests {
    @Test
    public void hover() throws InterruptedException{
        Driver.getDriver().get("https://www.amazon.com");
        //1- Create the instance of Actions class
        //2- Pass the current driver instance
        Actions actions=new Actions(Driver.getDriver());
        //3- Locate the web element to hover over
        WebElement lang=Driver.getDriver().findElement(By.id("icp-nav-flyout"));
        //4- Using actions, hover over to the Language options

        Thread.sleep(3000);
        actions.moveToElement(lang).perform();
        //actions.perform();

    }
    @Test
    public void tc15() throws InterruptedException{
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        WebElement img1=Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]"));
        WebElement img2=Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]"));
        WebElement img3=Driver.getDriver().findElement(By.xpath("//div[@class='figure'][3]"));

        WebElement us1=Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement us2=Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement us3=Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        Actions actions=new Actions(Driver.getDriver());

        actions.moveToElement(img1).perform();
        Assert.assertTrue(us1.isDisplayed());

        Thread.sleep(2000);

        actions.moveToElement(img2).perform();
        Assert.assertTrue(us2.isDisplayed());

        Thread.sleep(2000);

        actions.moveToElement(img3).perform();
        Assert.assertTrue(us3.isDisplayed());
    }

}
