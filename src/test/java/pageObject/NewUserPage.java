package src.test.java.pageObject;

import org.openqa.selenium.WebDriver;
import src.test.java.pageObject.common.utilities.Log;

public class NewUserPage extends NewUserPage_map {

    private WebDriver driver;

    public NewUserPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        Log.info("Redirecting to new user page");
        assertUrl();
    }


}
