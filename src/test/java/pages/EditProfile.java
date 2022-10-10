package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void editProfile() {

        Faker faker = new Faker();


    }
}
