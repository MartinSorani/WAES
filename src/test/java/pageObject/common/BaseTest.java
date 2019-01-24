package src.test.java.pageObject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import src.test.java.pageObject.LandingPage;
import src.test.java.pageObject.common.utilities.Log;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {}

    @AfterSuite
    public void tearDown() {
        Log.info("Terminating suite execution");
        driver.quit();
    }

    @AfterMethod
    public void cleanup(){
        Log.info("Terminating test execution");
        driver.quit();
    }

    public LandingPage test() {
        Log.info("Begin test case " + Thread.currentThread().getStackTrace()[2].getMethodName());
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        beginNavigation();
        return new LandingPage(driver);
    }

    private void beginNavigation() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(BasePage.BASE_URI);
    }
}
