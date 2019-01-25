package testCases;

import data.DataProviderSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pageObject.ProfilePage;
import pageObject.common.BasePage;
import pageObject.common.BaseTest;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "usersDetails", dataProviderClass = DataProviderSource.class)
    public void VerifyCorrectLogin(String username, String password, String userDetails){
        test()
                .goToLoginPage()
                .login(username, password)
                .assertThat(ExpectedConditions.textToBePresentInElement(BasePage.statusBarText, "Logged in as " + userDetails))
                .logOut();
    }

    @Test(dataProvider = "badLogin", dataProviderClass = DataProviderSource.class)
    public void VerifyIncorrectLogin(String username, String password){
        test()
                .goToLoginPage()
                .loginWithError(username, password)
                .assertThat(ExpectedConditions.textToBePresentInElement(BasePage.statusBarText, "Wrong credentials. You can do it, try again!"));
    }

    @Test(dataProvider = "usersDetails", dataProviderClass = DataProviderSource.class)
    public void VerifyCorrectUserDetails(String username, String password, String userDetails){
        test()
                .goToLoginPage()
                .login(username, password)
                .assertThat(ExpectedConditions.textToBePresentInElement(ProfilePage.userDetails, userDetails))
                .logOut();
    }
}
