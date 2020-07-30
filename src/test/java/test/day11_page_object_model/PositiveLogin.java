package test.day11_page_object_model;

import utilities.ConfigurationReader;
import utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class PositiveLogin {
    LoginPage loginpage;
    @Test
    public void store_magager(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginpage=new LoginPage();

        String username1=ConfigurationReader.getProperty("storemanager_username");
        String password1=ConfigurationReader.getProperty("storemanager_password");

        loginpage.login(username1,password1);
        String actual=Driver.getDriver().getTitle();
        String expected="Dashboard";
        Assert.assertEquals(actual,expected);

    }
}
