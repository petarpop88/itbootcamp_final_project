package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{


    private By logOutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
      //    //*[@id="app"]/div[1]/div/header/div/div[3]/button[2]/span
     //      /html/body/div/div[1]/div/header/div/div[3]/button[2]/span


    public HomePage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);

    }

    public WebElement getLogOutButton () {
        return getWebDriver().findElement(logOutButton);
    }
}

