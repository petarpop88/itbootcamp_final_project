package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    private WebDriverWait webDriverWait;
    protected LoginPage loginPage;


    @BeforeClass
    public void beforeClass () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Local\\webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        loginPage = new LoginPage(driver, webDriverWait);
        driver.manage().window().maximize();


    }
    @BeforeMethod
    public void beforeMethod (){
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }
    public WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
    @AfterClass
    public void afterClass () {
       driver.quit();
   }
}
