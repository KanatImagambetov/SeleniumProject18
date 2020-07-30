package test.day7_javafaker_webtables;

import utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Select_task {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void task3(){
        //Select “December 1 , 1921” and verify it is selected.
        //   Select year using : visible text
        Select yearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1921");
        String yearActual=yearDropdown.getFirstSelectedOption().getText();
        String yearExpected = "1921";

        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("5");
        String monthActual=monthDropdown.getFirstSelectedOption().getText();
        String monthExpected = "June";

        Select dayDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(1);
        String dayActual=dayDropdown.getFirstSelectedOption().getText();
        String dayExpected = "2";

        Assert.assertEquals(yearActual, yearExpected);
        Assert.assertEquals(monthActual, monthExpected);
        Assert.assertEquals(dayActual, dayExpected);
    }
    /*
   @Test
    public void task3_select_date_test(){
        //Select “December 1 , 1921” and verify it is selected.
        //   Select year using : visible text
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1921");
        String yearActual = yearDropdown.getFirstSelectedOption().getText();
        String yearExpected = "1921";
        //   Select month using : value attribute
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11"); //--> will select December using attribute value
        String monthActual = monthDropdown.getFirstSelectedOption().getText();
        String monthExpected = "December";
        //   Select day using: index number
       Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);
        String dayActual = dayDropdown.getFirstSelectedOption().getText();
        String dayExpected = "1";
        //Asserting year dropdown values vs expected
        Assert.assertEquals(yearActual, yearExpected);
        //Asserting month dropdown values vs expected
        Assert.assertEquals(monthActual, monthExpected);
        //Asserting day dropdown values vs expected
        Assert.assertTrue(dayActual.equals(dayExpected));
    }
     */
}
