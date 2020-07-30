package test.day11_page_object_model;

import utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class ActionsPracticesWithPAgeObj {

    @Test
    public void tc15() throws InterruptedException{
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        HoversPage hoversPage=new HoversPage();

        Actions actions=new Actions(Driver.getDriver());

        Thread.sleep(3000);

        actions.moveToElement(hoversPage.img1).perform();
        Assert.assertTrue(hoversPage.user1.isDisplayed());
        Thread.sleep(3000);

        actions.moveToElement(hoversPage.img2).perform();
        Assert.assertTrue(hoversPage.user2.isDisplayed());
        Thread.sleep(3000);

        actions.moveToElement(hoversPage.img3).perform();
        Assert.assertTrue(hoversPage.user3.isDisplayed());
    }
}
