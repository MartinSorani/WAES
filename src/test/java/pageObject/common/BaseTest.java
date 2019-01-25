package pageObject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObject.LandingPage;
import pageObject.common.utilities.Log;
import org.testng.ITestContext;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    private String browser;

    @BeforeSuite
    public void setUp(ITestContext context) {
        Log.info("Selected browser: " + getBrowser(context));
    }

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

    private String getBrowser(ITestContext context){
        return context.getCurrentXmlTest().getParameter("browser");;
    }

    private void createDriver(String browser){
        switch (browser.toLowerCase()){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
        }
    }
}
