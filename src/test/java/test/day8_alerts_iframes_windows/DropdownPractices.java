package test.day8_alerts_iframes_windows;

import utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractices {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test (priority = 1)
    public void p7() {
        // Locating the dropdown
        Select monthDown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        //We need to create our actual and expected values.
        String actualDropdown = monthDown.getFirstSelectedOption().getText();
        System.out.println("actualDropdown = " + actualDropdown);
        String expectedDropdown = LocalDateTime.now().getMonth().name();
        System.out.println("expectedDropdown = " + expectedDropdown);
        //1- First way of doing this assertion
        Assert.assertEquals(actualDropdown.toLowerCase(), expectedDropdown.toLowerCase());
        //2- Second way of doing same assertion
        Assert.assertTrue(actualDropdown.equalsIgnoreCase(expectedDropdown));
        //PRACTICE #8:
        // Storing all of the options in the month dropdown into the list of web elements
    }
    @Test (priority = 2)
    public void p8(){
        Select monthDown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        List<WebElement> actualDropdownOptions=monthDown.getOptions();
        List<String> expectedDropdownOptions = Arrays.asList("January", "February", "March", "April", "May", "June"
                , "July", "August", "September", "October", "November", "December");
        //We create a list of Strings just as to use as a container to the texts of actual dropdown values
        List<String> actualMonthsText=new ArrayList<>();
        for (WebElement each : actualDropdownOptions) {
            actualMonthsText.add(each.getText());
 //           System.out.println(actualMonthsText);
        }
        Assert.assertEquals(actualMonthsText,expectedDropdownOptions);
    }
}

