package test.day3_cssSelector;

import utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Example {
    public static void main(String[] args) {
        WebDriver driver=WebDriverFactory.getDriver("chrome");

        driver.get("https://www.google.com");
    }
}
