package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{

    private By adminButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By citiesButton = By.xpath("/html/body/div/div[3]/div/a[1]/div[2]");
    private By newItemButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By enterNewCityNameField = By.id("name");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");

    private By savedSucces = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    public AdminCitiesPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }
    public WebElement getAdminButton () {
        return getWebDriver().findElement(adminButton);
    }
    public WebElement getCitiesButton () {
        return getWebDriver().findElement(citiesButton);
    }
    public WebElement getNewItemButton () {
        return getWebDriver().findElement(newItemButton);
    }
    public WebElement getEnterNewCityNameField () {
        return getWebDriver().findElement(enterNewCityNameField);
    }

    public WebElement getSavedSucces () {
        return getWebDriver().findElement(savedSucces);
    }
    public WebElement getSaveButton () {
        return getWebDriver().findElement(saveButton);
    }
}
