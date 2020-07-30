package test.day12_synchronization;

import utilities.ConfigurationReader;
import utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPAge;
import pages.LoginPage;

/*
    1. Go to https://qa2.vytrack.com
    2. Click to “Forgot your password?” link
    3. Verify title changed to expected
        Expected: “Forgot Password”
    4. Verify url is as expected:
        Expected: “https://qa2.vytrack.com/user/reset-request”
       Note: Follow Page Object Model design pattern
 */
public class ForgotPasswordTests {
    @Test
    public void tc35_title_url_verification(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginpage=new LoginPage();
        loginpage.forgotForgotLink.click();

        String expected="Forgot Password";
        String actual=Driver.getDriver().getTitle();
        Assert.assertEquals(actual,expected);

        String expectedUrl = "https://qa2.vytrack.com/user/reset-request";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
   /*
    TC#36 : Vytrack forgot password page verification->ERROR MESSAGE
        1. Go to https://qa3.vytrack.com/user/reset-request
        2. Enter random username
        3. Click to request button
        4. Verify error message is displayed
        5. Verify error message text is as expected.
        Expected: There is no active user with username or email address “given text”.
        Note: Follow Page Object Model design pattern
     */
   @Test
    public void tc36(){
       Driver.getDriver().get(ConfigurationReader.getProperty("forgotpassword_url"));

       ForgotPasswordPAge forgot=new ForgotPasswordPAge();

       String randomString="assffsse";
       forgot.inputBox.sendKeys(randomString);

       forgot.requestButton.click();

       Assert.assertTrue(forgot.errorMessage.isDisplayed());

       String expectedmessage="There is no active user with username or email address \""+randomString+"\".";
       String actualmessage=forgot.errorMessage.getText();

       Assert.assertEquals(expectedmessage,actualmessage);
   }
}
