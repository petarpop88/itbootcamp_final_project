package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {

    private By adminButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By citiesButton = By.xpath("/html/body/div/div[3]/div/a[1]/div[2]");
    private By newItemButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By enterNewCityNameField = By.id("name");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private By savedSucces = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By actionEdit = By.id("edit");
    private By editField = By.name("name");
    private By saveButtonEditItem = By.xpath("/html/body/div/div[5]/div/div/div[3]/button[2]");
    private By savedSuccesEditedItem = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By searchField = By.id("search");
    private By editedCityName = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");


    public AdminCitiesPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public WebElement getAdminButton() {
        return getWebDriver().findElement(adminButton);
    }
    public WebElement getCitiesButton() {
        return getWebDriver().findElement(citiesButton);
    }
    public WebElement getNewItemButton() {
        return getWebDriver().findElement(newItemButton);
    }
    public WebElement getEnterNewCityNameField() {
       // WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(enterNewCityNameField));
        //return element;
        return getWebDriver().findElement(enterNewCityNameField);
    }
    public WebElement getSavedSucces() {
        return getWebDriver().findElement(savedSucces);
    }
    public WebElement getSaveButton() {return getWebDriver().findElement(saveButton);}
    public WebElement getActionEdit() {
        return getWebDriver().findElement(actionEdit);
    }
    public WebElement getEditField() {
        return getWebDriver().findElement(editField);
    }
    public WebElement getSaveButtonEditItem() {
        return getWebDriver().findElement(saveButtonEditItem);
    }
    public WebElement getSavedSuccesEditedItem() {return getWebDriver().findElement(savedSuccesEditedItem);}
    public WebElement getSearchField() {return getWebDriver().findElement(searchField);}
    public WebElement getEditedCityName() {return getWebDriver().findElement(editedCityName);}

}

