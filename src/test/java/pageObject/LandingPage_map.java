package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import pageObject.common.BasePage;

public class LandingPage_map extends BasePage {

    private WebDriver driver;

    @FindBy(id="login_link")
    protected WebElement btnLogin;
    @FindBy(id="signup_link")
    protected WebElement btnSignUp;


    public LandingPage_map(WebDriver driver){
        super(driver);
        this.driver = driver;
        setRelativeUri("");
        PageFactory.initElements(driver, this );
    }

    @Override
    public LandingPage assertThat(ExpectedCondition expectedCondition) {
        return (LandingPage) assertionMethod(expectedCondition, new LandingPage(driver) );
    }
}
