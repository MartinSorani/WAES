package src.test.java.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pageObject.common.BasePage;

public class NewUserPage_map extends BasePage {

    //Functional elements
    @FindBy(id="profile_link")
    protected WebElement btnProfile;
    @FindBy(id="details_link")
    protected WebElement btnDetails;
    @FindBy(css="#status a")
    protected WebElement btnLogout;

    //Assertion elements
    @FindBy(css=".view-module--view--3wzVy p")
    public static WebElement lblWelcomeMessage;

    public NewUserPage_map(WebDriver driver){
        super(driver);
        setRelativeUri("app/newUser");
        PageFactory.initElements(driver, this);
    }
}
