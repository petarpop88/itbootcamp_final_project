package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTest {
    String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    String home = "https://vue-demo.daniel-avellaneda.com/home";
    String profile = "https://vue-demo.daniel-avellaneda.com/profile";
    String adminCities = "https://vue-demo.daniel-avellaneda.com/admin/cities";

    String adminUsers = "https://vue-demo.daniel-avellaneda.com/admin/users";
    protected WebDriver driver;

    protected WebDriverWait webDriverWait;
    protected LoginPage loginPage;

    protected Faker faker;
    protected HomePage homePage;
    protected AdminCitiesPage adminCitiesPage;
    protected LocalePage localePage;
    protected SignUpPage signUpPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Local\\webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver, webDriverWait);
        homePage = new HomePage(driver, webDriverWait);
        adminCitiesPage = new AdminCitiesPage(driver, webDriverWait);
        localePage = new LocalePage(driver, webDriverWait);
        signUpPage = new SignUpPage(driver, webDriverWait);

        faker = new Faker();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    /*@AfterMethod
    public void logOutUser() {
        homePage.getLogOutButton().click();
    }
    */
}
