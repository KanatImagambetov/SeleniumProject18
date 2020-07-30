package test.day11_page_object_model;

import utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {
    Actions actions;
    @Test
    public void scrolling_with_actions() throws InterruptedException{
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        Actions action=new Actions(Driver.getDriver());

        WebElement cybertekSL=Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement inputs=Driver.getDriver().findElement(By.linkText("Inputs"));

        Thread.sleep(2000);
        action.moveToElement(cybertekSL).perform();
        Thread.sleep(2000);
        action.moveToElement(inputs).click().perform();

    }
    @Test
    public void tc16(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement text=Driver.getDriver().findElement(By.id("demo"));
        actions=new Actions(Driver.getDriver());
        actions.doubleClick(text).perform();

        String actual=text.getAttribute("style");
        System.out.println(actual);
        String expected="color: red;";

        Assert.assertTrue(actual.equals(expected));
    }
    @Test
    public void tc17_drag_and_drop(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement smallcircle=Driver.getDriver().findElement(By.id("draggable"));

        WebElement bigcircle=Driver.getDriver().findElement(By.id("droptarget"));
        actions=new Actions(Driver.getDriver());
       // actions.clickAndHold(smallcircle).moveToElement(bigcircle).release().perform();
        actions.dragAndDrop(smallcircle,bigcircle).perform();

        String actual=bigcircle.getText();
        String expected="You did great!";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void tc18(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        WebElement box=Driver.getDriver().findElement(By.id("hot-spot"));

        actions=new Actions(Driver.getDriver());
        actions.contextClick(box).perform();

        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();




    }
}
