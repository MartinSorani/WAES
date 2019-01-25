package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pageObject.NewUserPage_map;
import pageObject.common.BaseTest;

import java.time.LocalDate;
import java.time.Month;

public class SignUpTests extends BaseTest {
    @Test
    public void VerifyCorrectSignup(){
        test()
                .gotoSignUpPage()
                .signUp("username1", "password1", "name1", "email@test.com", LocalDate.of(1998, Month.MAY, 16) )
                .assertThat(ExpectedConditions.textToBePresentInElement(NewUserPage_map.lblWelcomeMessage, "name1"));
    }
}
