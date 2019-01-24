package src.test.java.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pageObject.common.BasePage;

public class LoginPage_map extends BasePage {

    //Functional elements
    @FindBy(id="username_input")
    protected WebElement txtUsername;
    @FindBy(id="password_input")
    protected WebElement txtPassword;
    @FindBy(id="login_button")
    protected WebElement btnLogin;
    @FindBy(id="signup_link")
    protected WebElement btnSignup;


    public LoginPage_map(WebDriver driver){
        super(driver);
        setRelativeUri("app/login");
        PageFactory.initElements(driver, this );
    }
}
