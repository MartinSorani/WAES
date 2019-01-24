package src.test.java.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import src.test.java.pageObject.common.BasePage;

public class SignUpPage_map extends BasePage {

    //Functional elements
    @FindBy(id="username_input")
    protected WebElement txtUsername;
    @FindBy(id="password_input")
    protected WebElement txtPassword;
    @FindBy(id="name_input")
    protected WebElement txtName;
    @FindBy(id="email_input")
    protected WebElement txtEmail;
    @FindBy(id="day_select")
    private WebElement lstDayOfBirth;
    protected Select lstDayOfBirth() {
        return new Select(lstDayOfBirth);
    }
    @FindBy(id="month_select")
    private WebElement lstMonthOfBirth;
    protected Select lstMonthOfBirth() {
        return new Select(lstMonthOfBirth);
    }
    @FindBy(id="year_select")
    private WebElement lstYearOfBirth;
    protected Select lstYearOfBirth() {
        return new Select(lstYearOfBirth);
    }
    @FindBy(id="submit_button")
    protected WebElement btnSubmit;

    public SignUpPage_map(WebDriver driver){
        super(driver);
        setRelativeUri("app/signUp");
        PageFactory.initElements(driver, this );
    }
}
