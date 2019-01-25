package pageObject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.common.utilities.Log;


public abstract class BasePage<T> implements IBasePage {

    private WebDriver driver;

    //Status bar across all pages
    @FindBy(css="#status p")
    public static WebElement statusBarText;

    protected final Integer TIMEOUT = 5;

    protected final String DEFAULT_USERNAME = "tester";
    protected final String DEFAULT_PASSWORD = "maniac";

    public static final String BASE_URI = "https://waesworks.bitbucket.io/";
    protected static String relativeUri;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        setRelativeUri("");
        PageFactory.initElements(driver, this );
    }

    public void setRelativeUri(String relativeUri) {
        this.relativeUri = relativeUri;
    }

    public String getRelativeUri() {
        return relativeUri;
    }

    public void assertUrl() {
        String expectedUrl = BASE_URI + getRelativeUri();
        Log.info("Verify the url is " + expectedUrl);
        waitForUrlContains(relativeUri);
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    //Sorry, I don't have the time to create and debug an elaborated assertion item, this will have to do =(
    public abstract <T extends BasePage> T assertThat(ExpectedCondition<Boolean> expectedCondition);

    public <T extends BasePage> T assertionMethod(ExpectedCondition<Boolean> expectedCondition, T page){
        Log.info("Evaluating assertion");
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
            wait.until(expectedCondition);
            Assert.assertTrue(expectedCondition.apply(driver), "Conditions were not met");
        }
        catch (Exception e){
            throw new AssertionError("Assertion failed: " + e.getMessage());
        }
        Log.info("Assertion successful");
        return page;
    }

    public void waitForUrlContains(String expectedUri) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition<Boolean> urlContains = arg0 -> driver.getCurrentUrl().contains(expectedUri);
        wait.until(urlContains);
    }
}
