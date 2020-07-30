package test.day12_synchronization;

import utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1PAge;
import pages.Loading7Page;

/*
TC#40 : Dynamically Loaded Page Elements 7
    1. Go to http://practice.cybertekschool.com/dynamic_loading/7
    2. Wait until title is “Dynamic Title”
    3. Assert : Message “Done” is displayed.
    4. Assert : Image is displayed.
    Note: Follow POM
 */
public class ExplicitWaitPractices {
    @Test
    public void t40() {
        String url = "http://practice.cybertekschool.com/dynamic_loading/7";
        Driver.getDriver().get(url);

        Loading7Page loading7Page=new Loading7Page();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
        String expectedTitle="Dynamic title";
        wait.until(ExpectedConditions.titleIs(expectedTitle));

        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());
        Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());
    }
    @Test
    public void tc41(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        Loading1PAge loading1PAge=new Loading1PAge();
        loading1PAge.startButton.click();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(loading1PAge.loadingBar));

        Assert.assertTrue(loading1PAge.usernameInput.isDisplayed());

        loading1PAge.usernameInput.sendKeys("tomsmith");
        loading1PAge.passwordInput.sendKeys("sdsdsa");
        loading1PAge.submitButton.click();

        Assert.assertTrue(loading1PAge.errorMessage.isDisplayed());
    }


}
