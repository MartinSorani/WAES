package src.test.java.pageObject;

import org.openqa.selenium.WebDriver;
import src.test.java.pageObject.common.utilities.Log;

public class LoginPage extends LoginPage_map {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        Log.info("Redirecting to login page");
        assertUrl();
    }

    public LoginPage enterUsername(String username) {
        Log.info("Enter username " + username);
        txtUsername.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        Log.info("Enter password " + password);
        txtPassword.sendKeys(password);
        return this;
    }

    public ProfilePage clickLoginButton() {
        Log.info("Click login button");
        btnLogin.click();
        return new ProfilePage(driver);
    }

    public ProfilePage login(String username, String password) {
        return enterLoginInfo(username, password);
    }

    public LoginPage loginWithError(String username, String password){
        return enterUsername(username)
                .enterPassword(password)
                .clickLoginButtonFail();
    }

    public LoginPage clickLoginButtonFail() {
        Log.info("Click login button and fail to login");
        btnLogin.click();
        return this;
    }

    public ProfilePage login(){
        return login(DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }

    private ProfilePage enterLoginInfo(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }
}
