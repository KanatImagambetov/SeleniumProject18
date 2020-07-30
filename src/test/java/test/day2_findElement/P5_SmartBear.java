package test.day2_findElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_SmartBear {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String actualTitle=driver.getTitle();
        String expectTitle="Web Orders Login";

        if(actualTitle.startsWith(expectTitle)){
            System.out.println("Google search title verification PASSED!");
        }else{
            System.out.println("Google search title verificsation FAILED");
        }

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");

        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        String actualTitle1=driver.getTitle();
        String expectTitle1="Web Orders";

        if(actualTitle1.equals(expectTitle1)){
            System.out.println("Web Orders title verification PASSED!");
        }else{
            System.out.println("Web Orders title verificsation FAILED");
        }
  //      driver.close();

    }
}
