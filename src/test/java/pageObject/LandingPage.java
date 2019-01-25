package pageObject;

import org.openqa.selenium.WebDriver;
import pageObject.common.utilities.Log;

public class LandingPage extends LandingPage_map {

    private WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        Log.info("Redirecting to landing page");
        assertUrl();
    }

    public LoginPage goToLoginPage(){
        Log.info("Click login link");
        btnLogin.click();
        return new LoginPage(driver);
    }

    public SignUpPage gotoSignUpPage(){
        btnSignUp.click();
        return new SignUpPage(driver);
    }
}
