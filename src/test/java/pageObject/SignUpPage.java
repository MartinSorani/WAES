package pageObject;

import com.sun.media.sound.InvalidFormatException;
import org.apache.commons.validator.EmailValidator;
import org.openqa.selenium.WebDriver;
import pageObject.common.utilities.Log;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SignUpPage extends SignUpPage_map {

    private WebDriver driver;

    public  SignUpPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        Log.info("Redirecting to sign up page");
        assertUrl();
    }

    public SignUpPage enterUserName(String username){
        Log.info("Enter username: " + username);
        txtUsername.sendKeys(username);
        return this;
    }

    public SignUpPage enterPassword(String password){
        Log.info("Enter password: " + password);
        txtPassword.sendKeys(password);
        return this;
    }

    public SignUpPage enterName(String name){
        Log.info("Enter name: " + name);
        txtName.sendKeys(name);
        return this;
    }

    public SignUpPage enterEmail(String email){
        try {
            validateEmailFormat(email);
        }
        catch (InvalidFormatException e){
            Log.info("Invalid email format. Terminating execution");
            driver.quit();
            return this;
        }
        Log.info("Enter email: " + email);
        txtEmail.sendKeys(email);
        return this;
    }

    public SignUpPage enterDay(String day){
        Log.info("Enter day of birth: " + day);
        lstDayOfBirth().selectByValue(day);
        return this;
    }

    public SignUpPage enterMonth(String month){
        Log.info("Enter month of birth: " + month);
        lstMonthOfBirth().selectByValue(month);
        return this;
    }

    public SignUpPage enterYear(String year){
        Log.info("Enter year of birth: " + year);
        lstYearOfBirth().selectByValue(year);
        return this;
    }

    public NewUserPage clickSubmitButton(){
        Log.info("Click submit button");
        btnSubmit.click();
        return new NewUserPage(driver);
    }

    public NewUserPage signUp(String username, String password, String name, String email, LocalDate dateOfBirth){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        String formattedString = dateOfBirth.format(formatter);
        String[] fullDate = formattedString.split("-");
        String day = fullDate[0];
        String month = fullDate[1];
        String year = fullDate[2];

        return enterUserName(username)
                .enterPassword(password)
                .enterName(name)
                .enterEmail(email)
                .enterDay(day)
                .enterMonth(month)
                .enterYear(year)
                .clickSubmitButton();
    }

    private void validateEmailFormat(String email) throws InvalidFormatException {
        email = email.trim();
        EmailValidator eValidator = EmailValidator.getInstance();
        if(!eValidator.isValid(email))
            throw new InvalidFormatException("Invalid email format!");
    }
}
