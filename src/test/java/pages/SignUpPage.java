package pages;

import com.github.javafaker.Faker;
import dev.failsafe.Fallback;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.sql.DriverManager.getDriver;

public class SignUpPage extends BasePage {

    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmPassword");
    private By signMeUpButton = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
    private By eMailExist = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]");
    private By importantMsg = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");


    public SignUpPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public WebElement getNameField() {
        return getWebDriver().findElement(nameField);
    }
    public WebElement getEmailField() {
        return getWebDriver().findElement(emailField);
    }
    public WebElement getPasswordField() {
        return getWebDriver().findElement(passwordField);
    }
    public WebElement getConfirmPasswordField() {
        return getWebDriver().findElement(confirmPasswordField);
    }
    public WebElement getSignMeUpButton() {
        return getWebDriver().findElement(signMeUpButton);
    }
    public WebElement getEmailExist () {
        return getWebDriver().findElement(eMailExist);
    }

    public WebElement getImportantMsg () {
        return getWebDriver().findElement(importantMsg);
    }

    //methods
    public void userCantSignUpWithExistingEmail () {
        String name = "Test Test";
        String email = "admin@admin.com";
        String password = "123654";
        String confirmPassword = "123654";

        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
        getSignMeUpButton().click();

    }
    public void signUp (String name, String email, String password, String confirmPassword) {

        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
        getSignMeUpButton().click();

    }

}
