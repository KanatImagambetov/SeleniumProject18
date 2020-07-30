package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="prependedInput")
    public WebElement username;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(id="_submit")
    public WebElement button;

    @FindBy(xpath="//div[@class='alert alert-error']")
    public WebElement errorM;
    //forgot password link
    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotForgotLink;

    public void login(String username2, String password2){
        username.sendKeys(username2);
        password.sendKeys(password2);
        button.click();
    }
}
