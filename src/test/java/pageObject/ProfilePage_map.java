package src.test.java.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pageObject.common.BasePage;

public class ProfilePage_map extends BasePage {

    //Functional elements
    @FindBy(id="profile_link")
    protected WebElement btnProfile;
    @FindBy(id="details_link")
    protected WebElement btnDetails;
    @FindBy(css="#status a")
    protected WebElement btnLogout;

    //Due to the limited time to create a proper assertion item, these elements will serve as condition
    @FindBy(css=".view-module--view--3wzVy h1+p")
    public static WebElement userDetails;
    @FindBy(css=".view-module--view--3wzVy p:nth-of-type(2)")
    public static WebElement userPowers;

    public ProfilePage_map(WebDriver driver){
        super(driver);
        setRelativeUri("app/profile");
        PageFactory.initElements(driver, this );
    }
}
