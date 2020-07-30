package test.day7_javafaker_webtables;

import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Smart {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }
    @Test (priority = 1)
    public void p1(){
        //6. Print out count of all the links on landing page
        List<WebElement> all=driver.findElements(By.xpath("//body//a"));
        int expectedNumberOfLinks=6;
        int actualNumberOfLinks=all.size();
        Assert.assertEquals(actualNumberOfLinks,6);
        for (WebElement link:all){
            System.out.println(link.getText());
        }
    }
    @Test (priority = 3)
    public void  p2(){
        //TC#2: Smartbear software order placing
        //6. Click on Order
        WebElement orderlist=driver.findElement(By.xpath("//a[.='Order']"));
        orderlist.click();
        //7. Select familyAlbum from product, set quantity to 2
        Select product=new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        product.selectByVisibleText("FamilyAlbum");
        WebElement quantity=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        //quantityInput.clear(); //just deletes if there is any existing input in the input box.
        //Thread.sleep(1000);
        //Imitating as if the user is pressing the BACKSPACE key on keyboard to delete something.
        quantity.sendKeys(Keys.BACK_SPACE);
        quantity.sendKeys("2");
        //8. Click to “Calculate” button
        WebElement calculation=driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculation.click();
        //9. Fill address Info with JavaFaker
        WebElement Name=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement Str=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement City=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement State=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement Zip=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        Faker faker=new Faker();
        //• Generate: name, street, city, state, zip code
        // Entering name using javafaker.
        Name.sendKeys(faker.name().fullName());
        Str.sendKeys(faker.address().streetName());
        City.sendKeys(faker.address().city());
        State.sendKeys(faker.address().state());
        Zip.sendKeys(faker.address().zipCode().replace("-",""));
        //10. Click on “visa” radio button
        WebElement Radio=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        Radio.click();
        //11. Generate card number using JavaFaker
        WebElement Card=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        //Entering credit card number using faker
        Card.sendKeys(faker.finance().creditCard().replace("-",""));
        //Entering date
        WebElement expDate=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expDate.sendKeys("12/25");
        //12. Click on “Process”
        WebElement Button=driver.findElement(By.xpath("//a[.='Process']"));
        Button.click();
        //13.Verify success message “New order has been successfully added.”
        //strong
        WebElement successMessage=driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        Assert.assertTrue(successMessage.isDisplayed());

    }
    /*
    @Test (priority = 2)
    public void p3(){
        //2. Click on View all orders
        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement sussanDate=driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
        String extectedDate="01/05/2010";
        String actualDate=sussanDate.getText();
        Assert.assertEquals(actualDate,extectedDate);
    }

     */
    }
