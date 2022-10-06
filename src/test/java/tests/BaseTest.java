package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LocalePage;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected LoginPage loginPage;
    protected Faker faker;
    protected HomePage homePage;

    protected AdminCitiesPage adminCitiesPage;
    //protected Select selectEl;

    protected LocalePage localePage;


    @BeforeClass
    public void beforeClass () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Local\\webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        loginPage = new LoginPage(driver, webDriverWait);
        homePage = new HomePage(driver, webDriverWait);
        adminCitiesPage = new AdminCitiesPage(driver, webDriverWait);
        localePage = new LocalePage(driver, webDriverWait);

        faker = new Faker();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


    }
    @BeforeMethod
    public void beforeMethod (){
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }
    public WebDriver getDriver() {
        return driver;
    }


   /*@AfterClass
    public void afterClass () {
     driver.quit();
 }
    /*@AfterMethod
    public void logOut () {
        homePage.getLogOutButton().click();
    }
*/

}
