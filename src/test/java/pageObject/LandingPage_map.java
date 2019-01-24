package src.test.java.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pageObject.common.BasePage;

public class LandingPage_map extends BasePage {

    @FindBy(id="login_link")
    protected WebElement btnLogin;
    @FindBy(id="signup_link")
    protected WebElement btnSignUp;


    public LandingPage_map(WebDriver driver){
        super(driver);
        setRelativeUri("");
        PageFactory.initElements(driver, this );
    }
}
