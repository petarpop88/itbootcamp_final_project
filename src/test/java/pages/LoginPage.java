package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By email = By.id("email");
    private By password = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By loginPageClick = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By errorMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");
    private By userDoesntExist = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By wrongPasswordMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");


    public LoginPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public WebElement getEmail() {
        return getWebDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getWebDriver().findElement(password);
    }

    public WebElement getLoginButton() {
        return getWebDriver().findElement(loginButton);
    }

    public WebElement getLoginPageClick() {
        return getWebDriver().findElement(loginPageClick);
    }

    public WebElement getErrorMessage() {
        return getWebDriver().findElement(errorMessage);
    }

    public WebElement getUserDoesntExist() {
        return getWebDriver().findElement(userDoesntExist);
    }

    public WebElement getWrongPasswordMessage() {
        return getWebDriver().findElement(wrongPasswordMessage);
    }

    //methods
    public void clickOnloginPage() {
        getLoginPageClick().click();

    }

    public void login(String email, String password) {
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginButton().click();

    }


}
