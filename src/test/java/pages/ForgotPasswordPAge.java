package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPAge {
    public ForgotPasswordPAge(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="prependedInput")
    public WebElement inputBox;

    @FindBy(xpath="//button[.='Request']")
    public WebElement requestButton;
    //error message
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;
}
