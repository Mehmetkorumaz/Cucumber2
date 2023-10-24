package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {


    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy(linkText = " Signup / Login")
    public WebElement loginButtonu;
    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement eMail;

    @FindBy(xpath = "//*[@data-qa='login-password']")
    public WebElement password;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement login2;


}
