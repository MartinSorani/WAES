package src.test.java.pageObject;

import org.openqa.selenium.WebDriver;
import src.test.java.pageObject.common.utilities.Log;

public class ProfilePage extends ProfilePage_map {

    private WebDriver driver;

    public ProfilePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        Log.info("Redirecting to profile page");
        assertUrl();
    }

    public ProfilePage clickProfileButton(){
        Log.info("Click profile button");
        btnProfile.click();
        return this;
    }

    public ProfilePage clickDetailsButton(){
        Log.info("Click details button");
        btnDetails.click();
        return this;
    }

    public LoginPage logOut(){
        Log.info("Click logout button");
        btnLogout.click();
        return new LoginPage(driver);
    }
}
