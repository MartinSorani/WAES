import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src.test.java.data.DataProviderSource;
import src.test.java.pageObject.ProfilePage;
import src.test.java.pageObject.common.BasePage;
import src.test.java.pageObject.common.BaseTest;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "usersDetails", dataProviderClass = DataProviderSource.class)
    public void VerifyCorrectLogin(String username, String password, String userDetails){
        test()
                .goToLoginPage()
                .login(username, password)
                .assertThat(ExpectedConditions.textToBePresentInElement(BasePage.statusBarText, "Logged in as " + userDetails));
    }

    @Test
    @Parameters({"wrongUsername", "badPassword"})
    public void VerifyIncorrectLogin(String username, String password){
        test()
                .goToLoginPage()
                .loginWithError(username, password)
                .assertThat(ExpectedConditions.textToBePresentInElement(BasePage.statusBarText, "Stupid asshole"));
    }

    @Test(dataProvider = "usersDetails", dataProviderClass = DataProviderSource.class)
    public void VerifyCorrectUserDetails(String username, String password, String userDetails){
        test()
                .goToLoginPage()
                .login(username, password)
                .assertThat(ExpectedConditions.textToBePresentInElement(ProfilePage.userDetails, userDetails));
    }
}
