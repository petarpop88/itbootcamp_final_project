package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class EditProfile extends BasePage {
    private By name = By.id("name");
    private By phone = By.id("phone");
    private By city = By.id("city");
    private By country = By.id("country");
    private By twitter = By.name("urlTwitter");
    private By github = By.name("urlGitHub");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");


    public EditProfile(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);

    }

    public WebElement getName() {
        return getWebDriver().findElement(name);
    }

    public WebElement getPhone() {
        return getWebDriver().findElement(phone);
    }

    public WebElement getCity() {
        return getWebDriver().findElement(city);
    }

    public WebElement getCountry() {
        return getWebDriver().findElement(country);
    }

    public WebElement getTwitter() {
        return getWebDriver().findElement(twitter);
    }

    public WebElement getGithub() {
        return getWebDriver().findElement(github);
    }

    public WebElement getSaveButton() {
        return getWebDriver().findElement(saveButton);
    }

    public void editProfileWithRandomData() {

        Faker faker = new Faker();

        getName().click();
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getName().sendKeys(faker.name().firstName());

        getPhone().click();
        getPhone().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getPhone().sendKeys(faker.phoneNumber().phoneNumber());

        getCity().click();
        getCity().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCity().sendKeys(faker.gameOfThrones().city());

        getCountry().click();
        getCountry().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCountry().sendKeys(faker.address().country());

        getTwitter().click();
        getTwitter().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getTwitter().sendKeys("https://twitter.com/" + faker.name().username());

        getGithub().click();
        getGithub().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getGithub().sendKeys("https://github.com/" + faker.name().username());

        getSaveButton().click();

    }
}
